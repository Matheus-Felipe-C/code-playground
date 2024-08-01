-- Q1 - Crie uma view chamada Clientes que retorne uma lista com o 
-- nome e e-mail do cliente, o número e o dígito da conta corrente, o nome do banco e o 
-- número da agência de todas as contas correntes. O nome das colunas do seu resultado devem ser iguais ao da imagem de saída. 
-- Ordene o resultado pelo nome do banco e depois pelo número da agência;

create view Clientes as
	select 
		cli.nome as Cliente,
		cli.email as "Email do Cliente",
		cc.numero as "Número Conta",
		cc.digito as "Dígito",
		b.nome as Banco,
		ag.numero as "Número Ag"
	from cliente cli
	join
		conta_corrente cc on cli.numero = cc.cliente_numero
	join
		banco b on cc.banco_numero = b.numero
	join
		agencia ag on cc.agencia_numero = ag.numero and cc.banco_numero = ag.banco_numero
	order by
		b.nome, 
		ag.numero;
    
select * from Clientes;

-- Q2 - Uma informação sempre necessária é a quantidade atual de transações que uma determinada instituição bancária já realizou. 
-- Crie uma view chamada QuantidadeTransacoes, essa view deve conter o nome do banco e a quantidade de transações 
-- que cada um deles já realizou. Ordene pela maior quantidade de transações.

create view QuantidadeTransacoes as
    select ban.nome, count(ct.id) as qtde
    from cliente_transacoes ct
    join conta_corrente co on ct.banco_numero = co.banco_numero
        and ct.agencia_numero = co.agencia_numero
        and ct.banco_numero = co.banco_numero
        and ct.conta_corrente_numero = co.numero
        and ct.conta_corrente_digito = co.digito
        and ct.cliente_numero = co.cliente_numero
    join agencia ag on co.banco_numero = ag.banco_numero
        and co.agencia_numero = ag.numero
    join banco ban on ag.banco_numero = ban.numero
    group by ban.numero;
    
select * from QuantidadeTransacoes
order by qtde desc;

-- Q3 - Crie uma view chamada MultiplasContas, essa view deverá trazer nome, e-mail e número de conta de todos os clientes 
-- que possuírem mais de uma conta corrente. Ordene saída por nome e número de conta.

create view MultiplasContas as
	select 
		cli.nome, cli.email, cc.numero
	from cliente cli
    join
		conta_corrente cc on cli.numero = cc.cliente_numero
	where cli.numero in (
		select
			cliente_numero
		from conta_corrente
        group by cliente_numero
        having count(numero) > 1
    )
	order by
		cli.nome,
        cc.numero;
select * from MultiplasContas;

-- Q4: Crie uma função chamada get_transacoes_mais_frequentes, que receberá como parâmetros o número e digito de uma conta corrente 
-- e retornará o tipo de transação que essa conta mais realiza. Para saber quantas operações de cada tipo uma conta fez, 
-- considere as tabelas cliente_transacoes e tipo_transacao

DELIMITER $$

CREATE FUNCTION get_transacoes_mais_frequentes(
    p_conta_corrente_numero BIGINT,
    p_conta_corrente_digito SMALLINT
) RETURNS VARCHAR(50)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_tipo_transacao_nome VARCHAR(50);

    SELECT 
        tt.nome
    INTO 
        v_tipo_transacao_nome
    FROM 
        cliente_transacoes ct
    JOIN 
        tipo_transacao tt ON ct.tipo_transacao_id = tt.id
    WHERE 
        ct.conta_corrente_numero = p_conta_corrente_numero
        AND ct.conta_corrente_digito = p_conta_corrente_digito
    GROUP BY 
        tt.nome
    ORDER BY 
        COUNT(*) DESC
    LIMIT 1;

    RETURN v_tipo_transacao_nome;
END$$

DELIMITER ;

SELECT get_transacoes_mais_frequentes(, 1);

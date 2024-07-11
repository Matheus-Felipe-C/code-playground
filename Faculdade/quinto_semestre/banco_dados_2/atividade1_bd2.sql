select cliente_id, funcionario_id, valor, data_pagamento 
from pagamento
order by valor desc;

select nome, sobrenome
from cliente
where loja_id = 2;

select classificacao, count(classificacao)
from filme
group by classificacao;

select min(valor), max(valor), sum(valor)
from pagamento
where cliente_id = 1;

select funcionario_id, count(pagamento_id), sum(valor)
from pagamento
group by funcionario_id;

select duracao_aluguel, count(duracao_aluguel)
from filme
group by duracao_aluguel
having count(duracao_aluguel) > 55;

select funcionario_id, sum(valor)
from pagamento
group by funcionario_id;

select titulo, ano_lancamento
from filme
where classificacao = "R"
order by duracao desc
limit 3;

select cliente_id, count(aluguel_id)
from aluguel
group by cliente_id
order by count(aluguel_id) desc
limit 5;

select pais_id, count(cidade_id) as qtde
from cidade
group by pais_id
having qtde > 30
order by qtde desc;

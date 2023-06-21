package q2;

public class Produto {
	private int codigo;
	private String nome;
	private float preco;
	private int estoque;
	private int estoqueMin;
	
	public Produto(int codigo, String nome, float preco, int estoque, int estoqueMin) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.estoque = estoque;
		this.estoqueMin = estoqueMin;
	}
	
	public int getSituacao() {
		if (getEstoque() > getEstoqueMin()) return 0;
		else return 1;
	}
	
	public void relatorio() {
		System.out.println("Os valores do " + getNome() + "São:\n");
		System.out.println("Estoque atual: " + getEstoque());
		System.out.println("Estoque minimo: " + getEstoqueMin());
		
		if (getSituacao() == 1) System.out.println("Precisa renovar estoque");
	}

	//Getters and Setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		if (estoque > 1000) {
			System.out.println("Valor de estoque maior que o permitido.\nValor maximo de 1000 unidades");
			return;
		}
		this.estoque = estoque;
	}

	public int getEstoqueMin() {
		return estoqueMin;
	}

	public void setEstoqueMin(int estoqueMin) {
		this.estoqueMin = estoqueMin;
	}
}

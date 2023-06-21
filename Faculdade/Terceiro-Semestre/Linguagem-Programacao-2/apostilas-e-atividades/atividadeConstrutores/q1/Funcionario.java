package q1;

public class Funcionario {
	private String nome;
	private int horasTrabalhadas;
	private float valorHora;
	
	public Funcionario(String nome, int horasTrabalhadas, float valorHora) {
		this.nome = nome;
		this.horasTrabalhadas = horasTrabalhadas;
		this.valorHora = valorHora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}
	
	public float getSalario() {
		return this.valorHora * this.getHorasTrabalhadas();
	}
	
	public void exibeDados() {
		String s = "Nome: " + this.getNome();
		s += "\nHoras trabalhadas: " + this.getHorasTrabalhadas();
		s += "\nValor por hora:" + this.getValorHora();
		s += "\nSalário:" + this.getSalario();
		
		System.out.println(s);
	}
}
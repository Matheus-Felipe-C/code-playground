package q4;

public class LivroLivraria {
    private String nome;
    private int isbn;
    private String emprestadoA;
    
    public LivroLivraria(String nome, int isbn, String emprestadoA) {
        this.nome = nome;
        this.isbn = isbn;
        this.emprestadoA = emprestadoA;
    }

    public LivroLivraria(String nome, int isbn) {
        this.nome = nome;
        this.isbn = isbn;
        this.emprestadoA = "-";
    }
    
    @Override
    public String toString() {
        return "LivroLivraria [nome=" + nome + ", isbn=" + isbn + ", emprestadoA=" + emprestadoA + "]";
    }

    //Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getEmprestadoA() {
        return emprestadoA;
    }

    public void setEmprestadoA(String emprestadoA) {
        this.emprestadoA = emprestadoA;
    }

}

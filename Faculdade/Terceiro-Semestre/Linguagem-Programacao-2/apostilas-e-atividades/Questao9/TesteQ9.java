package Questao9;

import java.util.Scanner;

public class TesteQ9 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        var caderno = new CadernoDeEnderecos();
        
        System.out.println("Digite o nome:");
        String nome = scan.nextLine();
        caderno.setNome(nome);

        System.out.println("Digite o telefone:");
        String telefone = scan.nextLine();
        caderno.setTelefone(telefone);

        System.out.println("Digite o email:");
        String email = scan.nextLine();
        caderno.setEmail(email);

        System.out.println("Digite o endereco");
        String endereco = scan.nextLine();
        caderno.setEndereco(endereco);

        System.out.println("O endereço de " + caderno.getNome() + " é:" + caderno.getEndereco());
        System.out.println("\nInformações de contato: ");
        System.out.println("Email - " + caderno.getEmail());
        System.out.println("Telefone - " + caderno.getTelefone());
    }
}

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        TaskManager taskManager = new TaskManager();
        Scanner scan = new Scanner(System.in);
        
        boolean next = true;
        String input = "";

        System.out.println("Bem vindo!");
        
        while (next) {
            System.out.println("Escolha uma opção:\n");
            System.out.println("1 - Adicionar uma tarefa");
            System.out.println("2 - Ver lista de tarefas");
            System.out.println("3 - Completar uma tarefa");
            System.out.println("4 - Ver tarefas concluídas");
            System.out.println("0 - Sair");

            input = scan.nextLine();

            switch (input) {
                case "0":
                    next = false;
                    break;
                case "1":
                    System.out.println("Digite o nome da tarefa a ser adicionada");
                    String nameTask = scan.nextLine();
                    taskManager.addTask(nameTask);
                    break;
                case "2":
                    System.out.println(taskManager.readTaskList()); 
                    break;
                case "3":
                    taskManager.readTaskList();
                    System.out.println("Digite o id da tarefa a ser completada");
                    String id = scan.nextLine();
                    System.out.println("Digite o tempo gasto em minutos(no formato minuto:segundo) na tarefa");
                    String time = scan.nextLine();
                    taskManager.completeTask(Integer.parseInt(id), time);
                    break;
                case "4":
                    System.out.println(taskManager.seeCompleted());
                    break;
                default:
                    System.out.println("Opção inválida, favor inserir uma opção válida");
                    break;
            }
        }
        scan.close();
    }
}

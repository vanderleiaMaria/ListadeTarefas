import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //lista para armazenar as tarefas - static a nível de classe
    private static ArrayList<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            // Exibir o menu para o usuário
            System.out.println("\n=== Tarefas ===");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Excluir Tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            scanner.nextLine(); // Limpa teclado

            switch (opcao) {
                case 1:
                    adicionarTarefa(scanner);
                    break;
                case 2:
                    listarTarefa();
                    break;
                case 3:
                    excluirTarefa(scanner);
                    break;
                case 4:
                    System.out.println("Saindo das Tarefas...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 4);
        scanner.close();

    }

    //  adicionar uma tarefa
    private static void adicionarTarefa(Scanner scanner) {
        System.out.print("Digite a tarefa: ");
        String tarefa = scanner.nextLine();
        tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    // listar todas as tarefas
    private static void listarTarefa() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("\n=== Lista de Tarefas ===");
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }

        }
    }

    //  excluir uma tarefa
    private static void excluirTarefa(Scanner scanner) {
        listarTarefa();
        if (!tarefas.isEmpty()) {
            System.out.println("Digite o número da tarefa que deseja excluir: ");
            int indice = scanner.nextInt() - 1;
            scanner.nextLine(); // limpa  teclado

            if (indice >= 0 && indice < tarefas.size()) {
                tarefas.remove(indice);
                System.out.println("Tarefa excluída com sucesso!");
            } else {
                System.out.println("Número inválido. Tente novamente");
            }
        }
    }

}

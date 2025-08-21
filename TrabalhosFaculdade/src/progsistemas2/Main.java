package progsistemas2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        Funcoes cliente = new Funcoes();
        int op;

        do{
        	System.out.println("\n===== BEM VINDO =====");
        	System.out.println("1) Adicionar novo cliente");
			System.out.println("2) Listar todos os clientes cadastrados");
			System.out.println("3) Atualizar informação de algum cliente");
			System.out.println("4) Remover cliente");
			System.out.println("5) Buscar cliente");
			System.out.println("0) Fechar programa");
            System.out.print("Escolha uma opção: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                	System.out.print("\nInsira o ID do cliente: ");
					int id = sc.nextInt();
					System.out.print("Digite o nome do cliente: ");
					String nome = sc.next();
					System.out.print("Digite o e-mail do cliente: ");
					String email = sc.next();
					System.out.print("Digite o telefone do cliente: ");
					String telefone = sc.next();
                    cliente.cadastroDeClientes(id, nome, email, telefone);
                    break;
                case 2:
                    cliente.listagemDeClientes();
                    break;
                case 3:
                	System.out.print("Digite o ID do cliente que deseja alterar os dados: ");
					int idAtt = sc.nextInt();
					System.out.print("Digite o nome atualizado do cliente: ");
					String nomeAtt = sc.next();
					System.out.print("Digite o email atualizado do cliente: ");
					String emailAtt = sc.next();
					System.out.println("Digite o telefone atualizado do cliente: ");
					String telefoneAtt = sc.next();
                    cliente.atualizacaoDeDadosDeClientes(idAtt, nomeAtt, emailAtt, telefoneAtt);
                    break;
                case 4:
                	System.out.print("Digite o ID do cliente que deverá ser removido: ");
					int idRemocao = sc.nextInt();
                    cliente.remocaoDeClientes(idRemocao);
                    break;
                case 5:
                	System.out.print("Digite o ID do cliente que deseja buscar: ");
					int idBusca = sc.nextInt();
                    cliente.buscaDeClientes(idBusca);
                    break;
                case 0:
                    System.out.println("ENCERRANDO O PROGRAMA......");
                    break;
                default:
                    System.out.println("OPÇÃO INVÁLIDA!!!");
                    break;
            }
        } while (op != 0);

        sc.close();
    }
}

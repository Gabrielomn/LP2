package lab03;

import java.util.Scanner;

public class Menu {
	
	Agenda agenda;
	
	public Menu() {
		this.agenda = new Agenda();
	}
	
	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print(this.exibirMenu());
			String entrada = sc.nextLine();
			if (entrada.equals("S")) {
				break;
			}
			this.validaComando(entrada);
			
		}
	}
	
	private void validaComando(String comando) {
		Scanner sc = new Scanner(System.in);

		if (comando.equals("C")) {
			System.out.print("Posicao: ");
			int posicao =  Integer.parseInt(sc.nextLine());
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Sobrenome: ");
			String sobrenome = sc.nextLine();
			System.out.print("Nivel: ");
			int nivel = sc.nextInt();
			System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, nivel));
			
		}
		
		else if (comando.equals("U")) {
			System.out.println("Como deseja fazer a consulta?");
			System.out.println("Por (N)ome, por n(I)vel de amizade, por nome (E) sobrenome");
			System.out.println("Ou deseja a (M)edia ou o n(U)mero com certa amizade ");
			String opcao = sc.nextLine();
			if (opcao.equals("N")) {
				System.out.print("Nome a ser pesquisado:");
				String nome = sc.nextLine();
				System.out.println(agenda.consultaPorNome(nome));
			}
			else if(opcao.equals("I")) {
				System.out.print("Nivel:");
				int nivel = sc.nextInt();
				System.out.println(agenda.consultaPorAmizade(nivel));
			}
			else if(opcao.equals("E")) {
				System.out.print("Nome:");
				String nome = sc.nextLine();
				System.out.print("Sobrenome:");
				String sobrenome = sc.nextLine();
				System.out.println(agenda.consultaPorContato(nome, sobrenome));
			}
			else if (opcao.equals("M")) {
				System.out.println(agenda.mediaAmizade());
			}
			
			else if (opcao.equals("U")) {
				System.out.print("Nivel Desejado:");
				int nivel = sc.nextInt();
				System.out.println(agenda.numeroDeContatosAmizade(nivel));
			}
			else {
				System.out.println("OPCAO INVALIDA!");
			}

		}
		
		else if (comando.equals("L")){
			System.out.println(this.agenda.listarContatos());
		}
		
		else if (comando.equals("E")) {
			System.out.print("Contato: ");
			int posicao =  Integer.parseInt(sc.nextLine());
			System.out.println(this.agenda.exibirContato(posicao));
		}
		else if(comando.equals("N")) {
			System.out.print("Nome do contato: ");
			String nome = sc.nextLine();
			System.out.print("Sobrenome do contato: ");
			String sobrenome = sc.nextLine();
			System.out.print("Tipo de telefone: ");
			String tipo = sc.nextLine();
			System.out.print("Codigo de pais: ");
			int ddi = sc.nextInt();
			System.out.print("DDD: ");
			int ddd = sc.nextInt();
			System.out.println("Numero: ");
			int numero = sc.nextInt();
			System.out.println(this.agenda.cadastraTel(nome, sobrenome, tipo, ddi, ddd, numero));
		}
	
		else {
			System.out.println("OPÇÃO INVÁLIDA");
		}
	}
	
	public String exibirMenu() {
		return "(C)adastrar Contato\n(L)istar Contatos\n(E)xibir Contato\n(N)ovo Telefone\nCons(U)lta\n(S)air\nOpção>";
	}
	
}

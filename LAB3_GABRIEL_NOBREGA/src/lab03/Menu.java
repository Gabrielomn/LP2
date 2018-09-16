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
			System.out.println(agenda.exibirMenu());
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
			System.out.println("Posicao:");
			int posicao =  Integer.parseInt(sc.nextLine());
			System.out.println("Nome");
			String nome = sc.nextLine();
			System.out.println("Sobrenome");
			String sobrenome = sc.nextLine();
			System.out.println("Número");
			String numero = sc.nextLine();
			System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, numero));
			
		}
		
		else if (comando.equals("L")){
			System.out.println(this.agenda.listarContatos());
		}
		
		else if (comando.equals("E")) {
			System.out.println("Contato:");
			int posicao =  Integer.parseInt(sc.nextLine());
			System.out.println(this.agenda.exibirContato(posicao));
		}
	
		else {
			System.out.println("OPÇÃO INVÁLIDA");
		}
	}
	
	
}

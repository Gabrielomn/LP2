package main;

import java.util.Scanner;

import exceptions.AlunoNaoExistenteException;
import exceptions.GrupoNaoExistenteException;

public class Menu {

	private Sistema sistema;

	public Menu() {
		this.sistema = new Sistema();
	}

	public String imprimeOpcoesPrincipais() {
		String msg = "(C)adastrar Aluno\n" + "(E)xibir Aluno\n" + "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Imprimir Grupos\n" + "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n" + "(O)ra, vamos fechar o programa!";
		return msg;
	}

	public void rodarMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println(this.imprimeOpcoesPrincipais());
			String opcao = sc.nextLine();
			if (opcao.equals("C")) {
				System.out.print("Matricula: ");
				String matricula = sc.nextLine();
				System.out.print("Nome: ");
				String nome = sc.nextLine();
				System.out.print("Curso: ");
				String curso = sc.nextLine();
				try {

					if (this.sistema.cadastraAluno(nome, matricula, curso)) {
						System.out.println("Aluno cadastrado com sucesso");
					} else {
						System.out.println("Matricula ja cadastrada");
					}
				} catch (IllegalArgumentException iae) {
					System.out.println(iae.getMessage());
				}
			}

			else if (opcao.equals("E")) {
				System.out.print("Matricula: ");
				String matricula = sc.nextLine();
				try {
					System.out.println(this.sistema.consultaAluno(matricula));

				} catch (AlunoNaoExistenteException anee) {
					System.out.println(anee.getMessage());
				}
			}

			else if (opcao.equals("N")) {
				System.out.print("Tema: ");
				String Tema = sc.nextLine();
				try {
					System.out.println(this.sistema.cadastraGrupo(Tema));
				} catch (IllegalArgumentException iae) {
					System.out.println(iae.getMessage());
				}

			}

			else if (opcao.equals("A")) {
				System.out.println("(A)locar Aluno ou (I)mprimir Grupo?");
				opcao = sc.nextLine();
				if (opcao.equals("A")) {
					System.out.print("Matricula: ");
					String matricula = sc.nextLine();
					System.out.print("Grupo: ");
					String tema = sc.nextLine();
					try {
						this.sistema.cadastraNoGrupo(tema, matricula);
						System.out.println("Aluno cadastrado no grupo com sucesso");
					} catch (AlunoNaoExistenteException anee) {
						System.out.println(anee.getMessage());
					} catch (GrupoNaoExistenteException gnee) {
						System.out.println(gnee.getMessage());
					}

				}

				else if (opcao.equals("I")) {
					System.out.print("Tema do Grupo:");
					String tema = sc.nextLine();
					System.out.println(this.sistema.imprimeGrupo(tema));
				}
			}

			else if (opcao.equals("R")) {
				System.out.print("Matricula: ");
				String matricula = sc.nextLine();
				System.out.println(this.sistema.cadastraResposta(matricula));
			}

			else if (opcao.equals("I")) {
				System.out.print(this.sistema.imprimirAlunosQuestoes());

			} else if (opcao.equals("O")) {
				break;
			}
		}

	}

}

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
				this.cadastraAluno();
			}

			else if (opcao.equals("E")) {
				this.consultaAluno();
			}

			else if (opcao.equals("N")) {
				this.cadastraGrupo();
			}

			else if (opcao.equals("A")) {
				System.out.println("(A)locar Aluno ou (I)mprimir Grupo?");
				opcao = sc.nextLine();
				if (opcao.equals("A")) {
					this.alocaAluno();
				}

				else if (opcao.equals("I")) {
					this.imprimeGrupo();
				}
			}

			else if (opcao.equals("R")) {
				this.registraResposta();
			}

			else if (opcao.equals("I")) {
				System.out.print(this.sistema.imprimirAlunosQuestoes());

			} else if (opcao.equals("O")) {
				break;
			}
		}

	}

	private void cadastraAluno() {
		Scanner sc = new Scanner(System.in);
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

	private void consultaAluno() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		try {
			System.out.println(this.sistema.consultaAluno(matricula));

		} catch (AlunoNaoExistenteException anee) {
			System.out.println(anee.getMessage());
		}
	}

	private void cadastraGrupo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Tema: ");
		String Tema = sc.nextLine();
		try {
			if (this.sistema.cadastraGrupo(Tema)) {
				System.out.println("Grupo cadastrado com sucesso");
			} else {
				System.out.println("Grupo ja existente");
			}
		} catch (IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}

	}

	private void imprimeGrupo() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Tema do Grupo:");
		String tema = sc.nextLine();
		try {
			System.out.println(this.sistema.imprimeGrupo(tema));
		} catch (GrupoNaoExistenteException gnee) {
			System.out.println(gnee.getMessage());
		}
	}

	private void registraResposta() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Matricula: ");
		String matricula = sc.nextLine();
		try {
			this.sistema.cadastraResposta(matricula);
			System.out.println("Resposta cadastrada com sucesso");
		} catch (AlunoNaoExistenteException anee) {
			System.out.println(anee.getMessage());
		}
	}

	private void alocaAluno() {
		Scanner sc = new Scanner(System.in);
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

}

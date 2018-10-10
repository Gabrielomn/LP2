package main;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {

	private HashMap<String, Aluno> alunos;
	private HashMap<String, GrupoDeEstudo> grupos;
	private ArrayList<Aluno> quadroDeRespostas;

	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.quadroDeRespostas = new ArrayList<>();
	}

	public String cadastraAluno(String nome, String matricula, String curso) {
		if (this.alunos.containsKey(matricula)) {

			return "CADASTRO REALIZADO!";
		} else {
			this.alunos.put(matricula, new Aluno(nome, matricula, curso));
			return "CADASTRO REALIZADO!";
		}
	}

	public String cadastraGrupo(String nome) {
		if (this.grupos.containsKey(nome)) {
			return "GRUPO JA CADASTRADO";
		} else {
			this.grupos.put(nome, new GrupoDeEstudo(nome));
			return "CADASTRO REALIZADO!";
		}
	}

	public String cadastraNoGrupo(String nomeDoGrupo, String matricula) {
		if (this.grupos.containsKey(nomeDoGrupo)) {
			if (this.alunos.containsKey(matricula))

			{
				this.grupos.get(nomeDoGrupo).cadastraAluno(this.alunos.get(matricula));
				return "ALUNO ALOCADO!";
			} else {
				return "ALUNO NAO CADASTRADO.";
			}

		}

		else {

			return "GRUPO NAO CADASTRADO.";
			// Precisa retornar algo, necessária confirmação se foi cadastrado o aluno ou
			// não.
		}
	}

	public String consultaAluno(String matricula) {

		if (this.alunos.containsKey(matricula)) {

			return this.alunos.get(matricula).toString();
		}

		else {
			return "Aluno não cadastrado.";
		}
	}

	public String imprimeGrupo(String nomeDoGrupo) {
		if (this.grupos.containsKey(nomeDoGrupo)) {
		return this.grupos.get(nomeDoGrupo).imprimeGrupo();}
		else {
			return "Grupo nao cadastrado";
		}
	}

	public String cadastraResposta(String matricula) {

		if (this.alunos.containsKey(matricula)) {
			this.quadroDeRespostas.add(this.alunos.get(matricula));
			return "ALUNO REGISTRADO!";
		} else {
			return "ALUNO NAO CADASTRADO";
		}
	}

	public String imprimirAlunosQuestoes() {
		String saida = "Alunos:" + System.lineSeparator();
		int cont = 1;

		for (Aluno aluno : this.quadroDeRespostas) {
			saida += cont + ". " + aluno.toString() + System.lineSeparator();
		}

		return saida;
	}
}

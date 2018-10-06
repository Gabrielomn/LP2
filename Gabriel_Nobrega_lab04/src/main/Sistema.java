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

	public void cadastraAluno(String nome, String matricula, String curso) {
		this.alunos.put(matricula, new Aluno(nome, matricula, curso));
	}

	public void cadastraGrupo(String nome) {
		this.grupos.put(nome, new GrupoDeEstudo(nome));
	}

	public void cadastraNoGrupo(String nomeDoGrupo, String matricula) {
		this.grupos.get(nomeDoGrupo).cadastraAluno(this.alunos.get(matricula));
	}

	public String consultaAluno(String matricula) {
		return this.alunos.get(matricula).toString();
	}

	public String imprimeGrupo(String nomeDoGrupo) {
		return this.grupos.get(nomeDoGrupo).imprimeGrupo();
	}

	public void cadastraResposta(String matricula) {
		this.quadroDeRespostas.add(this.alunos.get(matricula));
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

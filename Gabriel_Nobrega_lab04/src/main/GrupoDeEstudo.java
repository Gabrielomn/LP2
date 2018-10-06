package main;

import java.util.HashSet;

public class GrupoDeEstudo {
	
	private String tema;
	private HashSet <Aluno> alunosNoGrupo;
	
	public GrupoDeEstudo(String tema) {
		this.tema = tema;
	}
	
	public void cadastraAluno(Aluno aluno) {
		this.alunosNoGrupo.add(aluno);
	}
	
	public String imprimeGrupo() {
		
		String saida = "";
		int cont = 1;
		for (Aluno a: this.alunosNoGrupo) {
			saida += cont + ". " + a + System.lineSeparator();
		}
		
		return saida;
	}

}

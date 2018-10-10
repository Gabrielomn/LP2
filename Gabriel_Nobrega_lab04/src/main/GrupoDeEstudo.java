package main;

import java.util.HashSet;

public class GrupoDeEstudo {
	
	private String tema;
	private HashSet <Aluno> alunosNoGrupo;
	
	public GrupoDeEstudo(String tema) {
		this.alunosNoGrupo = new HashSet<>();
		this.tema = tema;
	}
	
	public void cadastraAluno(Aluno aluno) {
		this.alunosNoGrupo.add(aluno);
	}
	
	public String imprimeGrupo() {
		
		String saida = "";
		for (Aluno a: this.alunosNoGrupo) {
			saida += "* "+ a + System.lineSeparator();
		}
		String ninguemCadastrado = "Nenhum aluno cadastrado em " + this.tema;
		return (saida.length() != 0) ? saida : ninguemCadastrado;
	}

}

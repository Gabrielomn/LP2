package main;

import java.util.HashSet;
/**
 * Classe que representa a entidade Grupo de estudo
 * @author gabriel
 *
 */
public class GrupoDeEstudo {
	/**
	 * tema do grupo
	 */
	private String tema;
	/**
	 * HashSet que é usado para armazenar os alunos que estão cadastrados nesse grupo
	 */
	private HashSet <Aluno> alunosNoGrupo;
	
	/**
	 * Construtor de Grupo
	 * @param tema usado para setar o tema desse grupo
	 */
	public GrupoDeEstudo(String tema) {
		this.alunosNoGrupo = new HashSet<>();
		this.tema = tema;
	}
	
	/**
	 * cadastra esse aluno no grupo
	 * @param aluno objeto do tipo Aluno a ser cadastrado no grupo
	 */
	public void cadastraAluno(Aluno aluno) {
		this.alunosNoGrupo.add(aluno);
	}
	
	/**
	 * metodo que imprime os toString de alunos que estão cadastrados no grupo
	 * @return string com as descrições de todos os alunos
	 */
	public String imprimeGrupo() {
		
		String saida = "";
		for (Aluno a: this.alunosNoGrupo) {
			saida += "* "+ a + System.lineSeparator();
		}
		String ninguemCadastrado = "Nenhum aluno cadastrado em " + this.tema;
		return (saida.length() != 0) ? saida : ninguemCadastrado;
	}

}
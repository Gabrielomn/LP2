package main;

/**
 * classe que representa a entidade Aluno
 * @author gabriel
 *
 */
public class Aluno {
	
	/**
	 * representa o nome do aluno
	 */
	private String nome;
	/**
	 * representa a matricula do aluno
	 */
	private String matricula;
	/**
	 * representa o curso do aluno
	 */
	private String curso;
	
	/**
	 * construtor de aluno, instancia com os metodos que recebe como parametro
	 * @param nome
	 * @param matricula
	 * @param curso
	 */
	public Aluno(String nome, String matricula, String curso) {
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}
	
	/**
	 * representação em String de aluno.
	 */
	@Override
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso ;
	}
	
	

}

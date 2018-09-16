package lab03;

/**
 * Classe que representa a entidade contato, contendo nome, sobrenome e telefone
 * @author gabriel
 *
 */
public class Contato {

	/**
	 * String que contém o nome do Contato.
	 */
	private String nome;
	
	/**
	 * String que contém o sobrenome do Contato.
	 */
	private String sobrenome;
	/**
	 * String que contém o telefone do contato.
	 */
	private String telefone;
	
	/**
	 * Construtor de Contato, apenas inicia os atributos do objeto de acordo
	 * com os parametros passados.
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome,String sobrenome,String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}
	
	/**
	 * get nome, apenas retorna a string nome do contato.
	 * @return
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * metodo to string, retorna nome sobrenome
	 */
	@Override
	public String toString() {
		
		return this.nome + " " + this.sobrenome;
		
	}

	/**
	 * Metodo que retorna uma String contendo todos os dados do usuario dada
	 * uma determinada formatação.
	 * @return dados do contato.
	 */
	public String exibir() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone; 
	}
	
	public boolean equals(Contato outro) {
		if(this.nome.equals(outro.getNome())) {
			return true;
		}
		else {
			return false;
		}
	}
}

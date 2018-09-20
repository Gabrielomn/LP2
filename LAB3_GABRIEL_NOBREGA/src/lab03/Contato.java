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
	 * Array de telefones que contém os telefones do contato.
	 */
	private Telefone[] telefones;
	/**
	 * num de telefones cadastrados.
	 */
	private int numTel;
	/**
	 * nivel da amizade
	 */
	private int nivel;
	/**
	 * Construtor de Contato, apenas inicia os atributos do objeto de acordo
	 * com os parametros passados.
	 * @param nome
	 * @param sobrenome
	 * @param nivel
	 */
	public Contato(String nome,String sobrenome, int nivel) {
		
		if (nome.equals("") || sobrenome.equals("")) {
			throw new IllegalArgumentException("String vazia passada como paraametro");
		}
		
		if (nivel < 0 || nivel > 5) {
			throw new IllegalArgumentException("Numero pra nivel deve ser entre 1 e 5");
		}
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefones = new Telefone[3];
		this.numTel = 0;
		this.nivel = nivel;
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
		
		return this.nome + " " + this.sobrenome + " - " + this.conceito();
		
	}
	
	/**
	 * metodo que retorna a String que representa o conceito do amigo
	 * @return String do conceito
	 */
	private String conceito() {
		String[] conceitos = {"distante", "colega", "amigo", "amigão", "irmão"};
		return conceitos[this.nivel-1];
	}
	
	/**
	 * Cadastra um telefone
	 * @param tipo
	 * @param dd
	 * @param ddi
	 * @param numero
	 */
	public void cadastraTelefone(String tipo, int dd, int ddi, int numero) {
		if (this.numTel < 3) {
			telefones[this.numTel] = new Telefone(tipo, dd, ddi, numero);
			this.numTel += 1;
		}
	}
	

	/**
	 * Metodo que retorna uma String contendo todos os dados do usuario dada
	 * uma determinada formatação.
	 * @return dados do contato.
	 */
	public String exibir() {
		return this.nome + " " + this.sobrenome + " - " + this.telefones[0]; 
	}
	
	/**
	 * retorna o nivel do contato
	 * @return nivel do contato
	 */
	public int getNivel() {
		return this.nivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	
	/**
	 * metodo que verifica se dois contatos são iguais
	 * @param objeto a ser comparado
	 * @return boolean que representa se são ou não iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
	

}

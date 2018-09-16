package lab2;

/**
 * Classe que representa a saúde de um aluno.
 * @author gabriel
 *
 */
public class Saude {
	
	/**
	 * string que representa a saude fisica.
	 */
	private String fisica;
	/**
	 * string que representa a saude mental.
	 */
	private String mental;
	/**
	 * string que contem um emoji que representa o humor.
	 */
	private String emoji;
	
	/**
	 * Construtor default de saude.
	 */
	public Saude() {
		this.fisica = "boa";
		this.mental = "boa";
		this.emoji = "";
	}
	
	/**
	 * metodo que altera a saude mental.
	 * @param valor
	 */
	public void defineSaudeMental(String valor) {
		this.mental = valor;
		this.emoji = "";
	}
	/**
	 * metodo que altera a saude fisica.
	 * @param valor
	 */
	public void defineSaudeFisica(String valor) {
		this.fisica = valor;
		this.emoji = "";
	}
	/**
	 * metodo que retorna o status do objeto
	 * @return o estado do aluno e um emoji caso cadastrado.
	 */
	public String getStatusGeral() {
		String valor;
		if (this.fisica.equals("boa") && this.mental.equals("boa")){
			valor = "boa";
			return valor + " " + this.emoji;
		}
		else if (this.fisica.equals("boa") || this.mental.equals("boa")){
			valor = "ok";
			return valor + " " + this.emoji;
		}
		
		else {
			valor = "fraca";
			return valor + " " + this.emoji;
		}
	}
	/**
	 * metodo que define o emoji que representa o humor.
	 * @param valor
	 */
	void definirEmoji(String valor) {
		this.emoji = valor;
	}
}


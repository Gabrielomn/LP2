package lab03;

/**
 * Classe que representa a entidade Telefone
 * @author gabriel
 *
 */
public class Telefone {
	
	/**
	 * tipo de telefone, podendo ser celular, casa ou trabalho
	 */
	private String tipo;
	/**
	 * codigo de estado do telefone
	 */
	private int ddd;
	/**
	 * codigo de pais de telefone
	 */
	private int ddi;
	/**
	 * numero de telefone
	 */
	private int numero;
	
	/**
	 * construtor de telefone, instancia o objeto com os parametros
	 * passados.
	 * @param tipo
	 * @param ddi
	 * @param ddd
	 * @param numero
	 */
	public Telefone(String tipo, int ddi, int ddd, int numero) {
		this.tipo = tipo;
		this.ddd = ddd;
		this.ddi = ddi;
		this.numero = numero;
	}
	
	/**
	 * toString, retorna o telefone no formato normalizado.
	 */
	public String toString() {
		return this.tipo + ": +" + Integer.toString(this.ddi) + "(" + Integer.toString(this.ddd) + ")" + Integer.toString(this.numero);
	}
}

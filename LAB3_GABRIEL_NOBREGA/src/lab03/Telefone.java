package lab03;

public class Telefone {

	private String tipo;
	private int ddd;
	private int ddi;
	private int numero;
	
	public Telefone(String tipo, int ddd, int ddi, int numero) {
		this.tipo = tipo;
		this.ddd = ddd;
		this.ddi = ddi;
		this.numero = numero;
	}
	
	public String toString() {
		return this.tipo + ": +" + Integer.toString(this.ddi) + "(" + Integer.toString(this.ddd) + ")" + Integer.toString(this.numero);
	}
}

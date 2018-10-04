package slaque;

public class Mensagem {
	
	private String mensagem;
	private String autor;
	
	public Mensagem(String mensagem, String autor) {
		this.mensagem = mensagem;
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Mensagem [mensagem=" + mensagem + ", autor=" + autor + "]";
	}


}

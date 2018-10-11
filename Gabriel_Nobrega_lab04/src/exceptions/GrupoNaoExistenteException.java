package exceptions;

public class GrupoNaoExistenteException extends Exception{
	public GrupoNaoExistenteException(String msg) {
		super(msg);
	}
	
	public GrupoNaoExistenteException() {
		super("Grupo nao existente");
	}
}

package exceptions;

public class AlunoNaoExistenteException extends Exception{
	public AlunoNaoExistenteException(String msg) {
		super(msg);
	}
	public AlunoNaoExistenteException() {
		super("Aluno nao cadastrado");
	}

}

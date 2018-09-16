package lab03;

public class Agenda {

	Contato[] contatos;
	
	public Agenda() {
		this.contatos = new Contato[101];
	}
	
	public String exibirMenu() {		
		return "(C)adastrar Contato\n(L)istar Contatos\n(E)xibir Contato\n(S)air\nOpção>";
	}
	
	public String cadastraContato(int posicao, String nome, String sobrenome, String numero){
		if (this.posicaoValida(posicao)) {
			
			contatos[posicao] = new Contato(nome, sobrenome, numero);
			return "CADASTRO REALIZADO!";
		}
		else {
			return "POSIÇÃO INVÁLIDA!";
		}
		
	}
	
	private boolean posicaoValida(int posicao) {
		if ((posicao > 0) && (posicao <= 100)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String exibirContato(int posicao) {
		
		if(contatoExiste(posicao)) {
			return contatos[posicao].exibir();
		}
		else {
			return "POSIÇÃO INVÁLIDA!";
		}
	}
	
	private boolean contatoExiste(int posicao) {
		if (this.contatos[posicao]  != null) {
			return true;
		}
		
		else {
			return false;
		}
	}
	
	public String listarContatos() {
		
		String saida = "";
		
		for (int i = 1; i <= 100; i++) {
			if (contatoExiste(i)) {
				saida += Integer.toString(i) + " - " + contatos[i] + "\n";
			}
		}
		
		return saida;
		
	}

	public boolean equals(Agenda outra) {
		
		for (int i = 1; i <= 100; i++) {
			if ((outra.contatoExiste(i)) && this.contatoExiste(i)) {
				
				if (!(this.contatos[i].equals(outra.contatos[i]))) {
					return false;
				}
				
			}
			
			else if ((outra.contatoExiste(i) || this.contatoExiste(i))) {
				return false;
			}
		}
		
		return true;
	}
}

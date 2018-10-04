package slaque;

import java.util.ArrayList;
import java.util.HashMap;

public class Canal {
	
	private ArrayList<Mensagem> mensagens;
	private HashMap<String, Usuario> noCanal;
	private String nome;
	
	public Canal(String nome) {
		this.nome = nome;
		this.noCanal = new HashMap<>();
		this.mensagens = new ArrayList<>();
	}
	
	public void entraCanal(String nomeUsuario, Usuario usuario) {
		this.noCanal.put(nomeUsuario, usuario);
	}
	
	public void saiCanal(String nomeUsuario) {
		this.noCanal.remove(nomeUsuario);
	}
	
	public String listaUsuarios() {
		String saida = "";

		for (String key: this.noCanal.keySet()) {
			saida += this.noCanal.get(key).toString() + System.lineSeparator();
		}
		return saida;
	}
	
	public void mandaMsg(String nomeUsuario, String mensagem) {
		if(this.noCanal.containsKey(nomeUsuario)) {
			this.mensagens.add(new Mensagem(mensagem, nomeUsuario));		
		}
	}
	
	public String listaHistoricoMensagens() {
		
		String saida = "";
		boolean temMensagens = false;
		for(Mensagem m: this.mensagens) {
			temMensagens = true;
			saida += m.toString() + System.lineSeparator();
		}
		
		return temMensagens ? saida : "Nao houve mensagens cadastradas";
	}
}

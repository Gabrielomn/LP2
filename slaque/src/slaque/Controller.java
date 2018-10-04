package slaque;

import java.util.HashMap;
import java.util.HashSet;

public class Controller {

	private HashSet<Usuario> usuarios;
	private HashMap<String, Canal> canais;

	public Controller() {
		this.usuarios = new HashSet<>();
		this.canais = new HashMap<>();

	}

	public void cadastraUsuario(String nome, String email) {
		Usuario novoUsuario = new Usuario(nome, email);
		this.usuarios.add(novoUsuario);
	}

	private boolean existeUsuario(String nomeUsuario) {

		for (Usuario u : this.usuarios) {
			if (u.getNome().equals(nomeUsuario)) {
				return true;

			}
		}
		return false;
	}

	public void entrarCanal(String nomeCanal, String nomeUsuario) {

		Usuario usuarioProcurado = procuraUsuario(nomeUsuario);

		if (this.existeCanal(nomeCanal) && usuarioProcurado != null) {

			this.canais.get(nomeCanal).entraCanal(nomeUsuario, usuarioProcurado);
		}

	}

	public void saiCanal(String nomeCanal, String nomeUsuario) {
		if (this.existeCanal(nomeCanal) && this.existeUsuario(nomeUsuario)) {
			this.canais.get(nomeCanal).saiCanal(nomeUsuario);
		}
	}

	private Usuario procuraUsuario(String nome) {

		for (Usuario u : this.usuarios) {
			if (u.getNome().equals(nome)) {
				return u;
			}
		}
		return null;
	}
	/*
	 * public boolean pertinenciaCanal(String nome) {
	 * 
	 * for (String n: this.canais.keySet()) { if (n.equals(nome)) { return true; } }
	 * return false; }
	 */

	private boolean existeCanal(String nomeCanal) {

		return this.canais.containsKey(nomeCanal);
	}

	public void cadastraCanal(String nome) {
		Canal novoCanal = new Canal(nome);
		this.canais.put(nome, novoCanal);

	}

	public String listaUsuariosEmCanal(String nomeDoCanal) {
		if (this.canais.containsKey(nomeDoCanal)) {

			return this.canais.get(nomeDoCanal).listaUsuarios();
		} else {
			return "CANAL NAO EXISTENTE";
		}
	}

	public void mandaMensagem(String canal, String nomeUsuario, String mensagem) {
		if (canais.containsKey(canal)) {
			this.canais.get(canal).mandaMsg(nomeUsuario, mensagem);
		}
	}


	public String listaMensagens(String canal) {
		String saida = "";
		if (canais.containsKey(canal)) {
			return this.canais.get(canal).listaHistoricoMensagens();
		}
		
		return saida;
	}
}

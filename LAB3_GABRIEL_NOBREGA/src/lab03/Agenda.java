package lab03;

import java.util.Arrays;

/**
 * Classe que representa a entidade Agenda
 * 
 * @author gabriel
 *
 */
public class Agenda {

	/**
	 * Array que contem os contatos armazenados nessa agenda.
	 */
	Contato[] contatos;

	/**
	 * Construtor de agenda, apenas instancia o array de contatos com 101 espaços
	 * note que o espaço 0 nunca é usado.
	 */
	public Agenda() {
		this.contatos = new Contato[101];
	}

	/**
	 * Cadastra contato, apenas cadastra um contato no array e retorna se teve
	 * sucesso ou nao.
	 * 
	 * @param posicao
	 * @param nome
	 * @param sobrenome
	 * @param numero
	 * @return String que diz se teve ou nao exito ao fazer o cadastro.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, int nivel) {
		if (nome == null || sobrenome == null) {
			throw new NullPointerException();
		}

		if (this.posicaoValida(posicao)) {
			contatos[posicao] = new Contato(nome, sobrenome, nivel);
			return "CADASTRO REALIZADO!";
		} else {
			return "POSIÇÃO INVÁLIDA!";
		}

	}

	/**
	 * Metodo que cadastra telefone
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param tipo
	 * @param ddi
	 * @param ddd
	 * @param numero
	 * @return String dizendo se teve ou nao sucesso no cadastro.
	 */
	public String cadastraTel(String nome, String sobrenome, String tipo, int ddi, int ddd, int numero) {
		Contato procurado = procuraContato(nome, sobrenome);
		if (procurado != null) {
			procurado.cadastraTelefone(tipo, ddd, ddi, numero);
			return "TELEFONE CADASTRADO COM SUCESSO!";
		}
		return "CONTATO NAO EXISTENTE!";
	}

	private Contato procuraContato(String nome, String sobrenome) {
		Contato procurado = new Contato(nome, sobrenome, 0);
		for (Contato contato : contatos) {
			if (procurado.equals(contato)) {
				return contato;
			}
		}
		return null;
	}

	/**
	 * Metodo privado para verificar se a posição é valida
	 * 
	 * @param posicao
	 * @return
	 */
	private boolean posicaoValida(int posicao) {
		if ((posicao > 0) && (posicao <= 100)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo que retorna uma string que representa o contato.
	 * 
	 * @param posicao
	 * @return String que representa o contato na posicao designada.
	 */
	public String exibirContato(int posicao) {

		if (contatoExiste(posicao)) {
			return contatos[posicao].exibir();
		} else {
			return "POSIÇÃO INVÁLIDA!";
		}
	}

	/**
	 * metodo privado que verifica se o contato existe ou se está na posição
	 * adequada
	 * 
	 * @param posicao
	 * @return boolean pra caso exista um contato cadastrado na posicao.
	 */
	private boolean contatoExiste(int posicao) {
		if ((posicao <= 0) || (posicao > 100)) {
			throw (new ArrayIndexOutOfBoundsException("Posicao fora do escopo esperado"));
		}

		if (this.contatos[posicao] != null) {
			return true;
		}

		else {
			return false;
		}
	}

	/**
	 * metodo que retorna uma string contendo os dados de todos os contatos
	 * 
	 * @return
	 */
	public String listarContatos() {

		String saida = "";

		for (int i = 1; i <= 100; i++) {
			if (contatoExiste(i)) {
				saida += Integer.toString(i) + " - " + contatos[i] + "\n";
			}
		}

		return saida;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(contatos);
		return result;
	}

	/**
	 * metodo que verifica se duas agendas sao iguais
	 * 
	 * @param outra
	 * @return boolean que diz se as agendas sao ou nao iguais.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (!Arrays.equals(contatos, other.contatos))
			return false;
		return true;
	}

}

package main;

import java.util.ArrayList;
import java.util.HashMap;

import exceptions.AlunoNaoExistenteException;
import exceptions.GrupoNaoExistenteException;

/**
 * Classe que controla grupos, alunos e o quadroDeRespostas
 * @author gabriel
 *
 */
public class Sistema {
	
	/**
	 * HashMap que vai conter alunos
	 */
	private HashMap<String, Aluno> alunos;
	/**
	 * HashMap de grupos
	 */
	private HashMap<String, GrupoDeEstudo> grupos;
	/**
	 * ArrayList que guarda os alunos que responderam perguntas
	 */
	private ArrayList<Aluno> quadroDeRespostas;
	
	/**
	 * construtor de Sistema, instancia os atributos da classe
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.quadroDeRespostas = new ArrayList<>();
	}

	/**
	 * metodo que cadastra Aluno no sistema, lança exceção caso seja passado
	 * parametro vazio
	 * @param nome
	 * @param matricula
	 * @param curso
	 * @return boolean que confirma se aluno foi cadastrado ou não.
	 */
	public boolean cadastraAluno(String nome, String matricula, String curso) {
		if (nome.equals("") || matricula.equals("") || curso.equals("")) {
			throw new IllegalArgumentException("String vazia passada como parametro");
		}
		
		if (this.alunos.containsKey(matricula)) {

			return false;
		} else {
			this.alunos.put(matricula, new Aluno(nome, matricula, curso));
			return true;
		}
	}

	/**
	 * metodo que cadastra um grupo, lança exceção caso o tema passsado seja uma
	 * string vazia
	 * @param nome
	 * @return boolean que diz se o grupo foi ou não cadastrado
	 */
	public boolean cadastraGrupo(String nome) {
		if (nome.equals("")) {
			throw new IllegalArgumentException("Grupo nao pode ter string vazia como nome");
		}

		if (this.grupos.containsKey(nome)) {
			return false;
		} else {
			this.grupos.put(nome, new GrupoDeEstudo(nome));
			return true;
		}
	}

	/**
	 * metodo que cadastra um Aluno em um grupo.
	 * @param nomeDoGrupo
	 * @param matricula
	 * @throws AlunoNaoExistenteException caso o Aluno nao esteja cadastrado 
	 * @throws GrupoNaoExistenteException caso o grupo nao esteja cadastrado
	 */
	public void cadastraNoGrupo(String nomeDoGrupo, String matricula) throws AlunoNaoExistenteException, GrupoNaoExistenteException {
		if (this.grupos.containsKey(nomeDoGrupo)) {
			if (this.alunos.containsKey(matricula))

			{
				this.grupos.get(nomeDoGrupo).cadastraAluno(this.alunos.get(matricula));
			} else {
				throw new AlunoNaoExistenteException();
			}

		}

		else {

			throw new GrupoNaoExistenteException();

		}
	}
	
	/**
	 * metodo que retorna um toString do aluno com a matricula correspondente.
	 * @param matricula
	 * @return toString do aluno
	 * @throws AlunoNaoExistenteException caso não exista esse aluno
	 */
	public String consultaAluno(String matricula) throws AlunoNaoExistenteException {

		if (this.alunos.containsKey(matricula)) {

			return this.alunos.get(matricula).toString();
		}

		else {
			throw new AlunoNaoExistenteException();
		}
	}
	
	/**
	 * Imprime os membros do grupo de nome igual ao parametro
	 * @param nomeDoGrupo
	 * @return String que representa os membros desse grupo
	 * @throws GrupoNaoExistenteException caso não exista o grupo
	 */
	public String imprimeGrupo(String nomeDoGrupo) throws GrupoNaoExistenteException {
		if (this.grupos.containsKey(nomeDoGrupo)) {
			return this.grupos.get(nomeDoGrupo).imprimeGrupo();
		} else {
			throw new GrupoNaoExistenteException();
		}
	}
	
	/**
	 * metodo que cadastra a resposta do aluno.
	 * @param matricula
	 * @throws AlunoNaoExistenteException
	 */
	public void cadastraResposta(String matricula) throws AlunoNaoExistenteException {

		if (this.alunos.containsKey(matricula)) {
			this.quadroDeRespostas.add(this.alunos.get(matricula));
		} else {
			throw new AlunoNaoExistenteException();
		}
	}

	/**
	 * Imprime os alunos que responderam as questões
	 * @return
	 */
	public String imprimirAlunosQuestoes() {
		String saida = "Alunos:" + System.lineSeparator();
		int cont = 1;

		for (Aluno aluno : this.quadroDeRespostas) {
			saida += cont + ". " + aluno.toString() + System.lineSeparator();
			cont++;
		}

		return saida;
	}
}

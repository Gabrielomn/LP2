package lab2;

import java.util.Arrays;

/**
 * Classe que representa uma Disciplina da UFCG
 * @author gabriel
 *
 */
public class Disciplina {
	/**
	 * nome é o nome da disciplina
	 */
	private String nome;
	/**
	 * notas é um array que contem as notas
	 */
	private double[] notas;
	/**
	 * media é a media na disciplina
	 */
	private double media;
	/**
	 * horas são as horas cumpridas na disciplina, note que ela não é incrementada
	 * e sim apenas definida.
	 */
	private int horas;
	/**
	 * numNotas é um inteiro que representa o numero de notas que é necessaria
	 * naquela disciplina, por default ela é definida como 4.
	 */
	private int numNotas;
	/**
	 * Os pesos de cada uma das notas, caso não seja definida os pesos são 1.
	 */
	private int[] pesos;
	
	/**
	 * Construtor que apenas recebe o nome da disciplina, e define
	 * os outros como default de acordo com a especificação.
	 * @param nome
	 */
	public Disciplina(String nome) {
		this.nome = nome;
		this.numNotas = 4;
		this.pesos = new int[this.numNotas];
		this.notas = new double[this.numNotas];


		for (int i = 0; i < 4; i ++) {
			this.notas[i] = 0;
			this.pesos[i] = 1;
		}
		this.media = 0;
		this.horas = 0;
	}
	/**
	 * Construtor que recebe o nome e o numero de notas.
	 * @param nome
	 * @param numNotas
	 */
	public Disciplina(String nome, int numNotas) {
		this.nome = nome;
		this.pesos = new int[numNotas];
		this.notas = new double[this.numNotas];

		this.numNotas = numNotas;
		for (int i = 0; i < this.numNotas; i ++) {
			this.notas[i] = 0;
			this.pesos[i] = 1;
		}
		this.media = 0;
		this.horas = 0;
	}
	/**
	 * Construtor que define nome, num de notas e os pesos das notas.
	 * @param nome
	 * @param numNotas
	 * @param pesos
	 */
	public Disciplina(String nome, int numNotas, int[] pesos) {
		this.nome = nome;
		this.numNotas = numNotas;
		this.pesos = new int[numNotas];
		this.notas = new double[this.numNotas];

		for (int i = 0; i < this.numNotas; i ++) {
			this.notas[i] = 0;
			this.pesos[i] = pesos[i];
		}
		this.media = 0;
		this.horas = 0;
	}
	/**
	 * metodo que cadastra uma uma nota em determinado estágio.
	 * @param nota
	 * @param valorNota
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * metodo que cadastra horas na disciplina.
	 * @param horas
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}
	
	/**
	 *metodo que diz caso aluno tenha sido aprovado ou nao. 
	 * @return true para aprovado e false para reprovado.
	 */
	public boolean aprovado() {
		this.calculaMedia();

		if (this.media >= 7.0) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * metodo privado que calcula a media do aluno.
	 */
	private void calculaMedia() {
		double soma = 0;
		int somaPesos = 0;
		for (int i = 0; i < this.numNotas; i ++) {
			soma += notas[i] * this.pesos[i];
			somaPesos += this.pesos[i];
		}
		this.media = soma/somaPesos;
	}
	/**
	 * Metodo toString que retorna no formato correspondente, onde nota 
	 * eh um array contendo as notas na disciplina, nome horas media notas.
	 */
	public String toString() {
		this.calculaMedia();
		return this.nome + " " + this.horas + " " + this.media + " " + Arrays.toString(notas);
	}
	/**
	 * metodo para retornar o nome da disciplina.
	 * @return nome da disciplina
	 */
	public String getNome() {
		return this.nome;
	}
}

package lab2;

/**
 * Classe que representa a conta de laboratório de um aluno da UFCG.
 * @author gabriel
 *
 */
public class ContaLaboratorio {
	/**
	 * nome do objeto laboratorio.
	 */
	private String nome;
	/**
	 * cota limite para o laboratorio.
	 */
	private int cota;
	/**
	 * cota consumida atual.
	 */
	private int cotaAtual;
	/**
	 * Construtor de laboratorio, recebe apenas o nome e o resto fica como default.
	 * @param nome
	 */
	public ContaLaboratorio(String nome) {
		this.nome = nome;
		this.cota = 2000;
		this.cotaAtual = 0;

	}
	
	/**
	 * construtor de laboratorio que cria um laboratorio com cota específica
	 * @param nomeLaboratorio
	 * @param cota
	 */
	public ContaLaboratorio (String nomeLaboratorio, int cota) {
		this.nome = nomeLaboratorio;
		this.cota = cota;
		this.cotaAtual = 0;
	}
	
	/**
	 * metodo que consome mbytes de espaço.
	 * @param mbytes
	 */
	public void consomeEspaco(int mbytes) {
	
		this.cotaAtual += mbytes;		
	}
	
	/**
	 * metodo que libera mbytes de espaço na cota.
	 * @param mbytes
	 */
	public void liberaEspaco(int mbytes) {
		this.cotaAtual -= mbytes;
		if (this.cotaAtual < 0){
			this.cotaAtual = 0;
		}
	}
	
	/**
	 * metodo que retorna se o usuario atingiu ou nao a cota.
	 * @return booleano dizendo se a cota foi atingida ou nao
	 */
	public boolean atingiuCota() {
		if (this.cotaAtual >= this.cota) {
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * metodo que converte os atributos do objeto em string.
	 */
	public String toString() {
		return this.nome + " " + this.cotaAtual + "/" + this.cota;
	}
	
	/**
	 *	Metodo que retorna o nome do objeto. 
	 * @return nome do laboratorio
	 */
	public String getNome() {
		return this.nome;
	}
}

package lab2;
import java.util.ArrayList;

/**
 * Classe que represena uma conta em uma Cantina.
 * @author gabriel
 *
 */
public class ContaCantina {
	
	/**
	 * valor das compras na cantina.
	 */
	private int valor;
	/**
	 * quanto desse valor já foi pago.
	 */
	private int pago;
	/**
	 * o número de itens comprados nessa cantina.
	 */
	private int itens;
	/**
	 * nome da cantina
	 */
	private String nome;
	/**
	 * ArrayList que guarda os detalhes das comprar nessa cantina.
	 */
	private ArrayList <String> detalhes;
	/**
	 * Número de detalhes já cadastrados.
	 */
	private int numDetalhes;
	
	/**
	 * Construtor de ContaCantina, cadastra o objeto com o nome que recebe de
	 * parametro e inicializa seus atributos com valores nulos.
	 * @param nomeDaCantina
	 */
	public ContaCantina(String nomeDaCantina) {
		this.detalhes = new ArrayList<>();
		this.nome = nomeDaCantina;
		this.valor = 0;
		this.itens = 0;
		this.pago = 0;
	}
	
	/**
	 * Cadastra um lanche, incrementando o numero de itens e o valor 
	 * de coisas compradas na cantina.
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.itens += qtdItens;
		this.valor += valorCentavos;
	}
	
	/**
	 * Cadastra um lanche, incrementando o numero de itens e o valor 
	 * de coisas compradas na cantina e adciona ao ArrayList
	 * uma string detalhando a compra.
	 * @param qtdItens
	 * @param valorCentavos
	 * @param detalhes
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos, String detalhes) {
		this.itens += qtdItens;
		this.valor += valorCentavos;
		this.detalhes.add(detalhes);
		this.numDetalhes++;
	}
	
	/**
	 * metodo que retorna os ultimos 5 detalhes cadastrados.
	 * @return
	 */
	private String getLastFive(){
		String saida = "";
		for (int i = this.numDetalhes-1; i > this.numDetalhes - 6; i--) {
			saida += detalhes.get(i);
			if (i != this.numDetalhes -5) {
				saida += System.lineSeparator();
			}
		}
		return saida;
	}
	
	/**
	 * metodo que retorna os ultimos detalhes caso não enha tido 5 cadastros.
	 * @return
	 */
	private String getLastDetalhes(){
		String saida = "";
		for (int i = 0; i < this.numDetalhes; i++) {
			saida += detalhes.get(i);
			if (i != this.numDetalhes-1) {
				saida += System.lineSeparator();
			}
	}
		return saida;
	}
	
	/**
	 * metodo que decide quais dos dois anteriores deve ser chamado e retorna
	 * a adequada.
	 * @return retorna os detalhes das ultimas compras.
	 */
	public String listarDetalhes() {
		String saida = "";
		if (this.numDetalhes > 5) {
				saida = getLastFive();
			}	
		
		else {
			saida = getLastDetalhes();
				}
	
		return saida;
	}
	
	/**
	 * metodo que paga um valor da conta. 
	 * @param valorCentavos
	 */
	public void pagaConta(int valorCentavos) {
		
		if (this.valor < valorCentavos) {
			this.pago = valor;
		}
		else {
			this.pago = valorCentavos;
		}
	}
	
	/**
	 *	retorna o valor que ainda falta para pagar tudo. 
	 * @return a quantia que falta ser paga
	 */
	public int getFaltaPagar() {
		return this.valor - this.pago;
	}
	
	/**
	 * retorna os atributos do objeto em formato de string.
	 */
	public String toString() {
		return this.nome + " " + this.itens + " " + this.valor;
	}
	/**
	 * metodo que retorna o nome do objeto, usado na classe Aluno.
	 * @return nome da cantina
	 */
	public String getNome() {
		return this.nome;
	}
}

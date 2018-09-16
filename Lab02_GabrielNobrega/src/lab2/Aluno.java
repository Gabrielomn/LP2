package lab2;

import java.util.ArrayList;
/**
 * Classe que tem o intuito de representar alunos e todas as suas funcionabilidades no contexto de ContaCantina
 * ContaLaboratorio, Disciplinas e Saúde
 * @author gabriel
 *
 */
public class Aluno {
	
	private String nome;
	/**
	 *objeto do tipo Saude, contém saude fisica e mental de
	 *um aluno, bem como um emoji correspondente a seu humor no momento.
	 */
	private Saude saude;
	
	/**
	 * ArrayList contendo todas as disciplinas do tipo Disciplina do aluno
	 */
	private ArrayList <Disciplina> disciplinas;
	
	/**
	 * ArrayList contendo todas as contas de 
	 * laboratorio do tipo ContaLaboratorio do aluno
	 */
	private ArrayList <ContaLaboratorio> contaLab;
	
	/**
	 * ArrayList contendo todas as contas de cantina do tipo 
	 * ContaLaboratorio do aluno
	 */
	private ArrayList <ContaCantina> contaCantina;
	
	/**
	 * Construtor de Aluno, apenas instancia o objeto com todos
	 * os seus atributos vazios.
	 */
	public Aluno(String nome) {
		this.nome = nome;
		this.contaCantina = new ArrayList<>();
		this.disciplinas = new ArrayList<>();
		this.contaLab = new ArrayList<>();
		this.saude = new Saude();
	}
	
	/**
	 * Cadastra na ArrayList correspodente um objeto do tipo ContaLaboratorio
	 * com o nome nomeLaboratorio.
	 * @param nomeLaboratorio
	 */
	public void cadastraLaboratorio(String nomeLaboratorio) {
		this.contaLab.add(new ContaLaboratorio(nomeLaboratorio));
	}
	
	/**
	 * Cadastra na ArrayList correspodente um objeto do tipo ContaLaboratorio
	 * com o nome nomeLaboratorio utilizando o construtor que recebe como parametro
	 * também a cota.
	 * @param nomeLaboratorio
	 */	
	public void cadastraLaboratorio(String nomeLaboratorio, int cota) {
		this.contaLab.add(new ContaLaboratorio(nomeLaboratorio, cota));
	}
	
	/**
	 * Percorre a ArrayList que contem os laboratorios em busca de um laboratorio
	 * com o nome igual ao do parâmetro passado.
	 * @param nomeLaboratorio
	 * @return objeto com o nome do parametro.
	 */
	private ContaLaboratorio procuraLab(String nomeLaboratorio) {
		
		for (ContaLaboratorio conta : contaLab) {
			if (conta.getNome().equals(nomeLaboratorio)) {
				return conta;
			}
		}
		return null;
	}
	
	/**
	 * Consome mbytes do laboratorio de nome nomeLaboratorio
	 * @param nomeLaboratorio
	 * @param mbytes
	 */
	public void consomeEspaco(String nomeLaboratorio, int mbytes) {
		
		ContaLaboratorio conta = this.procuraLab((nomeLaboratorio));
		
		if (conta != null) {
			conta.consomeEspaco(mbytes);
		}	
	}
	
	/**
	 * Libera mbytes do laboratorio de nome nomeLaboratorio
	 * @param nomeLaboratorio
	 * @param mbytes
	 */
	public void liberaEspaco(String nomeLaboratorio, int mbytes) {
		ContaLaboratorio conta = this.procuraLab((nomeLaboratorio));
		
		if (conta != null) {
			conta.liberaEspaco(mbytes);
		}
	}
	
	/**
	 * Verifica se a conta do aluno no laboratorio de nome nomeLaboratorio
	 * atingiu o limite de cota. Caso o laboratorio não exista, ele retorna TRUE.
	 * @param nomeLaboratorio
	 * @return true caso tenha atingido a cota no lab, false caso nao
	 */
	public boolean atingiuCota(String nomeLaboratorio) {
		ContaLaboratorio conta = this.procuraLab((nomeLaboratorio));
		
		if (conta != null) {
			return conta.atingiuCota();
		}
		else {
			return true;
		}
	}
	
	/**
	 * Retorna os dados do laboratorio correspondente utilizando o proprio 
	 * toString do objeto.
	 * @param nomeLaboratorio
	 * @return retorna o nome do laboratorio e a situação da cota no mesmo
	 */
	public String laboratorioToString(String nomeLaboratorio) {
		ContaLaboratorio conta = this.procuraLab((nomeLaboratorio));
		if (conta != null) {
			return conta.toString();
		}
		else {
			return "";
		}
	}
	
	/**
	 * Cadastra uma nova disciplina de nome nomeDisciplina
	 *  no ArrayList correspondente às disciplinas
	 * @param nomeDisciplina
	 */
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplinas.add(new Disciplina(nomeDisciplina));
	}
	
	/**
	 * Cadastra uma nova disciplina de nome nomeDisciplina
	 *  no ArrayList correspondente às disciplinas e com numNotas notas.
	 * @param nomeDisciplina
	 */
	public void cadastraDisciplina(String nomeDisciplina, int numNotas) {
		this.disciplinas.add(new Disciplina(nomeDisciplina, numNotas));
	}
	
	/**
	 * Cadastra uma nova disciplina de nome nomeDisciplina
	 *  no ArrayList correspondente às disciplinas e com numNotas notas e com
	 *  os pesos determinados no array.
	 * @param nomeDisciplina
	 */
	public void cadastraDisciplina(String nomeDisciplina, int numNotas, int[] pesos) {
		this.disciplinas.add(new Disciplina(nomeDisciplina, numNotas, pesos));
	}
	
	/**
	 * Percorre a ArrayList que contem as disciplinas em busca de uma disciplina
	 * com o nome igual ao do parâmetro passado.
	 * @param nomeDisciplina
	 * @return objeto com o nome do parametro.
	 */
	private Disciplina procuraDisciplina(String nomeDisciplina) {
		
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(nomeDisciplina)) {
				return disciplina;
			}
		}
		return null;
	}
	/**
	 * Cadastra horas igual ao parametro na disciplina correspondente
	 * @param nomeDisciplina
	 * @param horas
	 */
	public void cadastraHoras(String nomeDisciplina, int horas) {
		Disciplina disciplina = this.procuraDisciplina(nomeDisciplina);
		if (disciplina != null) {
			disciplina.cadastraHoras(horas);
		}
	}
	/**
	 * cadastra a nota valorNota, onde nota é o indice do elemento correspondente
	 * a mesma nota, tudo isso na disciplina de nome nomeDisciplina.
	 * @param nomeDisciplina
	 * @param nota
	 * @param valorNota
	 */
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		Disciplina disciplina = this.procuraDisciplina(nomeDisciplina);
		if (disciplina != null) {
			disciplina.cadastraNota(nota, valorNota);
		}
	}
	/**
	 * verifica se o aluno foi aprovado na disciplina de nome nomeDisciplina
	 * @param nomeDisciplina
	 * @return booleano dizendo se foi aprovado ou nao
	 */
	public boolean aprovado(String nomeDisciplina) {
		Disciplina disciplina = this.procuraDisciplina(nomeDisciplina);
		if (disciplina != null) {
			return disciplina.aprovado();
		}
		else {
			return false;
		}
	}
	
	/**
	 * pega os dados do aluno na disciplina correspondente ao nomeDisciplina.
	 * @param nomeDisciplina
	 * @return retorna os dados na disciplina, o nome da mesma, horas gastas, a media e suas notas.
	 */
	public String disciplinaToString(String nomeDisciplina) {
		Disciplina disciplina = this.procuraDisciplina(nomeDisciplina);
		if (disciplina != null) {
			return disciplina.toString();
		}
		else {
			return "";
		}
	}
	
	/**
	 * cadastra nova disciplina de nome nomeCantina na arraylist.
	 * @param nomeCantina
	 */
	public void cadastraCantina(String nomeCantina) {
		this.contaCantina.add(new ContaCantina(nomeCantina));
	}
	
	/**
	 * procura objeto do tipo ContaCantina correspondente no arraylist
	 * @param nomeCantina
	 * @return
	 */
	private ContaCantina procuraCantina(String nomeCantina) {
		
		for (ContaCantina conta : contaCantina) {
			if (conta.getNome().equals(nomeCantina)) {
				return conta;
			}
		}
		return null;
	}
	
	/**
	 * Cadastra qtdItens lanches com o valor valorCentavos na 
	 * cantina de nome nomeCantina.
	 * @param nomeCantina
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		ContaCantina conta = procuraCantina(nomeCantina);
		if (conta != null) {
			conta.cadastraLanche(qtdItens, valorCentavos);
		}
	}
	/**
	 * Cadastra qtdItens lanches com o valor valorCentavos na 
	 * cantina de nome nomeCantina.
	 * @param nomeCantina
	 * @param qtdItens
	 * @param valorCentavos
	 */
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos, String detalhe) {
		ContaCantina conta = procuraCantina(nomeCantina);
		if (conta != null) {
			conta.cadastraLanche(qtdItens, valorCentavos, detalhe);
		}
	}
	
	/**
	 * paga valorCentavos na conta de nome nomeCantina.
	 * @param nomeCantina
	 * @param valorCentavos
	 */
	public void pagarConta(String nomeCantina, int valorCentavos) {
		ContaCantina conta = procuraCantina(nomeCantina);
		if (conta != null) {
			conta.pagaConta(valorCentavos);
		}
	}
	
	/**
	 *  
	 * @param nomeCantina
	 * @return retorna o valor que falta pagar na contaCantina correspondente.
	 */
	public int faltaPagar(String nomeCantina) {
		ContaCantina conta = procuraCantina(nomeCantina);
		if (conta != null) {
			return conta.getFaltaPagar();
		}
		else {
			return 0;
		}
	}
	
	/**
	 *  
	 * @param nomeCantina
	 * @return retorna o valor que falta pagar na contaCantina correspondente.
	 */
	public String listarDetalhes(String nomeCantina) {
		ContaCantina conta = procuraCantina(nomeCantina);
		if (conta != null) {
			return conta.listarDetalhes();
		}
		else {
			return "";
		}
	}
	
	
	/**
	 * Retorna os dados correspondentes à cantina de nome nomeCantina.
	 * @param nomeCantina
	 * @return retorna os dados de cantina, o quanto fala pagar e seu nome
	 */
	public String cantinaToString(String nomeCantina) {
		ContaCantina conta = procuraCantina(nomeCantina);
		if (conta != null) {
			return conta.toString();
		}
		return "";
	}
	
	/**
	 * Define a saude mental do aluno.
	 * @param valor
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a saude fisica do aluno.
	 * @param valor
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Define emoji correspondente ao humor do aluno.
	 * @param valor
	 */
	public void defineEmoji(String valor) {
		this.saude.definirEmoji(valor);
	}
	
	/**
	 * retorna o status geral do aluno, contendo a saude fisica, mental
	 *  e o emoji caso cadastrado.
	 * @return diz o status geral do aluno no que diz saude
	 */
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}
	
	/**
	 * get do nome
	 * @return nome do Aluno
	 */
	public String getNome() {
		return this.nome;
	}
}
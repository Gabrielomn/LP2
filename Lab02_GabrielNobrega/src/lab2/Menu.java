package lab2;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Classe que cuida das manipulações possíveis de aluno, basicamente um menu para que possa
 * alterar o objeto Aluno.
 * @author gabriel
 *
 */
public class Menu {	
	
	/**
	 * ArrayList que armazena os alunos 
	 */
	private ArrayList <Aluno> alunos;
		
	/**
	 * Construtor de Menu, apenas inicia um arraylist de alunos vazio
	 */
	public Menu() {
		this.alunos = new ArrayList<Aluno> ();
	}
	
	/**
	 * metodo que serve apenas para mostrar as opções quando já se foi selecionado um aluno
	 */
	private void showOptions() {
		System.out.println("------------------------ MENU ------------------------");
		System.out.println("Digite seu comando no formato COMANDO;PARAMETRO1;PARAMETRO2...");
		System.out.println("Digite 'MOSTRAR OPCOES' para mostrar os comandos possíveis.");
		System.out.println("Ou digite apenas '0' para sair");
	}
	
	/**
	 * metodo que captura os comandos dados quando já se tem um aluno selecionado
	 * @param aluno
	 */
	private void controle(Aluno aluno) {
		while (true) {
			
			this.showOptions();
			Scanner sc = new Scanner(System.in);
			String comandos[] = new String[10];
			String entrada;
			entrada = sc.nextLine();
			comandos = entrada.split(";");
			if (comandos[0] == "0") {
				break;
			}
			
			else if (comandos[0].equals("MOSTRAR OPCOES")) {
				this.opcoes();
			}
			
			else if (comandos[0].equals("CONSOME")) {
				aluno.consomeEspaco(comandos[1], Integer.parseInt(comandos[2]));
			}
			
			else if (comandos[0].equals("LIBERA")) {
				aluno.liberaEspaco(comandos[1], Integer.parseInt(comandos[2]));
			}
			
			else if (comandos[0].equals("CADASTRA LABORATORIO")) {
				this.cdLab(aluno, comandos);
			}
			
			else if (comandos[0].equals("ATINGIU COTA")) {
				System.out.println(aluno.atingiuCota(comandos[1]));
			}
			
			else if (comandos[0].equals("LABORATORIOTOSTRING")) {
				System.out.println(aluno.laboratorioToString(comandos[1]));
			}
			
			else if (comandos[0].equals("CADASTRA DISCIPLINA")) {
				this.cdDisciplina(aluno, comandos);
			}
			else if (comandos[0].equals("CADASTRA HORAS")) {
				aluno.cadastraHoras(comandos[1], Integer.parseInt(comandos[2]));
			}
			else if (comandos[0].equals("CADASTRA HORAS")) {
				aluno.cadastraHoras(comandos[1], Integer.parseInt(comandos[2]));
			}
			else if (comandos[0].equals("CADASTRA NOTA")) {
				aluno.cadastraNota(comandos[1], Integer.parseInt(comandos[2]), Double.parseDouble(comandos[3]));
			}
			else if (comandos[0].equals("APROVADO")) {
				System.out.println(aluno.aprovado(comandos[1]));
			}
			else if (comandos[0].equals("DISCIPLINATOSTRING")) {
				System.out.println(aluno.disciplinaToString(comandos[1]));
			}
			else if (comandos[0].equals("CADASTRA CANTINA")) {
				aluno.cadastraCantina(comandos[1]);
			}
			else if (comandos[0].equals("CADASTRA LANCHE")) {
				this.cdLanche(aluno, comandos);
			}
			else if (comandos[0].equals("PAGAR CONTA")) {
				aluno.pagarConta(comandos[1], Integer.parseInt(comandos[2]));
			}
			else if (comandos[0].equals("FALTA PAGAR")) {
				System.out.println(aluno.faltaPagar(comandos[1]));
			}
			else if (comandos[0].equals("LISTAR DETALHES")) {
				System.out.println(aluno.listarDetalhes(comandos[1]));
			}
			
			else if (comandos[0].equals("CANTINATOSTRING")) {
				System.out.println(aluno.cantinaToString(comandos[1]));
			}
			else if (comandos[0].equals("DEFINE SAUDE MENTAL")) {
				aluno.defineSaudeMental(comandos[1]);
			}
			else if (comandos[0].equals("DEFINE SAUDE FISICA")) {
				aluno.defineSaudeFisica(comandos[1]);
			}
			else if (comandos[0].equals("DEFINE EMOJI")) {
				aluno.defineEmoji(comandos[1]);
			}
			else if (comandos[0].equals("GET STATUS GERAL")) {
				System.out.println(aluno.getStatusGeral());
			}

		}
	}
	
	/**
	 * Metodo que imprime as opcoes em controle. 
	 */
	public void opcoes() {
		System.out.println("POSSÍVEIS COMANDOS");
		System.out.println("1. CADASTRA LABORATORIO");
		System.out.println("2. CADASTRA CANTINA");
		System.out.println("3. CADASTRA DISCIPLINA");
		System.out.println("4. CADASTRA LABORATORIO");
		System.out.println("5. CONSOME");
		System.out.println("6. LIBERA");
		System.out.println("7. LABORATORIOTOSTRING");
		System.out.println("8. ATINGIU COTA");
		System.out.println("9. CADASTRA HORAS");
		System.out.println("10. CADASTRA NOTA");
		System.out.println("11. APROVADO");
		System.out.println("12. DISCIPLINATOSTRING");
		System.out.println("13. CADASTRA LANCHE");
		System.out.println("14. PAGAR CONTA");
		System.out.println("15. FALTA PAGAR");
		System.out.println("16. LISTAR DETALHES");
		System.out.println("17. CANTINATOSTRING");
		System.out.println("18. DEFINE SAUDE FISICA");
		System.out.println("19. DEFINE SAUDE MENTAL");
		System.out.println("20. DEFINE EMOJI");
		System.out.println("21. GET STATUS GERAL");
	}
	
	/**
	 * Metodo inicial que cadastra alunos, ou que recebe o nome do aluno que deseja alterar os dados e o passa para
	 * o método que lida com os comandos.
	 */
	public void menu() {
		
		while (true) {
		String opcao;
		Scanner sc = new Scanner(System.in);
		System.out.println("CASO EXISTA O ALUNO, DIGITE 1, SE FOR CADASTRAR 2, SAIR 0");
		opcao = sc.nextLine();
		
		if (opcao.equals("0")){
			break;
		}
		
		else if (opcao.equals("2")) {
			System.out.println("Digite o nome do aluno");
			String nome;
			nome = sc.nextLine();
			this.alunos.add(new Aluno(nome));
		}
	
		else {
			System.out.println("Digite o nome do aluno");
			String nome;
			Aluno aluno;
			nome = sc.nextLine();
			aluno = this.procuraAluno(nome);
			this.controle(aluno);
			}
		}
	}
	
	/**
	 * metodo que retorna o aluno com esse nome nomeAluno. 
	 * @param nomeAluno
	 * @return
	 */
	private Aluno procuraAluno (String nomeAluno) {
		
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equals(nomeAluno)) {
				return aluno;
			}
		}
		return null;
	}
	
	/**
	 * metodo que decide qual construtor de Disciplina chamar, em virtude do numero de parametros passados.
	 * @param aluno
	 * @param comandos
	 */
	private void cdDisciplina(Aluno aluno, String[] comandos) {
		if (comandos.length == 2) {
			aluno.cadastraDisciplina(comandos[1]);
		}
		else if (comandos.length == 3) {
			aluno.cadastraDisciplina(comandos[1], Integer.parseInt(comandos[2]));
		}
	}

	/**
	 * metodo que decide qual construtor de ContaLaboratorio chamar, em virtude do numero de parametros passados.
	 * @param aluno
	 * @param comandos
	 */
	private void cdLab(Aluno aluno, String[] comandos) {
		if (comandos.length == 2) {
			aluno.cadastraLaboratorio(comandos[1]);
		}
		else if (comandos.length == 3) {
			aluno.cadastraLaboratorio(comandos[1], Integer.parseInt(comandos[2]));
		}
	}
	
	/**
	 * Metodo que decide qual metodo cadastraLanche chamar em virtude do número de parametros
	 * @param aluno
	 * @param comandos
	 */
	private void cdLanche(Aluno aluno, String[] comandos) {
		if (comandos.length == 4) {
			aluno.cadastraLanche(comandos[1], Integer.parseInt(comandos[2]), Integer.parseInt(comandos[3]));
		}
		else {
			aluno.cadastraLanche(comandos[1], Integer.parseInt(comandos[2]), Integer.parseInt(comandos[3]), comandos[4]);

		}
	}
}
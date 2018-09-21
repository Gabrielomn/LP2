package lab03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {

	private Agenda agendaTeste;
	private Agenda outraAgenda;

	@BeforeEach
	void setUp() throws Exception {
		this.agendaTeste = new Agenda();
		this.outraAgenda = new Agenda();

		agendaTeste.cadastraContato(3, "matheus", "Costa", 5);
		outraAgenda.cadastraContato(3, "matheus", "Costa", 5);

	}

	@Test
	void testCadastraContato() {
		assertEquals(agendaTeste.cadastraContato(2, "matheus", "lawl", 3), "CADASTRO REALIZADO!");

	}

	@Test
	void testCadastraContatoFalha() {
		assertEquals(agendaTeste.cadastraContato(102, "Leo", "Sales", 4), "POSIÇÃO INVÁLIDA!");
	}

	@Test
	void testExibirContato() {
		assertEquals(agendaTeste.exibirContato(3), "matheus Costa - null");

	}

	@Test
	void testExibirContatoNaoExistente() {
		assertEquals(agendaTeste.exibirContato(2), "POSIÇÃO INVÁLIDA!");
	}

	@Test
	void testTentaCadastrarContatoComParametroVazio() {
		try {
			this.agendaTeste.cadastraContato(2, "", "Senpai", 3);
			fail("Nao devia ter chegado aqui");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testCadastrarContatoComParametroNull() {
		try {
			this.agendaTeste.cadastraContato(2, null, "Nobrega", 5);
			fail("Nao devia chegar aqui");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testTentaCadastrarPosicaoLimiteSup() {
		assertEquals(agendaTeste.cadastraContato(100, "Gabriel", "Nobrega", 5), "CADASTRO REALIZADO!");

	}

	@Test
	void testTentaCadastrarAcimaPosicaoLimite() {
		assertEquals(agendaTeste.cadastraContato(101, "Gabriel", "Nobrega", 5), "POSIÇÃO INVÁLIDA!");

	}

	@Test
	void testTentaCadastrarPosicaoLimiteInfer() {
		assertEquals(agendaTeste.cadastraContato(0, "Gabriel", "Nobrega", 3), "POSIÇÃO INVÁLIDA!");
	}

	@Test
	void testExibirContatoPosicaoNegativa() {
		try {
			agendaTeste.exibirContato(-3);
			fail("Nao devia ter chegado aqui");
		} catch (ArrayIndexOutOfBoundsException aiobe) {

		}
	}

	@Test
	void testExibirContatoPosicaoForaEscopo() {
		try {
			agendaTeste.exibirContato(130);
			fail("Nao devia ter chegado aqui");
		} catch (ArrayIndexOutOfBoundsException aiobe) {

		}
	}

	@Test
	void testListarContatos() {
		assertEquals(agendaTeste.listarContatos(), "3 - matheus Costa - irmão\n");
	}

	@Test
	void testEqualsAgendaTrue() {
		assertEquals(agendaTeste.equals(outraAgenda), true);

	}

	@Test
	void testEqualsAgendaFalse() {
		outraAgenda.cadastraContato(2, "Gabriel", "Nobrega", 5);
		assertEquals(agendaTeste.equals(outraAgenda), false);

	}

	@Test
	void testCadastraTelefone() {
		assertEquals(this.agendaTeste.cadastraTel("matheus", "Costa", "celular", 55, 83, 999328204),
				"TELEFONE CADASTRADO COM SUCESSO!");
	}

	@Test
	void testCadastraTelefoneContatoNaoExistente() {
		assertEquals(this.agendaTeste.cadastraTel("felipe", "costa", "celular", 55, 83, 999328204),
				"CONTATO NAO EXISTENTE!");

	}

	@Test
	void testConsultaPorNome() {
		this.agendaTeste.cadastraContato(2, "matheus", "silva", 5);
		this.agendaTeste.cadastraContato(4, "Gabriel", "Nobrega", 5);
		assertEquals(this.agendaTeste.consultaPorNome("matheus"), "matheus silva - irmão\nmatheus Costa - irmão\n");
	}

	@Test
	void testConsultaPorContatoExistente() {
		assertEquals(this.agendaTeste.consultaPorContato("matheus", "Costa"), "matheus Costa - irmão");
	}

	@Test
	void testConsultaContatoNaoExistente() {
		assertEquals(this.agendaTeste.consultaPorContato("matheus", "silva"), "CONTATO NAO ENCONTRADO");
	}

	@Test
	void testConsultaPorAmizade() {
		this.agendaTeste.cadastraContato(8, "Gabriel", "Nobrega", 5);
		this.agendaTeste.cadastraContato(22, "tonho", "tonhoue", 4);
		assertEquals(this.agendaTeste.consultaPorAmizade(5), "matheus Costa - irmão\nGabriel Nobrega - irmão\n");
	}
	
	@Test
	void testConsultaPorAmizadeZero() {
		this.agendaTeste.cadastraContato(8, "Gabriel", "Nobrega", 5);
		this.agendaTeste.cadastraContato(22, "tonho", "tonhoue", 4);
		assertEquals(this.agendaTeste.consultaPorAmizade(3), "");
	}

	@Test
	void testNumeroPorAmizade() {
		this.agendaTeste.cadastraContato(8, "Gabriel", "Nobrega", 5);
		this.agendaTeste.cadastraContato(22, "tonho", "tonhoue", 4);
		assertEquals(this.agendaTeste.numeroDeContatosAmizade(5), 2);
	}
	
	@Test
	void testNumeroPorAmizadeZero() {
		this.agendaTeste.cadastraContato(8, "Gabriel", "Nobrega", 5);
		this.agendaTeste.cadastraContato(22, "tonho", "tonhoue", 4);
		assertEquals(this.agendaTeste.numeroDeContatosAmizade(2), 0);
	}
	
	@Test
	void testMediaAmizade() {
		this.agendaTeste.cadastraContato(8, "Gabriel", "Nobrega", 5);
		this.agendaTeste.cadastraContato(22, "tonho", "tonhoue", 4);
		assertEquals(this.agendaTeste.mediaAmizade(), 14.0/3);
	}
	
	@Test
	void testMediaAmizadeZero() {
		Agenda novaAgenda = new Agenda();
		assertEquals(novaAgenda.mediaAmizade(),0);
	}
}

package lab03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgendaTest {
	/*
	private Agenda agendaTeste;
	private Agenda outraAgenda;

	
	@BeforeEach
	void setUp() throws Exception {
		this.agendaTeste = new Agenda();
		this.outraAgenda = new Agenda();

		agendaTeste.cadastraContato(3, "Joao", "Costa", "242");
		outraAgenda.cadastraContato(3, "Joao", "Costa", "242");


	}

	@Test
	void testCadastraContato() {
		assertEquals(agendaTeste.cadastraContato(2, "Yves", "Dantas", "24242424"),"CADASTRO REALIZADO!");
		
	}

	@Test
	void testCadastraContatoFalha() {
		assertEquals(agendaTeste.cadastraContato(102, "Leo", "Sales", "2432"), "POSIÇÃO INVÁLIDA!");
	}
	
	@Test
	void testExibirContato() {
		assertEquals(agendaTeste.exibirContato(3),"Joao Costa - 242");

	}
	@Test
	void testExibirContatoNaoExistente() {
		assertEquals(agendaTeste.exibirContato(2), "POSIÇÃO INVÁLIDA!");
	}
	
	@Test
	void testTentaCadastrarContatoComParametroVazio() {
		try {
			this.agendaTeste.cadastraContato(2, "", "Senpai", "doesnt matter");
			fail("Nao devia ter chegado aqui");
		}
		catch (IllegalArgumentException iae) {
			
		}
	}
	
	@Test
	void testCadastrarContatoComParametroNull() {
		try {
			this.agendaTeste.cadastraContato(2, null, "Nobrega", "666");
			fail("Nao devia chegar aqui");
		}
		catch (NullPointerException npe) {
			
		}
	}
	
	@Test
	void testTentaCadastrarPosicaoLimiteSup() {
		assertEquals(agendaTeste.cadastraContato(100, "Gabriel", "Nobrega", "666"),"CADASTRO REALIZADO!");
		
	}
	
	@Test
	void testTentaCadastrarAcimaPosicaoLimite() {
		assertEquals(agendaTeste.cadastraContato(101, "Gabriel", "Nobrega", "666"),"POSIÇÃO INVÁLIDA!");

	}
	
	@Test
	void testTentaCadastrarPosicaoLimiteInfer() {
		assertEquals(agendaTeste.cadastraContato(0, "Gabriel", "Nobrega", "666"), "POSIÇÃO INVÁLIDA!");
	}
	 
	@Test
	void testExibirContatoPosicaoNegativa() {
		try {
		agendaTeste.exibirContato(-3);
		fail("Nao devia ter chegado aqui");}
		catch (ArrayIndexOutOfBoundsException aiobe) {
			 
		}
	}
	
	@Test
	void testExibirContatoPosicaoForaEscopo() {
		try {
			agendaTeste.exibirContato(130);
			fail("Nao devia ter chegado aqui");
		}
		catch(ArrayIndexOutOfBoundsException aiobe) {
			
		}
	}

	@Test
	void testListarContatos() {
		assertEquals(agendaTeste.listarContatos(), "3 - Joao Costa\n");
	}

	@Test
	void testEqualsAgendaTrue() {
		assertEquals(agendaTeste.equals(outraAgenda), true);
		
	}
	@Test
	void testEqualsAgendaFalse() {
		outraAgenda.cadastraContato(2, "Gabriel", "Nobrega", "666");
		assertEquals(agendaTeste.equals(outraAgenda), false);
		
	}
	*/
}

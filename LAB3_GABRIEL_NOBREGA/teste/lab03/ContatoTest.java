package lab03;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContatoTest {

	private Contato c1;
	private Contato c3;

	@BeforeEach
	void setUp() throws Exception {
		this.c1 = new Contato("Gabriel", "Nobrega", 5);
		this.c3 = new Contato("Gabryel", "Nobrega", 3);
	}

	@Test
	void testContato() {
		assertEquals(c1.getNome(), "Gabriel");
	}

	@Test
	void testToString() {
		assertEquals(c1.toString(), "Gabriel Nobrega - irmão");
	}

	@Test
	void testExibir() {
		assertEquals(c1.exibir(), "Gabriel Nobrega - null");
	}

	@Test
	void testEquals() {
		Contato c2 = new Contato("Gabriel", "Nobrega", 4);
		assertEquals(c1.equals(c2), true);
	}

	@Test
	void testEqualsFalhaNome() {
		assertEquals(c1.equals(c3), false);
	}

	@Test
	void testEqualsFalhaSobrenome() {
		Contato c4 = new Contato("Gabriel", "Fernandes", 3);
		assertEquals(c1.equals(c3), false);
	}

	@Test
	void testCadastraTelefone() {
		this.c1.cadastraTelefone("celular", 55, 83, 999328204);
		assertEquals(c1.exibir(), "Gabriel Nobrega - celular: +55(83)999328204");
	}

	@Test
	void testSeAparecePrimeiroTel() {
		this.c1.cadastraTelefone("celular", 55, 83, 999328204);
		this.c1.cadastraTelefone("celular", 55, 83, 999328203);
		assertEquals(c1.exibir(), "Gabriel Nobrega - celular: +55(83)999328204");

	}

	@Test
	void testParametroVazio() {
		try {
			Contato c2 = new Contato("Gabriel", "", 3);
			fail("Nao devia chegar aq");
		}
		catch (IllegalArgumentException iae){
			
		}
	}
	
	@Test
	void testNivelForaDoLimite() {
		try {
			Contato c2 = new Contato("Gabriel", "Nobrega", 6);
			fail("Nao devia estar aqui");
		}
		catch (IllegalArgumentException iae) {
			
		}
	}

}

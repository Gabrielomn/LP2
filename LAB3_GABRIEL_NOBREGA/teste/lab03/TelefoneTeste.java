package lab03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TelefoneTeste {

	private Telefone telefoneTeste;
	
	@BeforeEach
	void setup() {
		this.telefoneTeste = new Telefone("celular", 55, 83, 999328204);
	}
	
	@Test
	void testTelefone() {
		assertEquals("celular: +55(83)999328204", telefoneTeste.toString());
	}
}

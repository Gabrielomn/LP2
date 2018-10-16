package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlunoTest {
	
	private Aluno a;
	
	@BeforeEach
	void setup() {
		this.a = new Aluno("Gabriel", "12", "cc");

	}
	
	
	@Test
	void testEqualsObjectVerdade() {
		Aluno b = new Aluno("Biel", "12", "ccc");
		assertTrue(this.a.equals(b));
	}
	
	@Test
	void testEqualsObjectFalse() {
		Aluno b = new Aluno("Gabriel", "13", "cc");
		assertFalse(this.a.equals(b));
	}	

	@Test
	void testToString() {
		assertEquals(this.a.toString(), "12 - Gabriel - cc");
	}

}
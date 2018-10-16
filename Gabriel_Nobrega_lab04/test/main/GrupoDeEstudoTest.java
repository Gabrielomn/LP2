package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoDeEstudoTest {

	private GrupoDeEstudo g;

	@BeforeEach
	void setup() {
		this.g = new GrupoDeEstudo("cc");
	}

	@Test
	void testCadastraAluno() {
		this.g.cadastraAluno(new Aluno("Gabriel", "12", "cc"));
		assertEquals("* 12 - Gabriel - cc\n", this.g.imprimeGrupo());
	}

	@Test
	void testImprimeGrupo() {
		this.g.cadastraAluno(new Aluno("Gabriel", "12", "cc"));
		this.g.cadastraAluno(new Aluno("Felipe", "14", "cc"));
		this.g.cadastraAluno(new Aluno("Leo", "13", "cc"));
		this.g.cadastraAluno(new Aluno("Yves", "15", "ee"));

		String msg = "* 12 - Gabriel - cc\n* 13 - Leo - cc\n* 14 - Felipe - cc\n* 15 - Yves - ee\n";
		assertEquals(msg, this.g.imprimeGrupo());
	}
	
	@Test
	void testImprimeGrupoVazio(){
		assertEquals("Nenhum aluno cadastrado em cc", this.g.imprimeGrupo());
	}
	
}

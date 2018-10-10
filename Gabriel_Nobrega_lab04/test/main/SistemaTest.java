package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaTest {
	
	private Sistema s;

	@BeforeEach
	void setup() {
		this.s = new Sistema();
	}
	
	@Test
	void testCadastraAlunoEConsultaAluno() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		assertEquals("12 - Gabriel - cc",this.s.consultaAluno("12"));
	}
	
	@Test
	void testAlunoNaoExistente() {
		assertEquals("Aluno não cadastrado.", this.s.consultaAluno("12"));
	}

	@Test
	void testCadastraGrupo() {
		this.s.cadastraGrupo("cc");
		assertEquals("Nenhum aluno cadastrado em cc",this.s.imprimeGrupo("cc"));
	}
	

	@Test
	void testCadastraNoGrupo() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		this.s.cadastraGrupo("cc");
		this.s.cadastraNoGrupo("cc", "12");
		assertEquals("* 12 - Gabriel - cc\n",this.s.imprimeGrupo("cc"));

	}

//
//	@Test
//	void testImprimeGrupo() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCadastraResposta() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testImprimirAlunosQuestoes() {
//		fail("Not yet implemented");
//	}

}

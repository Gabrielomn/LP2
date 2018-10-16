package main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.AlunoNaoExistenteException;
import exceptions.GrupoNaoExistenteException;

class SistemaTest {

	private Sistema s;

	@BeforeEach
	void setup() {
		this.s = new Sistema();
	}

	@Test
	void testCadastraAlunoIgual() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		assertFalse(this.s.cadastraAluno("Felipe", "12", "cc"));
	}

	@Test
	void testCadastraAlunoEConsultaAluno() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		try {
			assertEquals("12 - Gabriel - cc", this.s.consultaAluno("12"));
		} catch (AlunoNaoExistenteException anee) {
			fail("Esse aluno Deveria existir");
		}
	}

	@Test
	void testAlunoNaoExistente() {
		try {
			this.s.consultaAluno("12");
			fail("Nao deveria chegar aqui");
		} catch (AlunoNaoExistenteException anee) {
			assertEquals("Aluno nao cadastrado", anee.getMessage());
		}
	}

	@Test
	void testCadastraGrupo() {
		this.s.cadastraGrupo("cc");
		try {
			assertEquals("Nenhum aluno cadastrado em cc", this.s.imprimeGrupo("cc"));
		} catch (GrupoNaoExistenteException gnee) {
			fail("Nao deveria chegar aqui");
		}
	}

	@Test
	void testCadastraGrupoRepetido() {
		this.s.cadastraGrupo("cc");
		assertEquals(false, this.s.cadastraGrupo("cc"));
	}

	@Test
	void testCadastraEmGrupoNaoExistente() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		try {
			this.s.cadastraNoGrupo("IA", "12");
		} catch (GrupoNaoExistenteException gnee) {
			assertEquals("Grupo nao existente", gnee.getMessage());
		} catch (AlunoNaoExistenteException anee) {
			fail("Aluno deveria existir");
		}
	}

	@Test
	void testCadastraEmGrupoAlunoNaoExistente() {
		this.s.cadastraGrupo("cc");
		try {
			this.s.cadastraNoGrupo("cc", "12");
		} catch (AlunoNaoExistenteException anee) {
			assertEquals("Aluno nao cadastrado", anee.getMessage());
		} catch (GrupoNaoExistenteException gnee) {
			fail("Grupo deveria existir");
		}
	}

	@Test
	void testCadastraNoGrupo() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		this.s.cadastraGrupo("cc");
		try {
			this.s.cadastraNoGrupo("cc", "12");
			assertEquals("* 12 - Gabriel - cc\n", this.s.imprimeGrupo("cc"));
		} catch (GrupoNaoExistenteException gnee) {
			fail("Grupo deveria existir");
		} catch (AlunoNaoExistenteException anee) {
			fail("Aluno deveria existir");
		}

	}

	@Test
	void testCadastraRespostaAlunoNaoExistente() {
		try {
			this.s.cadastraResposta("12");
			fail("Deveria ter lançado exceção");
		} catch (AlunoNaoExistenteException anee) {
			assertEquals("Aluno nao cadastrado", anee.getMessage());
		}
	}

	@Test
	void testCadastraRespostaAluno() {
		this.s.cadastraAluno("Gabriel", "12", "CC");
		try {
			this.s.cadastraResposta("12");
			assertEquals("Alunos:\n" + "1. 12 - Gabriel - CC\n" + "", this.s.imprimirAlunosQuestoes());
		} catch (AlunoNaoExistenteException anee) {
			fail("Aluno deveria estar cadastrado");
		}
	}

	@Test
	void testImprimirAlunosQuestoesVazia() {
		assertEquals("Alunos:\n", this.s.imprimirAlunosQuestoes());
	}

	@Test
	void testImprimirAlunosQuestoes() {
		this.s.cadastraAluno("Gabriel", "12", "cc");
		this.s.cadastraAluno("Felipe", "13", "ee");
		try {
			this.s.cadastraResposta("12");
			this.s.cadastraResposta("12");
			this.s.cadastraResposta("13");
			this.s.cadastraResposta("13");
			this.s.cadastraResposta("12");
		} catch (AlunoNaoExistenteException anee) {
			fail("Alunos deveriam existir");
		}
		assertEquals("Alunos:\n" + "1. 12 - Gabriel - cc\n" + "2. 12 - Gabriel - cc\n" + "3. 13 - Felipe - ee\n"
				+ "4. 13 - Felipe - ee\n" + "5. 12 - Gabriel - cc\n", this.s.imprimirAlunosQuestoes());
	}

	@Test
	void testImprimirGrupoNaoExistente() {
		try {
			this.s.imprimeGrupo("web");
			fail("Grupo nao existe");
		} catch (GrupoNaoExistenteException gnee) {
			assertEquals("Grupo nao existente", gnee.getMessage());
		}
	}

	@Test
	void testCriarAlunoStringVazia() {
		try {
			this.s.cadastraAluno("", "12", "cc");
			fail("Nao deveria chegar aqui");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testCriarGrupoTemaVazio() {
		try {
			this.s.cadastraGrupo("");
			fail("Nao deveria chegar aqui");
		} catch (IllegalArgumentException iae) {
			
		}
	}
}
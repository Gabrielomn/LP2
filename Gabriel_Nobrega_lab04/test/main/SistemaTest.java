//package main;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//class SistemaTest {
//
//	private Sistema s;
//
//	@BeforeEach
//	void setup() {
//		this.s = new Sistema();
//	}
//
//	@Test
//	void testCadastraAlunoIgual() {
//		this.s.cadastraAluno("Gabriel", "12", "cc");
//		assertEquals("MATRÍCULA JÁ CADASTRADA!", this.s.cadastraAluno("Felipe", "12", "cc"));
//	}
//
//	@Test
//	void testCadastraAlunoEConsultaAluno() {
//		this.s.cadastraAluno("Gabriel", "12", "cc");
//		assertEquals("12 - Gabriel - cc", this.s.consultaAluno("12"));
//	}
//
//	@Test
//	void testAlunoNaoExistente() {
//		assertEquals("Aluno não cadastrado.", this.s.consultaAluno("12"));
//	}
//
//	@Test
//	void testCadastraGrupo() {
//		this.s.cadastraGrupo("cc");
//		assertEquals("Nenhum aluno cadastrado em cc", this.s.imprimeGrupo("cc"));
//	}
//
//	@Test
//	void testCadastraGrupoRepetido() {
//		this.s.cadastraGrupo("cc");
//		assertEquals("GRUPO JA CADASTRADO", this.s.cadastraGrupo("cc"));
//	}
//
//	@Test
//	void testCadastraEmGrupoNaoExistente() {
//		this.s.cadastraAluno("Gabriel", "12", "cc");
//		assertEquals("GRUPO NAO CADASTRADO.", this.s.cadastraNoGrupo("IA", "12"));
//	}
//
//	@Test
//	void testCadastraEmGrupoAlunoNaoExistente() {
//		this.s.cadastraGrupo("cc");
//		assertEquals("ALUNO NAO CADASTRADO.", this.s.cadastraNoGrupo("cc", "12"));
//	}
//
//	@Test
//	void testCadastraNoGrupo() {
//		this.s.cadastraAluno("Gabriel", "12", "cc");
//		this.s.cadastraGrupo("cc");
//		this.s.cadastraNoGrupo("cc", "12");
//		assertEquals("* 12 - Gabriel - cc\n", this.s.imprimeGrupo("cc"));
//
//	}
//
//	@Test
//	void testCadastraRespostaAlunoNaoExistente() {
//		assertEquals("ALUNO NAO CADASTRADO", this.s.cadastraResposta("12"));
//	}
//
//	@Test
//	void testCadastraRespostaAluno() {
//		this.s.cadastraAluno("Gabriel", "12", "CC");
//		assertEquals("ALUNO REGISTRADO!", this.s.cadastraResposta("12"));
//	}
//
//	@Test
//	void testImprimirAlunosQuestoesVazia() {
//		assertEquals("Alunos:\n", this.s.imprimirAlunosQuestoes());
//	}
//
//	@Test
//	void testImprimirAlunosQuestoes() {
//		this.s.cadastraAluno("Gabriel", "12", "cc");
//		this.s.cadastraAluno("Felipe", "13", "ee");
//		this.s.cadastraResposta("12");
//		this.s.cadastraResposta("12");
//		this.s.cadastraResposta("13");
//		this.s.cadastraResposta("13");
//		this.s.cadastraResposta("12");
//		assertEquals("Alunos:\n" + "1. 12 - Gabriel - cc\n" + "2. 12 - Gabriel - cc\n" + "3. 13 - Felipe - ee\n"
//				+ "4. 13 - Felipe - ee\n" + "5. 12 - Gabriel - cc\n", this.s.imprimirAlunosQuestoes());
//	}
//
//	@Test
//	void testImprimirGrupoNaoExistente() {
//		assertEquals("Grupo nao cadastrado", this.s.imprimeGrupo("web"));
//	}
//	
//	@Test
//	void testCriarAlunoStringVazia() {
//		try {
//			this.s.cadastraAluno("", "12", "cc");
//			fail("Nao deveria chegar aqui");
//		}
//		catch (IllegalArgumentException iae) {
//			
//		}
//	}
//	
//	@Test
//	void testCriarGrupoTemaVazio() {
//		try {
//			this.s.cadastraGrupo("");
//			fail("Nao deveria chegar aqui");
//		}
//		catch (IllegalArgumentException iae) {
//			
//		}
//	}
//}

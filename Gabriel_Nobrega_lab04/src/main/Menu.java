package main;

public class Menu {
	
	public String imprimeOpcoesPrincipais() {
		String msg = "(C)adastrar Aluno\n" + 

				"(E)xibir Aluno\n" + 

				"(N)ovo Grupo\n" + 

				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 

				"(R)egistrar Aluno que Respondeu\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!";
		
		return msg;
	}
	
	public void rodarMenu() {
		System.out.println(this.imprimeOpcoesPrincipais());
	}
}

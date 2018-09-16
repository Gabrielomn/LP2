package lab2;

public class Coisa {
	
    public static void main(String[] args) {

        ContaLaboratorio contaLCC2 = new ContaLaboratorio("LCC2");

        contaLCC2.consomeEspaco(1999);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.consomeEspaco(2);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(1);
        System.out.println(contaLCC2.atingiuCota());
        contaLCC2.liberaEspaco(1);
        System.out.println(contaLCC2.atingiuCota());
        System.out.println(contaLCC2.toString());
       
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2");

        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());
        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());
        
        /*
        int[] exemplo = {2,1,1,1,5};
        Disciplina progWeb = new Disciplina("Principios de Desenvolvimento Web",5,exemplo);
        
        progWeb.cadastraHoras(4);
        progWeb.cadastraNota(5, 10);
        progWeb.cadastraNota(2, 8);
        System.out.println(progWeb.toString());
        */
        ContaCantina cantinaSeuMatias = new ContaCantina("Seu Matias");            
        
        cantinaSeuMatias.cadastraLanche(2, 500);
        cantinaSeuMatias.cadastraLanche(1, 500);
        cantinaSeuMatias.pagaConta(200);
        System.out.println(cantinaSeuMatias.getFaltaPagar());
        System.out.println(cantinaSeuMatias.toString());
        /*cantinaSeuMatias.cadastraLanche(1, 500, "café");
        cantinaSeuMatias.cadastraLanche(1, 500, "hersheys");
        cantinaSeuMatias.cadastraLanche(1, 500, "Agua de um dos três cactos");

        System.out.println(cantinaSeuMatias.listarDetalhes());
       	*/
        Saude saude = new Saude();

        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("boa");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("fraca");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("fraca");
        /*saude.definirEmoji(";)");*/
        System.out.println(saude.getStatusGeral());
        /*
        Aluno gabriel = new Aluno("Gabriel");
     
        gabriel.cadastraCantina("Seu Olavo");
        gabriel.cadastraLanche("Seu Olavo", 3, 250);
        gabriel.pagarConta("Seu Olavo" , 5);
        System.out.println(gabriel.faltaPagar("Seu Olavo"));
        System.out.println(gabriel.cantinaToString("Seu Olavo"));
        gabriel.cadastraLaboratorio("LCC3", 3500);
        gabriel.consomeEspaco("LCC3", 2500);
        gabriel.liberaEspaco("LCC3", 250);
        System.out.println(gabriel.atingiuCota("LCC3"));
        System.out.println(gabriel.laboratorioToString("LCC3"));
        gabriel.cadastraDisciplina("LEDA");
        gabriel.cadastraHoras("LEDA", 3);
        gabriel.cadastraNota("LEDA", 2, 6);
        gabriel.cadastraNota("LEDA", 1, 9);
        gabriel.cadastraNota("LEDA", 3, 8);
        gabriel.cadastraNota("LEDA", 4, 10);
        System.out.println(gabriel.aprovado("LEDA"));
        System.out.println(gabriel.disciplinaToString("LEDA"));
        gabriel.defineSaudeFisica("fraca");
        gabriel.defineSaudeMental("boa");
        gabriel.defineEmoji("( ͡° ͜ʖ ͡°)");
        System.out.println(gabriel.getStatusGeral());
        */
        Menu menu = new Menu();
        menu.menu();
    }
}

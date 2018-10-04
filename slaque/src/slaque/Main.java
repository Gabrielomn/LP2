package slaque;

public class Main {
	
	public static void main(String[] args) {
		
		Controller c = new Controller();
		c.cadastraUsuario("g", "@ccc");
		c.cadastraUsuario("y","@ee");

		c.cadastraCanal("splab");
		c.cadastraCanal("vtex");
		c.cadastraUsuario("Joao", "jc@ccc");
		c.cadastraUsuario("Thay", "tr@ccc");
		c.entrarCanal("splab", "Joao");
		System.out.print(c.listaUsuariosEmCanal("splab"));
		c.saiCanal("splab", "Joao");
		System.out.print(c.listaUsuariosEmCanal("splab"));
		c.entrarCanal("vtex", "Thay");
		System.out.print(c.listaUsuariosEmCanal("vtex"));
		c.entrarCanal("vtex", "Joao");
		System.out.print(c.listaUsuariosEmCanal("vtex"));
		c.entrarCanal("vtex", "Felipe");
		System.out.println(c.listaUsuariosEmCanal("vtex"));
		c.entrarCanal("LSD", "Gabriel");
		System.out.println(c.listaUsuariosEmCanal("LSD"));
		
		c.listaMensagens("LSD");
		
		c.mandaMensagem("vtex", "Thay", "Ohayo");
		c.mandaMensagem("splab", "Joao", "oi");
		c.mandaMensagem("vtex", "Joao", "Oi");
		
		System.out.println(c.listaMensagens("vtex"));
		System.out.println(c.listaMensagens("splab"));
		
	}

}

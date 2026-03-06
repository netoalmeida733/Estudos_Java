package telefonica;

public class Main {
	public static void main(String[] args ) throws Exception {
		Telefonica telefone = new Telefonica ("4002-8922");
		//System.out.println(telefone.getContatos());
		
		Contato contato = new Contato ("Neto Almeida", "(16) 99712-8694");
		Contato contatoA = new Contato ("Lucas Arruda", "(11) 981909-2114");
		Contato contatoB = new Contato ("Jhon Cena   ", "(16) 99234-5678");
		Contato contatoC = new Contato ("Luan Alen   ", "(16) 99173-4986");
		
		Contatos telefoneContatos = telefone.getContatos();
		telefoneContatos.adicionar(contato);
		telefoneContatos.adicionar(contatoA);
		telefoneContatos.adicionar(contatoB);
		telefoneContatos.adicionar(contatoC);
		System.out.println(telefoneContatos);
		System.out.println("Contatos Filtrados = ");
		System.out.println(telefoneContatos.buscar("L"));
		
		telefone.ligar("(16) 99712-8694");
		System.out.println(telefone.getChamadas());
		
		telefone.ligar(contatoA);
		telefone.ligar(contatoB);
		telefone.ligar(contatoC);
		
		System.out.println(telefone.getChamadas());
	}
	
	
}

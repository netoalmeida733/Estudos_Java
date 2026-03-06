package telefonica;


public class Telefonica {
	//ATRIBUTOS
	private String numeroChip;
	private Contatos contatos;
	private Chamadas chamadas; 
	
	//METODO DE CONSTRUCAO 
	public Telefonica (String numeroChip) {
		this.numeroChip = numeroChip;
		this.contatos = new Contatos();
		this.chamadas = new Chamadas();
	}
	// METODO PRINCIPAL 
	public void ligar(String numeroDestino) {
		Ligacao ligacao = new Ligacao(numeroChip, numeroDestino);
		ligacao.ligar();
		chamadas.adicionar(ligacao);
	}
	public void ligar(Contato contatoDestino) {
		//Ligacao ligacao = new Ligacao(numeroChip, contatoDestino.getNumero());
		//ligacao.ligar();
		//chamadas.adicionar(ligacao);
		ligar(contatoDestino.getNumero());
	}
	
	
	//GETTERS AND SETTERS 

	public String getNumeroChip() {
		return numeroChip;
	}

	public Contatos getContatos() {
		return contatos;
	}

	public Chamadas getChamadas() {
		return chamadas;
	}

	
	
	
}

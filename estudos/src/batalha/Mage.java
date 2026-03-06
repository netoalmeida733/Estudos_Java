package batalha;

public class Mage extends Base{
	//ATRIBUTOS
	private String magia;
	
	
	//METODO CONSTRUTOR
	public Mage(String nome, int vida, int dano) {
		super(nome, vida, dano);
		this.magia= ("bola de fogo");//CORREÇAO DO CHAT
	}
	//METODO PRINCIPAL 
	@Override
	public void atacar() {
		System.out.printf("O %s usou sua %s, causando %d de dano\n", getNome(), magia , getDanoBase()+10);
	}

	
	//GETTERS AND SETTERS
	public String getMagia() {
		return magia;
	}
	public void setMagia(String magia) {
		this.magia = magia;
	}
	
}

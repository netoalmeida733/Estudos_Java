package guerrar;

public class Personagem {
	//ATRIBUTOS 
	private String nome;
	private int dano;
	private int vida;
	
	
	//METODO CONSTRUTOR
	public Personagem(String nome , int dano , int vida) {
		super();
		this.nome = nome;
		this.dano = dano;
		this.vida = vida;
	}
	
	// METEDO PRINCIPAL (ONDE ACONTECE OS EVENTOS)
	public void atacar() {
		System.out.println("Personagem atacando");
	}



	//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
		public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}

}

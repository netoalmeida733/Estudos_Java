package batalha;

public class Base {
	//ATRIBUTOS
	private String nome;
	private int vida;
	private int danoBase;
	private int dano;

	//METODO CONSTRUTOR 
	public Base(String nome, int vida, int dano) {
		super();
		this.nome = nome;
		this.vida = vida;
		this.danoBase = dano; // Correçao do Chat s
		this.dano = dano;
	}
	
	//METODO PRINCIPAL 
	public void atacar() {
		System.out.println("========= INICIO DA BATALHA! =========");
		System.out.printf("O personagem: %s\nVida: %d\nAtacou Causando: %d de dano base\n" , nome , vida , danoBase);
	}
	public void receberDano(int danoRecebido) {
		vida -= danoRecebido;

	    if (vida <= 0) {
	        System.out.printf(
	            "O personagem: %s\nDano Recebido: %d\nVida: %d.\nPERSONAGEM ELIMINADO!\n",
	            nome, danoRecebido, vida
	        );
	    } else {
	        System.out.printf(
	            "O personagem %s recebeu %d de dano, restando %d de vida\n",
	            nome, danoRecebido, vida
	        );
	    }
	}

	
	//GETTERS AND SETTERS
		public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getDanoBase() {
		return danoBase;
	}
	public void setDanoBase(int danoBase) {
		this.danoBase = danoBase;
	}
	
}

package guerrar;

public class Guerreiro extends Personagem {
	
	private String armamento;
	public Guerreiro(String nome , int dano, int vida) {
		super(nome , dano , vida);
		
		this.armamento = "espada";
	}
	@Override
	public void atacar() {
		System.out.println(
			    getNome() + " atacou com " + armamento + " causando " + getDano() + " de dano"
			);
	}
	}





package guerrar;

public class Mago extends Personagem{
	//ATRIUBUTOS
	private String magia;
	//METODO CONSTRUTOR
	public Mago(String nome , int dano , int vida ) {
		super(nome , dano , vida  );
		this.magia = "Magia Especial";
	}
	@Override
	public String toString() {
		return super.toString();
	}
	@Override
	public void atacar() {
		System.out.println(
			    getNome() + " lançou " + magia + " causando " + getDano() + " de dano"
			);
		
	}
	public String atacar (String magiaEspecial ) {
		System.out.printf("%s lançou %s causando %d de dano%n" , getNome() , magiaEspecial , getDano()+10);
		return magiaEspecial;
		
	}
}

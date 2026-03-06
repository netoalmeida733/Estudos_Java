
package navideos;

public class Filme extends Video {
	private String audio;
	private String legenda;
	
	public Filme(String nome) {
		super(nome);
		this.audio = "Portugues-Br";
		this.legenda = "nenhuma";
	}
	@Override
	public void play() {
		System.out.println("Play no filme: " + getNome());
	}
	public void play(String audio) {
		this.audio = audio;
		System.out.println("Play: " + toString());

	}
	
	public void play(String audio, String legenda) {
		this.audio = audio;
		this.legenda = legenda;
		System.out.println("Play: " + toString());

	}
	
	
	@Override
	public String toString() {
		String informacao = String.format("The film %s, contains the audio in %s and not contain %s legend", getNome(), audio , legenda);
		return informacao;
	}
}


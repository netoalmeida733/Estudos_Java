package navideos;

public class Video {
	//ATRIBUTOS 
	private String nome;
	
	// METODO CONSTRUTOR 
	public Video(String nome) {
		this.nome = nome;
	}
	public void play() {
		//System.out.println("Play: Video Qualquer no " + nome);
	}
	
	//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}

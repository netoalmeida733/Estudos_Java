package telefonica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ligacao {
	//ATRIBUTOS
	private String numeroOrigem;
	private String numeroDestino;
	private String horarioLigacao;

	
	
	//METODO CONSTRUTOR
	public Ligacao(String numeroOrigem, String numeroDestino) {
		
		this.numeroOrigem = numeroOrigem;
		this.numeroDestino = numeroDestino;
		this.horarioLigacao = horarioLigacao;
	}
		
		public Ligacao(Contato contatoOrigem, Contato contatoDestino) {
			
			this.numeroOrigem = contatoOrigem.getNumero();
			this.numeroDestino = contatoDestino.getNumero();
			this.horarioLigacao = horarioLigacao;
	}
	
	
	// METODO TOSTRING
	@Override
	public String toString() {
		String informacao = String.format("Origem do numero: %s\tDestino do numero: %s\tHorario: %s", numeroOrigem , numeroDestino, horarioLigacao);
		return informacao;
	}
	//METODO PRINCIPAL
	public void ligar() {
		System.out.println("Ligando para " + numeroDestino);
		System.out.println("Chamando...");
		System.out.println("OCUPADO!");
		// PADRAO BRASIL : dia / mes / ano horas: mm:ss
		// PADRAO AMERICANO : dd/ MM / YYYY HH: mm:ss
		DateTimeFormatter formatarData = DateTimeFormatter.ofPattern("dd/ MM / YYYY HH: mm:ss");
		LocalDateTime horarioAgora = LocalDateTime.now();
		horarioLigacao = formatarData.format(horarioAgora);
	}
	
	
	
	//GETTERS E SETTERS 
	public String getNumeroOrigem() {
		return numeroOrigem;
	}

	

	public String getNumeroDestino() {
		return numeroDestino;
	}

	
	
}

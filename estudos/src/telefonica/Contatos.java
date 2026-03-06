package telefonica;

import java.util.ArrayList;
import java.util.Iterator;

	public class Contatos {
	// ATRIBUTOS
	private ArrayList<Contato> contatos;
	
	
	//METODO CONSTRUTOR
	public Contatos() {
		this.contatos = new ArrayList<Contato>();	
		
	}
	
	@Override
		public String toString() {
		String informacao = "Contatos:\n";
		for (Contato contato : contatos) {
			informacao = informacao + contato.toString() + "\n";
		}
			return informacao;
		}
	
	//METODO PRINCIPAL
	public void adicionar(String nome, String numero) {
		Contato novoContato = new Contato(nome, numero);
		contatos.add(novoContato );
	}
	
	public Contatos buscar(String chave) {
		// PALAVRA CHAVE = "lU"
		// "lUCAS" "LUCIANO'
		String palavraChaveMinusculo = chave.toLowerCase();
		Contatos contatosFiltrados = new Contatos(); 
		for (Contato contato : contatos) {
			
			String nomeContato = contato.getNome().toLowerCase();
			if (nomeContato.startsWith(palavraChaveMinusculo)) {
				
				contatosFiltrados.adicionar(contato);
			}
		}
		return contatosFiltrados;
	}
	
	//SOBREPOSIÇAO
	public void adicionar( Contato novContato) {
		contatos.add(novContato); 
	}
	//GETTERS AND SETTERS
	public ArrayList<Contato> getContatos() {
		return contatos;
	}
	
}

package telefonica;

import java.util.ArrayList;

public class Chamadas {
	//ATRIBUTOS 
	private ArrayList<Ligacao> chamadas;
	
	//METODO CONSTRUTOR 
		public Chamadas() {
			this.chamadas = new ArrayList<Ligacao>();
		}
		//METODO PRINCIPAL 
		public void adicionar(Ligacao ligacao) {
			this.chamadas.add(ligacao);
		
		}
		//METODO TOSTRING
		@Override
		public String toString() {
			String informacao = "Chamadas: \n";
			for (Ligacao ligacao : chamadas) {
			informacao += ligacao.toString() + "\n";	
			}
			return informacao;
		}
}
	
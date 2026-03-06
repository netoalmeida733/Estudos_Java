package batalha;

import java.util.ArrayList;

public class RegistroBatalha {
	//ATRIBUTO 
	private ArrayList<String> historico;
	
	
	//METODO CONSTRUTOR
	public RegistroBatalha() {
		historico = new ArrayList<>();
	}
	
	
	//METODO PRINCIPAL 
	public void registrar(String evento){
		historico.add(evento);
	}
	public void exibirHistorico() {
		System.out.println("========= HISTÓRICO DA BATALHA =========");
		for (String evento : historico) {
			System.out.println(evento);
		}
	}
}

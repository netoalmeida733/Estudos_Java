package batalha;

public class Guerreiro extends Base{
	//ATRIBUTOS
	private String arma;
	
	
	//METODO CONSTRUTOR HERDADOD DA CLASSE BASE
	public Guerreiro(String nome, int vida, int dano) {
		super(nome, vida, dano);
		this.arma = "Espada";
	}
	//METODO PRINCIPAL
	@Override
	public void atacar() {
		System.out.printf("O %s atacou com sua %s , causando %d de dano\n" , getNome() , arma , getDanoBase()+5);
	}
	
	
	//GETTERS AND SETTERS 
	public String getArma() {
		return arma;
	}
	public void setArma(String arma) {
		this.arma = arma;
	}
	
}

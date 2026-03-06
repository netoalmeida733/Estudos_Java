package batalha;

public class Mainb {
	public static void main(String[] args)throws Exception{
		Base base = new Base("Tigre" , 80 , 20);
			base.atacar();
			base.receberDano(100);
		
			
		Guerreiro guerreiro = new Guerreiro( "Guerreiro Thor" ,80 ,20);
			guerreiro.atacar();
		
		Mage mago = new Mage("Mago", 80 , 20);
			mago.atacar();
		RegistroBatalha registro = new RegistroBatalha();
		registro.registrar(base.getNome() + " entrou com 80 de vida.");
		registro.registrar(base.getNome() + " atacou causando " +base.getDanoBase() +" de dano");
		registro.registrar(base.getNome() + " recebeu 100 de dano " );
		registro.registrar("Tigre foi eliminado");
		registro.registrar("FIM DA BATALHA!");
		registro.exibirHistorico();
	}
	
}

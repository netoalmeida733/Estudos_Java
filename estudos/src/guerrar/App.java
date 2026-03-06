package guerrar;

public class App { 	
	public static void main(String[] args) throws Exception {
		Guerreiro guerreiro = new Guerreiro ("Guerreiro", 25 , 100);
		guerreiro.atacar();
		Personagem p1 = new Guerreiro ("Arthur" , 18, 100);
		p1.atacar();
		Personagem p2 = new Mago ("Merlin" ,  20 , 80  );
		p2.atacar();

		Mago mago = new Mago ("Mago" , 20, 80);
		mago.atacar();
		Mago fire = new Mago ("Mago de fogo", 20 , 30);
		fire.atacar("Bola de fogo");
	
	}
	
	
} 


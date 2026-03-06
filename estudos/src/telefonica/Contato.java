package telefonica;


public class Contato {
	//ATRIBUTOS
		private String nome; 
		private String numero;
		//METODO CONSTRUTOR
		public Contato(String nome, String numero) {
			
			this.nome = nome;
			this.numero = numero;
		}
		
		//METODO TOstring
		@Override
		public String toString() {
			String informacao = String.format("NOME: %s\tNUMERO: %s", nome , numero);
			return informacao;
		}
		
		
		//GETTERS AND SETTERS 
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		
	}

 

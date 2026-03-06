package estacionamento;

public class Principal {
	public static void main(String[] args)throws Exception{
		System.out.println("========= SISTEMA DE ESTACIONAMENTO =========");
		// ARMAZENAMENTO DE DADOS DE VEICULOS
		Veiculo veiculo = new Veiculo("ABC-123", "CARRO", 12, "VEICULO AUTORIZADO");
		Veiculo veiculo2= new Veiculo("XYZ-999", "MOTO", 15, "VEICULO AUTORIZADO");
	
		veiculo.exibirDados();
		System.out.println("----------------------");
		veiculo2.exibirDados();
		System.out.println("==================");
		
		//ESTACIONAMENTO ENTRADA E SAIDA
		Estacionamento estacionamento = new Estacionamento();
		//ENTRADA 
		estacionamento.entrar(veiculo);
		estacionamento.entrar(veiculo2);
		
		System.out.println("==================");
		
		//SAIDA
		estacionamento.sair("ABC-123");
		estacionamento.sair("XYZ-999");
		
		
	}
}

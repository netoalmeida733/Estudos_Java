package estacionamento;

public class Veiculo {
	//ATRIBUTOS
	private String placa;
	private String tipo;
	private int horaEntrada;
	private String status;

	//METODO CONSTRUTOR
	public Veiculo(String placa, String tipo, int horaEntrada , String status) {
			super();
			this.placa = placa;
			this.tipo = tipo;
			this.horaEntrada = horaEntrada;
			this.status = status;
		}
	//METODO PRINCIPAL
	public void exibirDados() {	
		System.out.println("Veiculo Entrando...");
		System.out.printf("Placa: %s\nTipo do veiculo: %s\nHora de Entrada: %dh\nStatus: %s\n" , placa , tipo , horaEntrada , status);
	}
	
	
	//GETTERS AND SETTERS
		public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(int horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
}

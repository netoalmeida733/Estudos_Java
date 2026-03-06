package estacionamento;

import java.util.ArrayList;

public class Estacionamento {

	// ATRIBUTOS
	private int vagasTotais;
	private int vagasOcupadas;
	private int vagasDisponiveis;
	private ArrayList<Veiculo> veiculos;

	// METODO CONSTRUTOR
	public Estacionamento() {
		this.vagasTotais = 10;
		this.vagasOcupadas = 0;
		this.vagasDisponiveis = vagasTotais;
		this.veiculos = new ArrayList<>();
	}

	// VEICULO ENTRA
	public void entrar(Veiculo veiculo) {
		if (vagasOcupadas >= vagasTotais) {
			System.out.println("NAO HA VAGAS DISPONIVEIS");
			return;
		}

		veiculos.add(veiculo);
		vagasOcupadas++;
		vagasDisponiveis--;

		System.out.println("Veiculo entrou: " + veiculo.getPlaca());
		exibirVagas();
	}

	// VEICULO SAI
	public void sair(String placa) {
		for (Veiculo v : veiculos) {
			if (v.getPlaca().equals(placa)) {
				veiculos.remove(v);
				vagasOcupadas--;
				vagasDisponiveis++;
				System.out.println("Veiculo saiu: " + placa);
				exibirVagas();
				return;
			}
		}
		System.out.println("Veiculo nao encontrado");
	}

	// MOSTRA VAGAS
	public void exibirVagas() {
		System.out.printf(
			"Vagas totais: %d | Ocupadas: %d | Disponiveis: %d%n",
			vagasTotais, vagasOcupadas, vagasDisponiveis
		);
	}
}


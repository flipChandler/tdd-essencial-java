package br.com.flyapp.model;

public class PrecoPassagemGold implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		if (voo.getPreco() > 500.0) {
			return calcularValorAcimaDoLimite(voo);
		}
		return calcularValoAbaixoDoLimite(voo);
	}
	
	private double calcularValorAcimaDoLimite(Voo voo) {
		return voo.getPreco() * 0.85;
	}	

	private double calcularValoAbaixoDoLimite(Voo voo) {
		return voo.getPreco() * 0.9;
	}


}

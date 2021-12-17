package br.com.pedidoapp.desconto;

public class DescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {

	public DescontoPrimeiraFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calculaFaixa(double valorTotal) {
		if (valorTotal > 300.0 && valorTotal < 801.0) {
			return valorTotal * 0.04;
		}
		return -1;
	}

}

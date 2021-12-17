package br.com.pedidoapp.desconto;

public class DescontoSegundaFaixa extends CalculadoraFaixaDesconto {

	public DescontoSegundaFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calculaFaixa(double valorTotal) {
		if (valorTotal > 800.0 && valorTotal < 1001.0) {
			return valorTotal * 0.06;
		}
		return -1;
	}

}

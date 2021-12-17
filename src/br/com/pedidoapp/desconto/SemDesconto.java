package br.com.pedidoapp.desconto;

public class SemDesconto extends CalculadoraFaixaDesconto {

	public SemDesconto(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calculaFaixa(double valorTotal) {
		return 0;
	}

}

package br.com.pedidoapp.desconto;

public class DescontoTerceiraFaixa extends CalculadoraFaixaDesconto {

	public DescontoTerceiraFaixa(CalculadoraFaixaDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calculaFaixa(double valorTotal) {
		if (valorTotal > 1000.0) {
			return valorTotal * 0.08;
		}
		return -1; // essa classe não é responsavel por esse calculo
	}

}

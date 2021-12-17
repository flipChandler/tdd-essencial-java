package br.com.pedidoapp.desconto;

public abstract class CalculadoraFaixaDesconto {
	
	private CalculadoraFaixaDesconto proximo;
	
	public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto proximo) {
		this.proximo = proximo;
	}
	
	protected abstract double calculaFaixa(double valorTotal);
	
	// CHAIN OF RESPONSIBILITY
	// DA FAIXA 3 --> 2 --> 1 --> SEM DESCONTO
	public double calculaDesconto(double valorTotal) {
		double desconto = calculaFaixa(valorTotal);
		
		if (desconto == -1) {
			return proximo.calculaDesconto(valorTotal);
		}
		return desconto;
	}

}

 package br.com.pedidoapp;

import br.com.pedidoapp.desconto.CalculadoraFaixaDesconto;
import br.com.pedidoapp.desconto.DescontoPrimeiraFaixa;
import br.com.pedidoapp.desconto.DescontoSegundaFaixa;
import br.com.pedidoapp.desconto.DescontoTerceiraFaixa;
import br.com.pedidoapp.desconto.SemDesconto;

public class PedidoBuilder {
	
	private Pedido pedido;
	
	public PedidoBuilder() {
		// DESIGN PATTERN: CHAIN OF RESPONSIBILITY 
				CalculadoraFaixaDesconto calculadoraFaixaDesconto = 
						new DescontoTerceiraFaixa(
							new DescontoSegundaFaixa(
								new DescontoPrimeiraFaixa(
									new SemDesconto(null))));
				
				pedido = new Pedido(calculadoraFaixaDesconto);
	}
	
	public PedidoBuilder adicionarItem(double valorUnitario, int quantidade) {
		pedido.adicionarItem(new ItemPedido("Novo Item", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido build() {
		return this.pedido;
	}
	
	public PedidoBuilder novoMetodo() {
		// pedido ...
		return this;
	}
	
	
}

package br.com.pedidoapp;

public class Pedido {
	
	private double valorTotal;
	private double desconto;

	public void adicionarItem(ItemPedido itemPedido) {
		this.valorTotal = itemPedido.getValorUnitario() * itemPedido.getQuantidade();
	}

	public double valorTotal() {
		return this.valorTotal;
	}

	public double desconto() {
		return this.desconto;
	}	
}

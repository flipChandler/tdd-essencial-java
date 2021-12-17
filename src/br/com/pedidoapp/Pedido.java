package br.com.pedidoapp;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private double desconto = 0;
	
	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionarItem(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public double valorTotal() {
		return itens.stream()
				.mapToDouble(i -> i.getValorUnitario() * i.getQuantidade())
				.sum();				
	}

	public double desconto() {
		return this.desconto;
	}	
}

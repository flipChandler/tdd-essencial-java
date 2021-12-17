package br.com.pedidoapp;

import org.junit.jupiter.api.Test;

public class PedidoTest {
	
	@Test
	void criarPedido() throws Exception {
		Pedido pedido = new Pedido();
	}
	
	@Test
	void permitirAdicionarUmItemNoPedido() throws Exception {
		Pedido pedido = new Pedido();
		pedido.adicionarItem("Sabonete", 3.0, 10);
	}
}

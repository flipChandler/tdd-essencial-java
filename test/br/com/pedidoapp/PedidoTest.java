package br.com.pedidoapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	
	private static Pedido pedido;
	
	@BeforeAll
	public static void setup() {
		 pedido = new Pedido();
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		assertEquals(valorTotal, pedido.valorTotal(), 0.0001);
		assertEquals(desconto, pedido.desconto(), 0.0001);
	}
	
	@Test
	void permitirAdicionarUmItemNoPedido() throws Exception {
		pedido.adicionarItem("Sabonete", 3.0, 10);
	}
	 	
	@Test
	void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0); // tem o valorTotal e o desconto
	}
	
	@Test
	void calcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.adicionarItem("Sabonete", 5.0, 5);
		assertResumoPedido(25.0, 0.0);
	}

	
	
}

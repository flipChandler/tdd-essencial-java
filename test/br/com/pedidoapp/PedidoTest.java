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
	
	@Test
	void permitirAdicionarUmItemNoPedido() throws Exception {
		pedido.adicionarItem("Sabonete", 3.0, 10);
	}
	
	@Test
	void calcularValorTotalParaPedidoVazio() throws Exception {
		assertEquals(0.0, pedido.valorTotal(), 0.0001);       // delta que garante a margem de erro de 0.0001 
	}
	
	@Test
	void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertEquals(0.0, pedido.valorTotal(), 0.0001);
		assertEquals(0.0, pedido.desconto(), 0.0001);
	}
}

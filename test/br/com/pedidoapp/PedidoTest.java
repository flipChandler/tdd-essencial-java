package br.com.pedidoapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	
	private Pedido pedido;
	
	@BeforeEach
	public void setup() {
		 pedido = new Pedido();
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		assertEquals(valorTotal, pedido.valorTotal(), 0.0001);
		assertEquals(desconto, pedido.desconto(), 0.0001);
	}
	
	@Test
	void permitirAdicionarUmItemNoPedido() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 10));
	}
	 	
	@Test
	void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0); // tem o valorTotal e o desconto
	}
	
	@Test
	void calcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	void calcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.adicionarItem(new ItemPedido("Sabonete", 3.0, 5));
		pedido.adicionarItem(new ItemPedido("Creme Dental", 7.0, 3));
		
		assertResumoPedido(36.0, 0.0);
	}	
	
}

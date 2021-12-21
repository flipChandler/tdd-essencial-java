package br.com.pedidoapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.pedidoapp.desconto.CalculadoraFaixaDesconto;
import br.com.pedidoapp.desconto.DescontoPrimeiraFaixa;
import br.com.pedidoapp.desconto.DescontoSegundaFaixa;
import br.com.pedidoapp.desconto.DescontoTerceiraFaixa;
import br.com.pedidoapp.desconto.SemDesconto;

public class PedidoTest {
	
	private PedidoBuilder pedidoBuilder;
	
	
	@BeforeEach
	public void setup() {
		pedidoBuilder = new PedidoBuilder();
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedidoBuilder.build()
												 .resumo();
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}
	
	@Test
	void permitirAdicionarUmItemNoPedido() throws Exception {
		// pedidoBuilder.build().adicionarItem(new ItemPedido("Sabonete", 3.0, 10)); adicionarItem de Pedido
		pedidoBuilder.adicionarItem(3.0, 10);  // adicionarItem de PedidoBuilder
	}
	 	
	@Test
	void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0); // tem o valorTotal e o desconto
	}
	
	@Test
	void calcularResumoParaUmItemSemDesconto() throws Exception {
		pedidoBuilder.build()
					 .adicionarItem(new ItemPedido("Sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	void calcularResumoParaDoisItensSemDesconto() throws Exception {
		/*
		 * pedidoBuilder.build().adicionarItem(new ItemPedido("Sabonete", 3.0, 5));
		 * pedidoBuilder.build().adicionarItem(new ItemPedido("Creme Dental", 7.0, 3));
		 */
		pedidoBuilder.adicionarItem(3.0, 5)
					 .adicionarItem(7.0, 3);
		
		assertResumoPedido(36.0, 0.0);
	}	
	
	@Test
	void aplicarDescontoNaPrimeiraFaixa() throws Exception {
		pedidoBuilder.build()
					 .adicionarItem(new ItemPedido("Shampoo", 20.0, 20));
		
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	void aplicarDescontoNaSegundaFaixa() throws Exception {
		pedidoBuilder.adicionarItem(15.0, 30)
					 .adicionarItem(15.0, 30)
					 .novoMetodo();
		
		assertResumoPedido(900.0, 54.0);
	}
	
	@Test
	void aplicarDescontoNaTerceiraFaixa() throws Exception {
		/*
		 * pedidoBuilder.build().adicionarItem(new ItemPedido("Shampoo", 15.0, 30));
		 * pedidoBuilder.build().adicionarItem(new ItemPedido("Creme de Cabelo", 15.0,
		 * 30)); pedidoBuilder.build().adicionarItem(new ItemPedido("Gel", 10.0, 30));
		 */
		pedidoBuilder.adicionarItem(15.0, 30)
					 .adicionarItem(15.0, 30)
					 .adicionarItem(10.0, 30)
					 .novoMetodo();
		
		assertResumoPedido(1200.0, 96.0);
	}
}

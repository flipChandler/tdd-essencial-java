package br.com.pedidomockapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.pedidomockapp.builder.PedidoBuilder;
import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.service.PedidoService;

public class PedidoServiceTest {
	
	private Pedido pedido;
	private PedidoService pedidoService;
	
	@BeforeEach
	private void setup() {
		pedido = new PedidoBuilder()
				.comValor(100.0)
				.para("João", "joao@gmail.com", "99999-0000")
				.build();

		pedidoService = new PedidoService();
	}
	
	@Test
	void calcularImposto() throws Exception {
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto, 0.0001);
	}
	
	@Test
	void salvarPedidoNoBancoDeDados() throws Exception {
		pedidoService.lancar(pedido);	
	}

}

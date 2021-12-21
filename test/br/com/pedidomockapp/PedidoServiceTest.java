package br.com.pedidomockapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.pedidomockapp.builder.PedidoBuilder;
import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.service.PedidoService;

public class PedidoServiceTest {
	
	@Test
	void calcularImposto() throws Exception {
		Pedido pedido = new PedidoBuilder()
							.comValor(100.0)
							.para("João", "joao@gmail.com", "99999-0000")
							.build();
		
		PedidoService pedidoService = new PedidoService();
		double imposto = pedidoService.lancar(pedido);
		assertEquals(10.0, imposto, 0.0001);
	}

}

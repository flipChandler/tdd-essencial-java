package br.com.pedidomockapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import br.com.pedidomockapp.builder.PedidoBuilder;
import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.repository.PedidoRepository;
import br.com.pedidomockapp.service.PedidoService;

public class PedidoServiceTest {
	
	private PedidoService pedidoService;
	
	@BeforeEach
	private void setup() {
		PedidoRepository pedidoRepository = Mockito.mock(PedidoRepository.class);

		pedidoService = new PedidoService(pedidoRepository);
	}
	
	@Test
	void calcularImposto() throws Exception {
		Pedido pedido = new PedidoBuilder()
							.comValor(100.0)
							.para("João", "joao@gmail.com", "99999-0000")
							.build();
		
		double imposto = pedidoService.lancar(pedido);		
		assertEquals(10.0, imposto, 0.0001);
	}
	
	@Test
	void salvarPedidoNoBancoDeDados() throws Exception {
		Pedido pedido = new PedidoBuilder()
				.comValor(100.0)
				.para("João", "joao@gmail.com", "99999-0000")
				.build();
		pedidoService.lancar(pedido);	
	}

}

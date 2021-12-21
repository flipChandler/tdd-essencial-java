package br.com.pedidomockapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.pedidomockapp.builder.PedidoBuilder;
import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.notificacao.NotificadorEmail;
import br.com.pedidomockapp.notificacao.NotificadorSms;
import br.com.pedidomockapp.repository.PedidoRepository;
import br.com.pedidomockapp.service.PedidoService;

public class PedidoServiceTest {
	
	private PedidoService pedidoService;
	
	@Mock
	private PedidoRepository pedidoRepository; 
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	private void setup() {
		MockitoAnnotations.initMocks(this);
		NotificadorEmail email = new NotificadorEmail();
		NotificadorSms sms = new NotificadorSms();

		pedidoService = new PedidoService(pedidoRepository, email, sms);
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
		Mockito.verify(pedidoRepository).guardar(pedido);  // testa se o metodo guardar foi chamado
	}

}

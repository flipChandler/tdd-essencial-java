package br.com.pedidomockapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.pedidomockapp.builder.PedidoBuilder;
import br.com.pedidomockapp.model.AcaoLancamentoPedido;
import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.notificacao.NotificadorEmail;
import br.com.pedidomockapp.notificacao.NotificadorSms;
import br.com.pedidomockapp.repository.PedidoRepository;
import br.com.pedidomockapp.service.PedidoService;

public class PedidoServiceTest {
	
	private PedidoService pedidoService;
	private Pedido pedido;
	
	@Mock
	private PedidoRepository pedidoRepository; 
	
	@Mock
	private NotificadorEmail email;
	
	@Mock
	private NotificadorSms sms;	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	private void setup() {
		MockitoAnnotations.initMocks(this);
		List<AcaoLancamentoPedido> acoes = Arrays.asList(pedidoRepository, email, sms);
		pedidoService = new PedidoService(acoes);
		pedido = new PedidoBuilder()
				.comValor(100.0)
				.para("João", "joao@gmail.com", "99999-0000")
				.build();
	}
	
	@Test
	void calcularImposto() throws Exception {		
		double imposto = pedidoService.lancar(pedido);		
		assertEquals(10.0, imposto, 0.0001);
	}
	
	@Test
	void salvarPedidoNoBancoDeDados() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(pedidoRepository).executar(pedido);  // testa se o metodo guardar foi chamado
	}
	
	@Test
	void notificarPorEmail() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(email).executar(pedido);
	}
	
	@Test
	void notificarPorSms() throws Exception {
		pedidoService.lancar(pedido);
		Mockito.verify(sms).executar(pedido);
	}
}

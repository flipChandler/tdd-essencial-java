package br.com.pedidomockapp.service;

import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.notificacao.NotificadorEmail;
import br.com.pedidomockapp.notificacao.NotificadorSms;
import br.com.pedidomockapp.repository.PedidoRepository;

public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	private NotificadorEmail notificadorEmail;
	private NotificadorSms notificadorSms;
	
	
	public PedidoService(PedidoRepository pedidoRepository, 
						 NotificadorEmail notificadorEmail,
						 NotificadorSms notificadorSms) {
		this.pedidoRepository = pedidoRepository;
		this.notificadorEmail = notificadorEmail;
		this.notificadorSms = notificadorSms;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		this.pedidoRepository.guardar(pedido);
		this.notificadorEmail.enviar(pedido);
		this.notificadorSms.enviar(pedido);
		return imposto;
	}

}

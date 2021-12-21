package br.com.pedidomockapp.service;

import java.util.List;

import br.com.pedidomockapp.model.AcaoLancamentoPedido;
import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.repository.PedidoRepository;

public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	private List<AcaoLancamentoPedido> acoes;
	
	
	public PedidoService(PedidoRepository pedidoRepository, 
						List<AcaoLancamentoPedido> acoes) {
		this.pedidoRepository = pedidoRepository;
		this.acoes = acoes;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		
		this.pedidoRepository.guardar(pedido);
		
		this.acoes.forEach(a -> a.executar(pedido));
		
		return imposto;
	}

}

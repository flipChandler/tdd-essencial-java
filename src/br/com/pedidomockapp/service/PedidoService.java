package br.com.pedidomockapp.service;

import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.repository.PedidoRepository;

public class PedidoService {
	
	private PedidoRepository pedidoRepository;
	
	
	
	public PedidoService(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}



	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		this.pedidoRepository.guardar(pedido);
		return imposto;
	}

}

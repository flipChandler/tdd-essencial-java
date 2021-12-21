package br.com.pedidomockapp.service;

import br.com.pedidomockapp.model.Pedido;
import br.com.pedidomockapp.repository.PedidoRepository;

public class PedidoService {

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		new PedidoRepository().guardar(pedido);
		return imposto;
	}

}

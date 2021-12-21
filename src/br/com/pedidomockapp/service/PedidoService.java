package br.com.pedidomockapp.service;

import br.com.pedidomockapp.model.Pedido;

public class PedidoService {

	public double lancar(Pedido pedido) {
		return pedido.getValor() * 0.1;
	}

}

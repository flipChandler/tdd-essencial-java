package br.com.pedidomockapp.repository;

import br.com.pedidomockapp.model.AcaoLancamentoPedido;
import br.com.pedidomockapp.model.Pedido;

public class PedidoRepository implements AcaoLancamentoPedido {
	
	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");
	}

}

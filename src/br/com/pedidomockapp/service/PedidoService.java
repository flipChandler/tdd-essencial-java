package br.com.pedidomockapp.service;

import java.util.List;

import br.com.pedidomockapp.model.AcaoLancamentoPedido;
import br.com.pedidomockapp.model.Pedido;

public class PedidoService {
	
	private List<AcaoLancamentoPedido> acoes;
	
	
	public PedidoService(List<AcaoLancamentoPedido> acoes) {
		this.acoes = acoes;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
				
		this.acoes.forEach(a -> a.executar(pedido));
		
		return imposto;
	}

}

package br.com.pedidomockapp.notificacao;

import br.com.pedidomockapp.model.AcaoLancamentoPedido;
import br.com.pedidomockapp.model.Pedido;

public class NotificadorEmail implements AcaoLancamentoPedido {	

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando o email...");
	}	
}

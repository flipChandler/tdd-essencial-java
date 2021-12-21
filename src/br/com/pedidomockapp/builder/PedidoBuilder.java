package br.com.pedidomockapp.builder;

import br.com.pedidomockapp.model.Cliente;
import br.com.pedidomockapp.model.Pedido;

public class PedidoBuilder {
	
	private Pedido pedido;
	
	public PedidoBuilder() {
		this.pedido = new Pedido();
	}
	
	public Pedido build() {
		return this.pedido;
	}
	
	public PedidoBuilder comValor(double valor) {
		this.pedido.setValor(valor);
		return this;
	}
	
	public PedidoBuilder para(String nome, String email, String telefone) {
		Cliente cliente = new Cliente(nome, email, telefone);
		this.pedido.setCliente(cliente);
		return this;
	}
	
}

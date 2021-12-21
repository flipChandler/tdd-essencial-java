package br.com.flyapp.service;

import br.com.flyapp.model.Passageiro;
import br.com.flyapp.model.TipoPassageiro;
import br.com.flyapp.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		if (passageiro.getTipo().equals(TipoPassageiro.GOLD)) {
			return voo.getPreco() * 0.9;
		}
		
		return 0.0;
	}

}

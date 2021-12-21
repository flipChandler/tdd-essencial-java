package br.com.flyapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.flyapp.model.Passageiro;
import br.com.flyapp.model.TipoPassageiro;
import br.com.flyapp.model.Voo;
import br.com.flyapp.service.PrecoPassagemService;

public class PrecoPassagemServiceTest {
	
	private PrecoPassagemService precoPassagemService; 
	
	@BeforeEach
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}
	
	@Test
	void criarPrecoPassagemService() throws Exception {
		// PrecoPassagemService precoPassagemService = new PrecoPassagemService();
	}
	
	@Test
	void calcularPrecoParaPassageiroGoldComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		double valor = precoPassagemService.calcular(passageiro, voo);
	}
}

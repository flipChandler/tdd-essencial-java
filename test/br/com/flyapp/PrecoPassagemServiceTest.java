package br.com.flyapp;

import static org.junit.jupiter.api.Assertions.*;

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
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
	
	@Test
	void permitirChamarCalculoDoValor() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		double valor = precoPassagemService.calcular(passageiro, voo);
	}
	
	@Test
	void calcularPrecoParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 90.0);
	}
	
	@Test
	void calcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	void calcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	void calcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		
		assertValorPassagem(passageiro, voo, 720.0);
	}
	
	
}

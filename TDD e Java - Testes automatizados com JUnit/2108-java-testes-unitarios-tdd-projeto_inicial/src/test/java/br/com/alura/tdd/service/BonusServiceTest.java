package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	@Test
	void bonusDeveriaSerZeroParaSalarioAlto() {		
		BonusService bonusService = new BonusService();
		
		assertThrows(IllegalArgumentException.class, 
				() -> bonusService.calcularBonus(
						new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("25000"))));
		
		/**
		 *** Alterantiva para testes que lançam excessões ***
		try {
			bonusService.calcularBonus(new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("25000")));
			fail("Deveria lançar uma Exception");
		} catch (IllegalArgumentException e) {
			assertEquals("Funcionário com salário maior que R$ 10.000 não pode receber bonus!", e.getMessage());
		} 
		**/
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("5000")));
		assertEquals(new BigDecimal("500.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExtamanetoDezMil() {
		BonusService bonusService = new BonusService();
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}

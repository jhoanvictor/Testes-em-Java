package tdd;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

class BonusServiceTest {
	
	BonusService bonusService = new BonusService();
	
	@Test
	void bonusDeveriaSerZeroParaSalarioAlto() {		
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("25000")));
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("5000")));
		assertEquals(new BigDecimal("500.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExtamanetoDezMil() {
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("Jhoan", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}

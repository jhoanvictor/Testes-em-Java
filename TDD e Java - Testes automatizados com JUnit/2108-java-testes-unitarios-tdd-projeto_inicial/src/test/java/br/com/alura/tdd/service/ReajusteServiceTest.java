package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService reajusteService;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		reajusteService = new ReajusteService();
		funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
	}
	
	/**	Testes criados utilizando a metodologia do TDD **/
	
	@Test
	void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
		
		reajusteService.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
		
	}
	
	@Test
	void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForADesejar() {
		
		reajusteService.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
		
	}
	
	@Test
	void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForADesejar() {
		
		reajusteService.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}

}

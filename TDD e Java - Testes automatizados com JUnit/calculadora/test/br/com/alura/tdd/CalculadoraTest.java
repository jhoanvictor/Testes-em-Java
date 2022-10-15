package br.com.alura.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {
	
	Calculadora calculadora = new Calculadora();

	/*********************** TESTES DE SOMA * **********************/
	
	@Test
	void deveSomarDoisNumerosInteiros() {
		int soma = calculadora.somar(3, 5);
		assertEquals(8, soma);
	}
	
	@Test
	void deveSomarDoisNumerosInteirosNegativos() {
		int soma = calculadora.somar(-3, -2);
		assertEquals(-5, soma);
	}
	
	@Test
	void deveSomarNumeroInteiroComZero() {
		int soma = calculadora.somar(6, 0);
		assertEquals(6, soma);
	}
	
	@Test
	void deveSomarNumeroInteiroComNegativo() {
		int soma = calculadora.somar(6, -2);
		assertEquals(4, soma);
	}

	@Test
	void deveSomarNumeroInteiroComNegativoComResultadoNegativo() {
		int soma = calculadora.somar(6, -8);
		assertEquals(-2, soma);
	}
	
	/*********************** TESTES DE SUBTRAÇÃO * **********************/
	
	@Test
	void deveSubtrairDoisNumerosInteiros() {
		int resultado = calculadora.subtrair(7, 3);
		assertEquals(4, resultado);
	}
	
	@Test
	void deveSubtrairDoisNumerosNegativos() {
		int resultado = calculadora.subtrair(-2, -2);
		assertEquals(0, resultado);
	}
	
	@Test
	void deveSubtrairNumeroInteiroComZero() {
		int resultado = calculadora.subtrair(7, 0);
		assertEquals(7, resultado);
	}
	
	@Test
	void deveSubtrairNumeroInteiroComNumeroNegativo() {
		int resultado = calculadora.subtrair(10, -3);
		assertEquals(13, resultado);
	}
	
	@Test
	void deveSubtrairNumeroNegativoComNumeroPositivo() {
		int resultado = calculadora.subtrair(-10, 3);
		assertEquals(-13, resultado);
	}
	
}

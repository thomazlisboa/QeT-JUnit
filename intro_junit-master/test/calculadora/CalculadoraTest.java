package calculadora;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@BeforeEach
	public void inicializa() {
		calc = new Calculadora();
	}
	
	@DisplayName("Testar a soma de dois números")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);
		
		assertEquals(9, soma);
	}
	
	@DisplayName("Testar a subtração de dois números")
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(9, 3);
		
		assertEquals(6, subtracao);
	}
	
	@DisplayName("Testar a multiplicação de dois números")
	@Test
	public void testMultiplicarDoisNumeros() {
		int multiplicacao = calc.multiplicacao(2, 5);
		
		assertEquals(10, multiplicacao);
	}
	
	@DisplayName("Testar a divisão de dois números")
	@Test
	public void testDividirDoisNumeros() {
		int divisao = calc.divisao(10, 2);
		
		assertEquals(5, divisao);
		
	}

	@DisplayName("TRATAMENTO DE EXCEÇÃO | Testar a divisão por ZERO")
	@Test
	public void testDividirPorZero() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	
	@DisplayName("Testar o somatório de 0 até n")
	@Test
	public void testSomatorio() {
		int somatorio = calc.somatoria(3);
		
		assertEquals(6, somatorio);
	}
	
	@DisplayName("Testar se o numero é positivo")
	@Test
	public void testEhPositivo() {
		boolean positivo = calc.ehPositivo(10);		
		//Assertions.assertEquals(true, positivo);
		assertTrue(positivo);
	}
	
	@DisplayName("Comparação de dois números IGUAIS")
	@Test
	public void testComparaDoisNumeros() {
		int compara = calc.compara(2, 2);
		
		assertTrue(compara == 0);
		
	}
	
	@DisplayName("Comparação de dois números | Maior")
	@Test
	public void testComparaMaior() {
		int compara = calc.compara(3, 2);
		
		assertTrue(compara == 1);
		
	}
	
	@DisplayName("Comparação de dois números | Menor")
	@Test
	public void testComparaMenor() {
		int compara = calc.compara(2, 3);
		
		assertTrue(compara == -1);
		
	}

}

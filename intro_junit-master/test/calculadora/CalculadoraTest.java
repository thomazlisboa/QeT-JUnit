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
	
	@DisplayName("Testar a soma de dois n�meros")
	@Test
	public void testSomaDoisNumeros() {
		int soma = calc.soma(4, 5);
		
		assertEquals(9, soma);
	}
	
	@DisplayName("Testar a subtra��o de dois n�meros")
	@Test
	public void testSubtraiDoisNumeros() {
		int subtracao = calc.subtracao(9, 3);
		
		assertEquals(6, subtracao);
	}
	
	@DisplayName("Testar a multiplica��o de dois n�meros")
	@Test
	public void testMultiplicarDoisNumeros() {
		int multiplicacao = calc.multiplicacao(2, 5);
		
		assertEquals(10, multiplicacao);
	}
	
	@DisplayName("Testar a divis�o de dois n�meros")
	@Test
	public void testDividirDoisNumeros() {
		int divisao = calc.divisao(10, 2);
		
		assertEquals(5, divisao);
		
	}

	@DisplayName("TRATAMENTO DE EXCE��O | Testar a divis�o por ZERO")
	@Test
	public void testDividirPorZero() {
		assertThrows(ArithmeticException.class,
				() -> calc.divisao(8, 0));
	}
	
	
	@DisplayName("Testar o somat�rio de 0 at� n")
	@Test
	public void testSomatorio() {
		int somatorio = calc.somatoria(3);
		
		assertEquals(6, somatorio);
	}
	
	@DisplayName("Testar se o numero � positivo")
	@Test
	public void testEhPositivo() {
		boolean positivo = calc.ehPositivo(10);		
		//Assertions.assertEquals(true, positivo);
		assertTrue(positivo);
	}
	
	@DisplayName("Compara��o de dois n�meros IGUAIS")
	@Test
	public void testComparaDoisNumeros() {
		int compara = calc.compara(2, 2);
		
		assertTrue(compara == 0);
		
	}
	
	@DisplayName("Compara��o de dois n�meros | Maior")
	@Test
	public void testComparaMaior() {
		int compara = calc.compara(3, 2);
		
		assertTrue(compara == 1);
		
	}
	
	@DisplayName("Compara��o de dois n�meros | Menor")
	@Test
	public void testComparaMenor() {
		int compara = calc.compara(2, 3);
		
		assertTrue(compara == -1);
		
	}

}

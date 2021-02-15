package carrinho;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.*;

@DisplayName("Classe para teste do carrinho")
public class CarrinhoTest {

	private Carrinho carrinho;
	private Produto item1;
	private Produto item2;
	private Produto item3;
	
	@BeforeEach
	public void inicializa() {
		carrinho = new Carrinho();
		
		item1 = new Produto("item1", 250.00);
		item2 = new Produto("item2", 25.00);
		carrinho.addItem(item1);
		carrinho.addItem(item2);
	}
	
	@DisplayName("Testar o valor total")
	@Test
	public void testGetValorTotal() {
		Double valorTotal = carrinho.getValorTotal();
		assertEquals(275.00, valorTotal);
	}
	
	@DisplayName("Testar Adicionar Item Ao Carrinho")
	@Test
	public void testAddItem() {
		item3 = new Produto("item3", 50.00);
		carrinho.addItem(item3);
		assertEquals(3, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testar quantidade de Itens no Carrinho")
	@Test
	public void testQetQtdeItems() {
		assertEquals(2, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testar esvaziar o carrinho")
	@Test
	public void testEsvazia() {
		carrinho.esvazia();
		assertEquals(0, carrinho.getQtdeItems());
	}
	
	@DisplayName("Testar remover item do Carrinho")
	@Test
	public void testRemoveItem() {
		try {
			carrinho.removeItem(item1);
			assertEquals(1, carrinho.getQtdeItems());
		} catch (ProdutoNaoEncontradoException e) {
			Assertions.assertEquals("ProdutoNaoEncontradoException", e.getMessage());
		}
	}
	
	@DisplayName("TRATAMENTO DE EXCEÇÃO | Testar PRODUTO NAO ENCONTRADO")
	@Test
	public void testThrowProdutoNaoEncontradoException() {
		carrinho.esvazia();
		assertThrows(ProdutoNaoEncontradoException.class, () -> carrinho.removeItem(item1));
	}
}
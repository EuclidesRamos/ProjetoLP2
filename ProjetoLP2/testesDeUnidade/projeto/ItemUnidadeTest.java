package projeto;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Responsavel pelos testes da classe ItemUnidade.
 * 
 * @author Eduardo Pereira dos Santos - 117210342
 *
 */
public class ItemUnidadeTest {

	/**
	 * Item utilizado nos testes.
	 */
	private ItemUnidade item;

	/**
	 * Instancia um item do tipo ItemUnidade usado nos testes.
	 */
	@Before
	public void criaItemUnidade() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com nome vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeNomeVazio() {
		this.item = new ItemUnidade(1, "", "limpeza", 2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriaItemUnidadeNomeNulo() {
		this.item = new ItemUnidade(1, null, "limpeza", 2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com categoria vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeCategoriaVazia() {
		this.item = new ItemUnidade(1, "Sabao", "", 2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com categoria nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriaItemUnidadeCategoriaNula() {
		this.item = new ItemUnidade(1, "Sabao", null, 2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com categoria inexistente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeCategoriaInexistente() {
		this.item = new ItemUnidade(1, "Sabao", "Laticinio", 2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com quantidade de unidades negativa.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeComQuantidadeUnidadesNegativa() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", -2, "baratao", 2.50);
	}

	/**
	 * Testa construir um item por unidade com nome do local de compra vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeLocalCompraVazio() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, "", 2.50);
	}

	/**
	 * Testa construir um item por unidade com nome do local de compra nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriaItemUnidadeLocalCompraNulo() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, null, 2.50);
	}

	/**
	 * Testa construir um item por unidade com preco negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadePrecoNegativo() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, "baratao", -2.50);
	}

	/**
	 * Testa o metodo getId.
	 */
	@Test
	public void testGetId() {
		assertEquals(this.item.getId(), 1);
	}

	/**
	 * Testa o metodo getNome.
	 */
	@Test
	public void testGetNome() {
		assertEquals(this.item.getNome(), "Sabao");
	}

	/**
	 * Testa o metodo getUnidade.
	 */
	@Test
	public void testGetUnidade() {
		assertEquals(this.item.getUnidade(), 2);
	}

	/**
	 * Testa o metodo getCategoria.
	 */
	@Test
	public void testGetCategoria() {
		assertEquals(this.item.getCategoria(), "limpeza");
	}

	/**
	 * Testa adicionar um preco ao item com local de compra vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPrecoItemLocalDeCompraVazio() {
		this.item.adicionaPrecoItem("", 4.50);

	}

	/**
	 * Testa adicionar um preco ao item com local de compra nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testAdicionaPrecoItemLocalDeCompraNulo() {
		this.item.adicionaPrecoItem(null, 5.45);

	}

	/**
	 * Testa adicionar um preco ao item preco negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPrecoItemPrecoNegativo() {
		this.item.adicionaPrecoItem("MiniBox", -5.45);

	}

	/**
	 * Testa o metodo precos.
	 */
	@Test
	public void testPrecos() {
		assertEquals(this.item.precos(), "baratao, R$ 2,50;");
	}

	/**
	 * Testa o metodo menorPreco.
	 */
	@Test
	public void testMenorPreco() {
		this.item.adicionaPrecoItem("Assai", 4.50);
		this.item.adicionaPrecoItem("Atacadao", 0.50);
		assertTrue(this.item.menorPreco() == 0.50);
	}

	/**
	 * Testa o metodo toString.
	 */
	@Test
	public void testToString() {
		assertEquals(this.item.toString(), "1. Sabao, limpeza, Preco: <baratao, R$ 2,50;>");
	}

	/**
	 * Testa o metodo equals caso(true).
	 */
	@Test
	public void testEqualsTrue() {
		Item item2 = new ItemUnidade(1, "Sabao", "limpeza", 2, "baratao", 2.50);
		assertTrue(this.item.equals(item2));

	}

	/**
	 * Testa o metodo equals caso(false).
	 */
	@Test
	public void testEqualsFalse() {
		Item item2 = new ItemUnidade(2, "Detergente", "limpeza", 2, "baratao", 2.50);
		assertFalse(this.item.equals(item2));

	}

	/**
	 * Testa atualizar o nome do item.
	 */

	@Test
	public void testAtualizaItemNome() {
		this.item.atualizaItem("nome", "Sabao omo");
		assertEquals(this.item.getNome(), "Sabao omo");

	}

	/**
	 * Testa atualizar a categoria do item.
	 */
	@Test
	public void testAtualizaItemCategoria() {
		this.item.atualizaItem("categoria", "alimento industrializado");
		assertEquals(this.item.getCategoria(), "alimento industrializado");

	}

	/**
	 * Testa atualizar a quantidade de unidades.
	 */
	@Test
	public void testAtualizaItemUnidades() {
		this.item.atualizaItem("unidades", "2");
		assertEquals(this.item.getUnidade(), 2);

	}

}

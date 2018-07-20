package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ItemQuantidadeFixaTest {

	private ItemQuantidadeFixa item;

	@Before
	public void criaItemUnidade() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", 2, "l", "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaNomeVazio() {
		this.item = new ItemQuantidadeFixa(1, "", "limpeza", 2, "l", "baratao", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuantidadeFixaNulo() {
		this.item = new ItemQuantidadeFixa(1, null, "limpeza", 2, "l", "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaCategoriaVazia() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "", 2, "l", "baratao", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuantidadeFixaCategoriaNula() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", null, 2, "l", "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaCategoriaInexistente() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "Laticinio", 2, "l", "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaComQuantidadeNegativa() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", -2, "l", "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaUnidadeDeMedidaVazia() {
		this.item = new ItemQuantidadeFixa(1, "", "limpeza", 2, "", "baratao", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuantidadeFixaUnidadeDeMedidaNula() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", 2, null, "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaLocalCompraVazio() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", 2, "l", "", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuantidadeFixaLocalCompraNulo() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", 2, "l", null, 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuantidadeFixaPrecoNegativo() {
		this.item = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", 2, "l", "baratao", -2.50);
	}

	@Test
	public void testGetId() {
		assertEquals(this.item.getId(), 1);
	}

	@Test
	public void testGetNome() {
		assertEquals(this.item.getNome(), "Agua sanitaria");
	}

	@Test
	public void testGetQuantidade() {
		assertEquals(this.item.getQuantidade(), 2);
	}

	@Test
	public void testGetCategoria() {
		assertEquals(this.item.getCategoria(), "limpeza");
	}

	@Test
	public void testGetUnidadeDeMedida() {
		assertEquals(this.item.getUnidadeDeMedida(), "l");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPrecoItemLocalDeCompraVazio() {
		this.item.adicionaPrecoItem("", 4.50);

	}

	@Test(expected = NullPointerException.class)
	public void testAdicionaPrecoItemLocalDeCompraNulo() {
		this.item.adicionaPrecoItem(null, 5.45);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaPrecoItemPrecoNegativo() {
		this.item.adicionaPrecoItem("MiniBox", -5.45);

	}

	@Test
	public void testPrecos() {
		assertEquals(this.item.precos(), "baratao, R$ 2,50;");
	}

	@Test
	public void testMenorPreco() {
		this.item.adicionaPrecoItem("Assai", 4.50);
		this.item.adicionaPrecoItem("Atacadao", 0.50);
		assertTrue(this.item.menorPreco() == 0.50);
	}

	@Test
	public void testToString() {
		assertEquals(this.item.toString(), "1. Agua sanitaria, limpeza, 2 l, Preco: <baratao, R$ 2,50;>");
	}

	@Test
	public void testEqualsTrue() {
		Item item2 = new ItemQuantidadeFixa(1, "Agua sanitaria", "limpeza", 2, "l", "baratao", 2.50);
		assertTrue(this.item.equals(item2));

	}

	@Test
	public void testEqualsFalse() {
		Item item2 = new ItemQuantidadeFixa(2, "Detergente", "limpeza", 2, "l", "baratao", 2.50);
		assertFalse(this.item.equals(item2));

	}

	@Test
	public void testAtualizaItemNome() {
		this.item.atualizaItem("nome", "Sabao omo");
		assertEquals(this.item.getNome(), "Sabao omo");

	}

	@Test
	public void testAtualizaItemCategoria() {
		this.item.atualizaItem("categoria", "alimento industrializado");
		assertEquals(this.item.getCategoria(), "alimento industrializado");

	}

	@Test
	public void testAtualizaItemQuantidade() {
		this.item.atualizaItem("quantidade", "5");
		assertEquals(this.item.getQuantidade(), 5);

	}

	@Test
	public void testRepresentacaoLista() {
		assertEquals(this.item.representacaoLista(), "Agua sanitaria, limpeza, 2 l");
	}

}

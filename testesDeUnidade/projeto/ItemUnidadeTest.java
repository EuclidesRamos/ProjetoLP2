package projeto;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ItemUnidadeTest {

	private ItemUnidade item;

	@Before
	public void criaItemUnidade() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeNomeVazio() {
		this.item = new ItemUnidade(1, "", "limpeza", 2, "baratao", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemUnidadeNomeNulo() {
		this.item = new ItemUnidade(1, null, "limpeza", 2, "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeCategoriaVazia() {
		this.item = new ItemUnidade(1, "Sabao", "", 2, "baratao", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemUnidadeCategoriaNula() {
		this.item = new ItemUnidade(1, "Sabao", null, 2, "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeCategoriaInexistente() {
		this.item = new ItemUnidade(1, "Sabao", "Laticinio", 2, "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeComQuantidadeUnidadesNegativa() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", -2, "baratao", 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadeLocalCompraVazio() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, "", 2.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemUnidadeLocalCompraNulo() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, null, 2.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemUnidadePrecoNegativo() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 2, "baratao", -2.50);
	}

	@Test
	public void testGetId() {
		assertEquals(this.item.getId(), 1);
	}

	@Test
	public void testGetNome() {
		assertEquals(this.item.getNome(), "Sabao");
	}

	@Test
	public void testGetUnidade() {
		assertEquals(this.item.getUnidade(), 2);
	}

	@Test
	public void testGetCategoria() {
		assertEquals(this.item.getCategoria(), "limpeza");
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
		assertEquals(this.item.toString(), "1. Sabao, limpeza, Preco: <baratao, R$ 2,50;>");
	}

	@Test
	public void testEqualsTrue() {
		Item item2 = new ItemUnidade(1, "Sabao", "limpeza", 2, "baratao", 2.50);
		assertTrue(this.item.equals(item2));

	}

	@Test
	public void testEqualsFalse() {
		Item item2 = new ItemUnidade(2, "Detergente", "limpeza", 2, "baratao", 2.50);
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
	public void testAtualizaItemUnidades() {
		this.item.atualizaItem("unidades", "2");
		assertEquals(this.item.getUnidade(), 2);

	}

}

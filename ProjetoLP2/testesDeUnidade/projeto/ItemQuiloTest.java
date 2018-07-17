package projeto;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ItemQuiloTest {

	private ItemQuilo item;

	@Before
	public void criaItemUnidade() {
		this.item = new ItemQuilo(1, "Bife", "alimento industrializado", 2.5, "baratao", 22.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuiloNomeVazio() {
		this.item = new ItemQuilo(1, "", "alimento industrializado", 2.5, "baratao", 22.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuiloNomeNulo() {
		this.item = new ItemQuilo(1, null, "alimento industrializado", 2.5, "baratao", 22.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuiloCategoriaVazia() {
		this.item = new ItemQuilo(1, "Bife", "", 2.5, "baratao", 22.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuiloCategoriaNula() {
		this.item = new ItemQuilo(1, "Bife", null, 2.5, "baratao", 22.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuiloCategoriaInexistente() {
		this.item = new ItemQuilo(1, "Bife", "Laticinio", 2.5, "baratao", 22.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuiloComQuantidadeQuilosNegativa() {
		this.item = new ItemQuilo(1, "Bife", "alimento industrializado", -2.5, "baratao", 22.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuiloLocalCompraVazio() {
		this.item = new ItemQuilo(1, "Bife", "alimento industrializado", 2.5, "", 22.50);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaItemQuiloLocalCompraNulo() {
		this.item = new ItemQuilo(1, "Bife", "alimento industrializado", 2.5, null, 22.50);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaItemQuiloPrecoNegativo() {
		this.item = new ItemQuilo(1, "Bife", "alimento industrializado", 2.5, "baratao", -22.50);
	}

	@Test
	public void testGetId() {
		assertEquals(this.item.getId(), 1);
	}

	@Test
	public void testGetNome() {
		assertEquals(this.item.getNome(), "Bife");
	}

	@Test
	public void testGetCategoria() {
		assertEquals(this.item.getCategoria(), "alimento industrializado");
	}

	@Test
	public void testGetKg() {
		assertTrue(this.item.getKg() == 2.5);
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
		assertEquals(this.item.precos(), "baratao, R$ 22,50;");
	}

	@Test
	public void testMenorPreco() {
		this.item.adicionaPrecoItem("Assai", 14.50);
		this.item.adicionaPrecoItem("Atacadao", 10.50);
		assertTrue(this.item.menorPreco() == 10.50);
	}

	@Test
	public void testToString() {
		assertEquals(this.item.toString(), "1. Bife, alimento industrializado, Preco por quilo: <baratao, R$ 22,50;>");
	}

	@Test
	public void testEqualsTrue() {
		Item item2 = new ItemQuilo(1, "Bife", "alimento industrializado", 2.5, "baratao", 22.50);
		assertTrue(this.item.equals(item2));

	}

	@Test
	public void testEqualsFalse() {
		Item item2 = new ItemQuilo(2, "Carne de Sol", "alimento nao industrializado", 2.5, "baratao", 22.50);
		assertFalse(this.item.equals(item2));

	}

	@Test
	public void testAtualizaItemNome() {
		this.item.atualizaItem("nome", "Carne moida");
		assertEquals(this.item.getNome(), "Carne moida");

	}

	@Test
	public void testAtualizaItemCategoria() {
		this.item.atualizaItem("categoria", "alimento nao industrializado");
		assertEquals(this.item.getCategoria(), "alimento nao industrializado");

	}

	@Test
	public void testAtualizaItemKg() {
		this.item.atualizaItem("kg", "2.45");
		assertTrue(this.item.getKg() == 2.45);

	}

}

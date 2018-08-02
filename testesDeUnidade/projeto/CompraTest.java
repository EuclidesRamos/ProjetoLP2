package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompraTest {

	Item item1;
	Item item2;
	Item item3;
	Compra compra1;
	Compra compra2;
	Compra compra3;

	@Before
	public void inicializaTestes() {
		this.item1 = new ItemQuantidadeFixa(1, "Sabonete de aveia Dorene", "higiene pessoal", 80, "gramas", "Hiper",
				5.50);
		this.item2 = new ItemUnidade(2, "Queijo minas Dali", "alimento industrializado", 1, "Hiper", 15);
		this.item3 = new ItemQuilo(3, "Batata doce", "alimento nao industrializado", 2, "Hiper", 12);
		this.compra1 = new Compra(10, item1);
		this.compra2 = new Compra(15, item2);
		this.compra3 = new Compra(13, item3);
	}

	@Test(expected = NullPointerException.class)
	public void testCriaCompraItemNulo() {
		this.compra1 = new Compra(10, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaCompraQuantidadeNegativa() {
		this.compra1 = new Compra(-10, item2);
	}

	@Test
	public void testAtualizaCompraDiminuiQuantidade() {
		this.compra1.atualizaCompra("diminui", 5);
		assertEquals(this.compra1.getQuantidade(), 5);
	}

	@Test
	public void testAtualizaCompraAumentaQuantidade() {
		this.compra1.atualizaCompra("adiciona", 5);
		assertEquals(this.compra1.getQuantidade(), 15);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraOperacaoInvalida() {
		this.compra1.atualizaCompra("multiplica", 5);

	}

	@Test
	public void testGetItem() {
		assertTrue(this.compra1.getItem().equals(item1));

	}

	@Test
	public void testGetQuantidade() {
		assertEquals(this.compra1.getQuantidade(), 10);
	}

	@Test
	public void testToStringCompraItemQuantidadeFixa() {
		assertEquals(compra1.toString(), "10 Sabonete de aveia Dorene, higiene pessoal, 80 gramas");
	}

	@Test
	public void testToStringCompraItemUnidade() {
		assertEquals(compra2.toString(), "15 Queijo minas Dali, alimento industrializado");
	}

	@Test
	public void testToStringCompraItemQuilo() {
		assertEquals(compra3.toString(), "13 Batata doce, alimento nao industrializado");
	}

}

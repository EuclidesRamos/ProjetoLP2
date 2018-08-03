package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SupermercadoTest {

	private Supermercado supermercado;
	private Compra compra1, compra2;
	private Item item1, item2;

	@Before
	public void exemploSupermercado() {
		this.supermercado = new Supermercado("Supermercado Riot");
		this.item1 = new ItemQuilo(1, "Carne", "alimento nao industrializado", 2.0, "Supermercado Riot", 22.75);
		this.compra1 = new Compra(1, this.item1);
		this.supermercado.adicionaCompra(this.compra1, 22.75);
		this.item2 = new ItemUnidade(2, "Bolo", "alimento nao industrializado", 1, "Supermercado Riot", 4.52);
		this.compra2 = new Compra(2, this.item2);
	}
	
	@Test
	public void testAdicionaCompra() {
		this.supermercado.adicionaCompra(compra2, 9.04);
		assertEquals("- 2 Bolo, alimento nao industrializado", this.supermercado.getCompra(1));
	}

	@Test
	public void testGetValorCompras() {
		assertEquals("22.75", this.supermercado.getValorCompras() + "");
	}

	@Test
	public void testGetCompra() {
		assertEquals("- 1 Carne, alimento nao industrializado", this.supermercado.getCompra(1));
	}
	
	@Test
	public void testGetCompraVazia() {
		assertEquals("", this.supermercado.getCompra(2));
	}

	@Test
	public void testToString() {
		assertEquals("Supermercado Riot: R$ 22,75", this.supermercado.toString());
	}

}

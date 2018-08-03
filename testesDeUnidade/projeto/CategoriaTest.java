package projeto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CategoriaTest {

	private Categoria categoria;
	private Categoria categoria2;

	@Before
	public void inicializaTeste() {
		this.categoria = new Categoria("limpeza");
	}

	@Test(expected = NullPointerException.class)
	public void testCriaCategoriaNomeNulo() {
		this.categoria = new Categoria(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaCategoriaNomeVazio() {
		this.categoria = new Categoria("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCriaCategoriaNomeInexistente() {
		this.categoria = new Categoria("Alimentos Organicos");
	}

	@Test
	public void testGetCategoria() {
		assertEquals(this.categoria.getCategoria(), "limpeza");
	}

	@Test
	public void testGetPrecedencia1() {
		this.categoria = new Categoria("higiene pessoal");
		assertEquals(this.categoria.getPrecedencia(), 1);
	}

	@Test
	public void testGetPrecedencia2() {
		assertEquals(this.categoria.getPrecedencia(), 2);
	}

	@Test
	public void testGetPrecedencia3() {
		this.categoria = new Categoria("alimento industrializado");
		assertEquals(this.categoria.getPrecedencia(), 3);
	}

	@Test
	public void testGetPrecedencia4() {
		this.categoria = new Categoria("alimento nao industrializado");
		assertEquals(this.categoria.getPrecedencia(), 4);
	}

	@Test
	public void testEqualsTrue() {
		this.categoria2 = new Categoria("limpeza");
		assertTrue(this.categoria.equals(categoria2));
	}

	@Test
	public void testEqualsFalse() {
		this.categoria2 = new Categoria("higiene pessoal");
		assertFalse(this.categoria.equals(categoria2));
	}
}

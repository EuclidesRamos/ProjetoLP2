package projeto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ItemControllerTest {

	private ItemController controller;
	
	@Before
	public void exemploItemController() {
		this.controller = new ItemController();
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Supermercado Bem Barato", 34.49);
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
	}
	
	@Test
	public void testAdicionaItemPorQtd() {
		assertEquals(4, this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdNomeVazio() {
		this.controller.adicionaItemPorQtd(" ", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQtdNomeNulo() {
		this.controller.adicionaItemPorQtd(null, "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdCategoriaVazia() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "", 1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdCategoriaInvalida() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "categoria", 1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQtdCategoriaNula() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", null, 1, "l", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdQuantidadeNegativa() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", -1, "l", "Supermercado Excepcional", 2.19);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdUnidDeMedidaVazia() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "", "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQtdUnidDeMedidaNula() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, null, "Supermercado Excepcional", 2.19);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdLocalDeCompraVazio() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", " ", 2.19);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQtdLocalDeCompraNulo() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", null, 2.19);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQtdPrecoNegativo() {
		this.controller.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", -1);
	}
	
	@Test
	public void testAdicionaItemPorQuilo() {
		assertEquals(4, this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Supermercado Bem Barato", 34.49));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloNomeVazio() {
		this.controller.adicionaItemPorQuilo("", "alimento industrializado", 1.0, "Supermercado Bem Barato", 34.49);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQuiloNomeNulo() {
		this.controller.adicionaItemPorQuilo(null, "alimento industrializado", 1.0, "Supermercado Bem Barato", 34.49);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloCategoriaVazia() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "", 1.0, "Supermercado Bem Barato", 34.49);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloCategoriaInvalida() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "categoria", 1.0, "Supermercado Bem Barato", 34.49);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQuiloCategoriaNula() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", null, 1.0, "Supermercado Bem Barato", 34.49);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloInvalido() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", -1.0, "Supermercado Bem Barato", 34.49);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloLocalDeCompraVazio() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "", 34.49);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorQuiloLocalDeCompraNulo() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, null, 34.49);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorQuiloPrecoNegativo() {
		this.controller.adicionaItemPorQuilo("Peito de peru Saara", "alimento industrializado", 1.0, "Supermercado Bem Barato", -34.49);
	}
	
	@Test
	public void testAdicionaItemPorUnidade() {
		assertEquals(4, this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeNomeVazio() {
		this.controller.adicionaItemPorUnidade("", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorUnidadeNomeNulo() {
		this.controller.adicionaItemPorUnidade(null, "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeCategoriaVazia() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "", 3, "Mercadinho Bem Barato", 3.79);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeCategoriaInvalida() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "categoria", 3, "Mercadinho Bem Barato", 3.79);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorUnidadeCategoriaNula() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", null, 3, "Mercadinho Bem Barato", 3.79);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeNegativa() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", -3, "Mercadinho Bem Barato", 3.79);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadeLocalDeCompraVazio() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "", 3.79);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaItemPorUnidadeLocalDeCompraNulo() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, null, 3.79);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaItemPorUnidadePrecoNegativo() {
		this.controller.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", -3.79);
	}

	@Test
	public void testExibeItem() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", this.controller.exibeItem(1));
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testExibeItemIdInvalido() {
		this.controller.exibeItem(-1);
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testExibeItemIdInexistente() {
		this.controller.exibeItem(100);
	}

	@Test
	public void testAtualizaItem() {
		this.controller.atualizaItem(1, "nome", "Agua Sanitaria Viserion");
		assertEquals("1. Agua Sanitaria Viserion, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", this.controller.exibeItem(1));
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testAtualizaItemIdInvalido() {
		this.controller.atualizaItem(-1, "nome", "Agua Sanitaria Viserion");
	}
	
	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testAtualizaItemIdInexistente() {
		this.controller.atualizaItem(100, "nome", "Agua Sanitaria Viserion");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaItemArtibutoVazio() {
		this.controller.atualizaItem(1, "", "Agua Sanitaria Viserion");
	}
	
	@Test(expected=NullPointerException.class)
	public void testAtualizaItemNomeNulo() {
		this.controller.atualizaItem(100, null, "Agua Sanitaria Viserion");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaItemNovaCategoriaInvalida() {
		this.controller.atualizaItem(100, "categoria", "categoria");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaItemNovaQuantidadeInvalida() {
		this.controller.atualizaItem(100, "quantidade", "-1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaItemNovoValorQuilosInvalido() {
		this.controller.atualizaItem(100, "kg", "-1.0");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaItemNovoValorUnidadeInvalido() {
		this.controller.atualizaItem(100, "unidades", "-1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaItemAtributoInexistente() {
		this.controller.atualizaItem(100, "atributo", "1");
	}

	@Test
	public void testAdicionaPrecoItem() {
		this.controller.adicionaPrecoItem(1, "Loja da esquina", 2.00);
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Loja da esquina, R$ 2,00;Supermercado Excepcional, R$ 2,19;>", this.controller.exibeItem(1));
	}

	@Test(expected=ArrayIndexOutOfBoundsException.class)
	public void testDeletaItem() {
		this.controller.deletaItem(1);
		this.controller.exibeItem(1);
	}

	@Test
	public void testGetItem() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", this.controller.getItem(0));
	}
	
	@Test
	public void testGetItemInexistente() {
		assertEquals("", this.controller.getItem(10));
	}

	@Test
	public void testGetItemPorCategoria() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", this.controller.getItemPorCategoria("limpeza", 0));
	}

	@Test
	public void testGetItemPorMenorPreco() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", this.controller.getItemPorMenorPreco(0));
	}

	@Test
	public void testGetItemPorPesquisa() {
		assertEquals("1. Agua Sanitaria Drogon, limpeza, 1 l, Preco: <Supermercado Excepcional, R$ 2,19;>", this.controller.getItemPorPesquisa("agua", 0));
	}

}

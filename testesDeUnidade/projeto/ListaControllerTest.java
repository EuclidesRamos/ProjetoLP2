package projeto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ListaControllerTest {

	private ListaController controllerLista;
	private ItemController controllerItem;

	@Before
	public void exemploListaController() {
		this.controllerItem = new ItemController();
		this.controllerLista = new ListaController(controllerItem);
		this.controllerLista.adicionaListaDeCompras("feira semana");
		this.controllerLista.adicionaListaDeCompras("compras");
		this.controllerItem.adicionaItemPorQtd("Agua Sanitaria Drogon", "limpeza", 1, "l", "Supermercado Excepcional", 2.19);
		this.controllerItem.adicionaItemPorUnidade("Creme dental Oral-C", "higiene pessoal", 3, "Mercadinho Bem Barato", 3.79);
		this.controllerLista.adicionaCompraALista("compras", 3, 1);
	}

	@Test
	public void testAdicionaListaDeCompras() {
		assertEquals("teste", this.controllerLista.adicionaListaDeCompras("teste"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaListaDeComprasDescricaoNula() {
		this.controllerLista.adicionaListaDeCompras(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdicionaListaDeComprasDescricaaVazia() {
		this.controllerLista.adicionaListaDeCompras("  ");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		assertEquals("compras", this.controllerLista.pesquisaListaDeCompras("compras"));
	}
	
	@Test(expected=NullPointerException.class)
	public void testPesquisaListaDeComprasDescricaoNula() {
		this.controllerLista.pesquisaListaDeCompras(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPesquisaListaDeComprasDescricaoVazia() {
		this.controllerLista.pesquisaListaDeCompras(" ");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPesquisaListaDeComprasInexistente() {
		this.controllerLista.pesquisaListaDeCompras("feira");
	}

	@Test
	public void testAdicionaCompraALista() {
		this.controllerLista.adicionaCompraALista("feira semana", 3, 1);
		assertEquals("3 Agua Sanitaria Drogon, limpeza, 1 l", this.controllerLista.pesquisaCompraEmLista("feira semana", 1));
	}
	
	@Test(expected=NullPointerException.class)
	public void testAdicionaCompraAListaItemInvalido() {
		this.controllerLista.adicionaCompraALista("feira semana", 3, 2);
	}
	
	@Test
	public void testPesquisaCompraEmLista() {
		assertEquals("3 Agua Sanitaria Drogon, limpeza, 1 l", this.controllerLista.pesquisaCompraEmLista("compras", 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPesquisaCompraEmListaDescricaoVazia() {
		this.controllerLista.pesquisaCompraEmLista(" ", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testPesquisaCompraEmListaDescricaoNula() {
		this.controllerLista.pesquisaCompraEmLista(null, 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPesquisaCompraEmListaIdInvalido() {
		this.controllerLista.pesquisaCompraEmLista("compras", -1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testPesquisaCompraEmListaItemInvalido() {
		this.controllerLista.pesquisaCompraEmLista("compras", 2);
	}

	@Test
	public void testAtualizaCompraDeListaAumenta() {
		this.controllerLista.atualizaCompraDeLista("compras", 1, "adiciona", 1);
		assertEquals("4 Agua Sanitaria Drogon, limpeza, 1 l", this.controllerLista.pesquisaCompraEmLista("compras", 1));
	}
	
	@Test
	public void testAtualizaCompraDeListaDiminui() {
		this.controllerLista.atualizaCompraDeLista("compras", 1, "diminui", 1);
		assertEquals("2 Agua Sanitaria Drogon, limpeza, 1 l", this.controllerLista.pesquisaCompraEmLista("compras", 1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAtualizaCompraDeListaOperacaoInvalida() {
		this.controllerLista.atualizaCompraDeLista("compras", 1, "multiplica", 1);
	}

	@Test
	public void testFinalizarListaDeCompras() {
		this.controllerLista.finalizarListaDeCompras("compras", "mercadinho", 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasDescricaoInvalida() {
		this.controllerLista.finalizarListaDeCompras("  ", "mercadinho", 3);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFinalizarListaDeComprasDescricaoNula() {
		this.controllerLista.finalizarListaDeCompras(null, "mercadinho", 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasLocalDeCompraInvalido() {
		this.controllerLista.finalizarListaDeCompras("compras", " ", 3);
	}
	
	@Test(expected=NullPointerException.class)
	public void testFinalizarListaDeComprasLocalDeCompraNulo() {
		this.controllerLista.finalizarListaDeCompras("compras", null, 3);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFinalizarListaDeComprasValorFinalInvalido() {
		this.controllerLista.finalizarListaDeCompras("compras", "mercadinho", -3);
	}

	@Test
	public void testDeletaCompraDeLista() {
		this.controllerLista.deletaCompraDeLista("compras", 1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testDeletaCompraDeListaDescricaoInvalida() {
		this.controllerLista.deletaCompraDeLista("", 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testDeletaCompraDeListaDescricaoNula() {
		this.controllerLista.deletaCompraDeLista(null, 1);
	}
	
	@Test(expected=NullPointerException.class)
	public void testDeletaCompraDeListaItemNaoCadastradoNoSistema() {
		this.controllerLista.deletaCompraDeLista("compras", 3);
	}
	
	@Test(expected=NullPointerException.class)
	public void testDeletaCompraDeListaItemNaoEncontradoNaLista() {
		this.controllerLista.deletaCompraDeLista("compras", 2);
	}

	@Test
	public void testGetItemLista() {
		assertEquals("3 Agua Sanitaria Drogon, limpeza, 1 l", this.controllerLista.getItemLista("compras", 0));
	}

	@Test
	public void testGetItemListaPorData() {
		assertEquals("compras", this.controllerLista.getItemListaPorData("22/07/2018", 0));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testGetItemListaPorDataInvalida() {
		this.controllerLista.getItemListaPorData("20001122", 0);
	}
	
	@Test
	public void testGetItemListaPorItem() {
		assertEquals("22/07/2018 - compras", this.controllerLista.getItemListaPorItem(1, 0));
	}
	
	@Test
	public void testpesquisaListasDeComprasPorData() {
		assertEquals("compras" + System.lineSeparator() + "feira semana" + System.lineSeparator(), this.controllerLista.pesquisaListasDeComprasPorData("22/07/2018"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testpesquisaListasDeComprasPorDataInvalida() {
		this.controllerLista.pesquisaListasDeComprasPorData("20001122");
	}
	
	@Test
	public void pesquisaListasDeComprasPorItem() {
		assertEquals("compras" + System.lineSeparator(), this.controllerLista.pesquisaListasDeComprasPorItem(1));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void pesquisaListasDeComprasPorItemCompraNaoEncontradaNaLista() {
		this.controllerLista.pesquisaListasDeComprasPorItem(2);
	}
}

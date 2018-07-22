package projeto;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class ListaControllerTest {

	private ListaController controlleLista;
	private ItemController controllerItem = new ItemController();

	@Before
	public void exemploListaController() {
		this.controlleLista = new ListaController(controllerItem);
	}
	@Test
	public void testListaController() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testPesquisaListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdicionaCompraALista() {
		fail("Not yet implemented");
	}

	@Test
	public void testPesquisaCompraEmLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testAtualizaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalizarListaDeCompras() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletaCompraDeLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemLista() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemListaPorData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetItemListaPorItem() {
		fail("Not yet implemented");
	}

}

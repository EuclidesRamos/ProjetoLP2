package projeto;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ListaTest {
	Item item;
	Lista lista;
	String data;
	Lista lista2;

	@Before
	public void incializaTeste() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		this.data = formatoData.format(new Date(System.currentTimeMillis()));
		this.item = new ItemQuantidadeFixa(1, "Rakan", "higiene pessoal", 80, "gramas", "Summers Rift", 5.50);
		this.lista = new Lista("Feira 26/05/2018");
		this.lista.adicionaCompraALista(5, item, 0);
	}

	@Test(expected = NullPointerException.class)
	public void testConstruirListaDescricaoNula() {
		lista = new Lista(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConstruirListaDescricaoVazia() {
		lista = new Lista("");
	}

	@Test
	public void testGetDescricao() {
		assertEquals(lista.getDescricao(), "Feira 26/05/2018");
	}

	@Test
	public void testToString() {
		assertEquals(lista.toString(), data + " - " + "Feira 26/05/2018");
	}

	@Test
	public void testDeletaCompraDeLista() {
		;
		lista.deletaCompraDeLista(0);
		assertFalse(lista.verificaItemLista(0));
	}

	@Test
	public void testGetData() {
		assertEquals(lista.getData(), data);
	}

	@Test
	public void testAtualizaCompraDeListaAdiciona() {
		lista.atualizaCompraDeLista(0, 8, "adiciona");
		assertEquals(lista.pegaCompra(0).getQuantidade(), 13);
	}

	@Test
	public void testAtualizaCompraDeListaDiminui() {
		lista.atualizaCompraDeLista(0, 4, "diminui");
		assertEquals(lista.pegaCompra(0).getQuantidade(), 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaComandoInexistente() {
		lista.atualizaCompraDeLista(0, 8, "multiplica");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAtualizaCompraDeListaCompraNaoExiste() {
		lista.atualizaCompraDeLista(1, 8, "adiciona");
	}

	@Test
	public void testGetCompra() {
		assertEquals(lista.getCompra(0), "5 Rakan, higiene pessoal, 80 gramas");

	}

	@Test
	public void testAdicionarCompraALista() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 3, "O baratao", 5.90);
		this.lista.adicionaCompraALista(10, item, item.getId());
		assertTrue(this.lista.verificaItemLista(1));
	}

	@Test
	public void testFinalizarListaDeCompras() {
		this.lista.finalizarListaDeCompras("O baratao", 100);
		assertEquals(this.lista.getLocalDaCompra(), "O baratao");
	}

	@Test
	public void testGetLocalDaCompra() {
		this.lista.finalizarListaDeCompras("O baratao", 100);
		assertEquals(this.lista.getLocalDaCompra(), "O baratao");
	}

	@Test
	public void testGetValorFinalCompra() {
		this.lista.finalizarListaDeCompras("O baratao", 100);
		assertEquals(this.lista.getValorFinalCompra(), 100);
	}

	@Test
	public void testGetItemLista() {
		this.item = new ItemUnidade(1, "Sabao", "limpeza", 3, "O baratao", 5.90);
		this.lista.adicionaCompraALista(10, item, item.getId());
		assertEquals(this.lista.getItemLista(0), "5 Rakan, higiene pessoal, 80 gramas");
	}

	@Test
	public void testGetItemListaPosicaoInvalida() {
		assertEquals(this.lista.getItemLista(7), "");
	}

	@Test
	public void testVerificaItemListaTrue() {
		assertTrue(this.lista.verificaItemLista(0));
	}

	@Test
	public void testVerificaItemListaFalse() {
		assertFalse(this.lista.verificaItemLista(8));
	}

	@Test
	public void testPegaCompra() {
		assertEquals(this.lista.pegaCompra(0).toString(), "5 Rakan, higiene pessoal, 80 gramas");
	}

	@Test
	public void testEqualsTrue() {
		this.lista2 = new Lista("Feira 26/05/2018");
		assertTrue(this.lista.equals(this.lista2));
	}

	@Test
	public void testEqualsFalse() {
		this.lista2 = new Lista("Feira 01/08/2018");
		assertFalse(this.lista.equals(this.lista2));
	}

}

package projeto;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ListaTest {
	Item item;
	Compra compra;
	Lista lista;
	Lista lista2;
	String data;

	@Before
	public void incializaTeste() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		this.data = formatoData.format(new Date(System.currentTimeMillis()));
		this.item = new ItemQuantidadeFixa(1, "Rakan", "higiene pessoal", 80, "gramas", "Summers Rift", 5.50);
		this.compra = new Compra(10, item);
		this.lista = new Lista("LOL");
		this.lista.adicionaCompraALista(5, item, 0);
	}

	@Test(expected = NullPointerException.class)
	public void testListaDescricaoNula() {
		lista2 = new Lista(null);
	}

	@Test
	public void testGetDescricao() {
		assertEquals(lista.getDescricao(), "LOL");
	}

	@Test
	public void testToString() {
		assertEquals(lista.toString(), data + " - " +"LOL");
	}

	@Test
	public void testDeletaCompraDeLista() {
		lista.deletaCompraDeLista(0);
		assertEquals(lista, lista.getDescricao());
	}

	@Test
	public void testGetData() {
		assertEquals(lista.getData(), data);
	}

	@Test
	public void testAtualizaCompraDeLista() {
		lista.atualizaCompraDeLista(0, 8, "adiciona");
		assertEquals(lista.pegaCompra(0).toString(), "13 Rakan, higiene pessoal, 80 gramas");
	}

}

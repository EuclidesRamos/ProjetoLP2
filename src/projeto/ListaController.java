package projeto;

import java.util.HashMap;
import java.util.Map;

public class ListaController {
	
	private Map<String, Lista> listas;
	private ItemController controllerItem;
	private Validador validador;
	
	public ListaController() {
		this.listas = new HashMap<>();
		this.controllerItem = new ItemController();
	}
	
	public void adicionaListaDeCompras(String descritor) {
		Lista lista = new Lista(descritor);
		this.listas.put(descritor, lista);
	}
	
	public String pesquisaListaDeCompras(String descritor) {
		return this.listas.get(descritor).toString();
	}
	
	public void adicionaCompraALista(String descritorLista, int quantidade, int idItem) {
		this.validador.validaCompra(descritorLista, quantidade);
		if (idItem < 0 || this.controllerItem.pegaItem(idItem) == null) {
			throw new IllegalArgumentException("");
		}
		this.listas.get(descritorLista).adicionaCompra(quantidade, this.controllerItem.pegaItem(idItem));
	}
	
	public String pesquisaCompraEmLista(String descritorLista, int idItem) {
		this.validador.validaPesquisaCompraEmLista(descritorLista);
		if (idItem < 0 || this.controllerItem.pegaItem(idItem) == null) {
			throw new IllegalArgumentException("");
		}
		return this.listas.get(descritorLista).pegaItemLista(this.controllerItem.pegaItem(idItem));
	}
	
	public void atualizaCompraDeLista(String descritorLista, int idItem, String operacao, int quantidade) {
		this.validador.validaAtualizaCompraDeLista(descritorLista);
		if (idItem < 0 || this.controllerItem.pegaItem(idItem) == null) {
			throw new IllegalArgumentException("");
		}
		this.listas.get(descritorLista).atualizaCompra(this.controllerItem.pegaItem(idItem), quantidade, operacao);
	}
	
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, int valorFinalDaCompra) {
		this.listas.get(localDeCompra).finalizaLista(localDeCompra, valorFinalDaCompra);
	}
	
	public void deletaCompraDeLista(String descritorLista, int idItem) {
		this.listas.get(descritorLista).deletaCompra(this.controllerItem.pegaItem(idItem));
	}

}

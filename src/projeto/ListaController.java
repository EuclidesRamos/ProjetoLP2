package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por controlar e armazenar listas de compras.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class ListaController {
	
	/**
	 * Atributo do tipo Map responsavel por armazenar as listas de compra.
	 */
	private Map<String, Lista> listas;
	
	/**
	 * Atributo que armazena o controller de Item.
	 */
	private ItemController controllerItem;
	
	/**
	 * Atributo que armazena o validador de parametros.
	 */
	private Validador validador;
	
	/**
	 * Contrutor responsavel por contruir o objeto do tipo ListaController, criando tambem um HashMap e um ItemController.
	 */
	public ListaController() {
		this.listas = new HashMap<>();
		this.controllerItem = new ItemController();
	}
	
	/**
	 * Metodo responsavel por adicionar novas listas de compras no Sistema.
	 * 
	 * @param descritor Descritor da lista de compras (ex. "feira 19/07").
	 */
	public void adicionaListaDeCompras(String descritor) {
		this.validador.validaListaDeCompras(descritor);
		Lista lista = new Lista(descritor);
		this.listas.put(descritor, lista);
	}
	
	/**
	 * Metodo responsavel por pesquisar uma lista de compras no Sistema. A pesquisa e realizada atraves do descritor da lista de compras.
	 * 
	 * @param descritor Descritor da lista de compras a ser pesquisada.
	 * @return Retorna uma representacao em String da lista de compras.
	 */
	public String pesquisaListaDeCompras(String descritor) {
		return this.listas.get(descritor).toString();
	}
	
	/**
	 * Metodo responsavel por adicionar compras em uma lista.
	 * 
	 * @param descritorLista Descritor da lista em que a compra sera adicionada.
	 * @param quantidade Quantidade do item a ser comprado.
	 * @param idItem Id do item a ser adiconado na compra.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int idItem) {
		if (idItem < 0 || this.controllerItem.pegaItem(idItem) == null) {
			throw new IllegalArgumentException("");
		}
		this.listas.get(descritorLista).adicionaCompra(quantidade, this.controllerItem.pegaItem(idItem));
	}
	
	/**
	 * Metodo responsavel por pesquisar uma determinada compra em uma lista.
	 * 
	 * @param descritorLista Descritor da lista em que sera realizada a pesquisa da compra.
	 * @param idItem Id do item da compra.
	 * @return Retorna uma representacao da compra que foi pesquisada.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int idItem) {
		this.validador.validaPesquisaCompraEmLista(descritorLista);
		return this.listas.get(descritorLista).pegaItemLista(this.controllerItem.pegaItem(idItem));
	}
	
	/**
	 * Metodo responsavel por atualizar compra em uma lista de comrpas.
	 * 
	 * @param descritorLista Descritor da lista em que a compra esta localizada.
	 * @param idItem Id do item da compra.
	 * @param operacao Operacao de atualizacao ("aumenta" ou "diminui" quantidade).
	 * @param quantidade Novo valor de quantidade a ser icrementado/decrementado na quantidade da compra.
	 */
	public void atualizaCompraDeLista(String descritorLista, int idItem, String operacao, int quantidade) {
		this.validador.validaAtualizaCompraDeLista(descritorLista);
		this.listas.get(descritorLista).atualizaCompra(this.controllerItem.pegaItem(idItem), quantidade, operacao);
	}
	
	/**
	 * Metodo responsavel por finalizar uma lista de compras (quando a compra e efetivada).
	 * 
	 * @param descritorLista Descritor da lista a ser finalizada.
	 * @param localDeCompra Local em que a compra foi realizada.
	 * @param valorFinalDaCompra Valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, int valorFinalDaCompra) {
		this.listas.get(localDeCompra).finalizaLista(localDeCompra, valorFinalDaCompra);
	}
	
	/**
	 * Metodo responsavel por deletar uma compra em uma lista.
	 * 
	 * @param descritorLista Descritor da lista em que será deletado compra dela.
	 * @param idItem Id do item da compra.
	 */
	public void deletaCompraDeLista(String descritorLista, int idItem) {
		this.listas.get(descritorLista).deletaCompra(this.controllerItem.pegaItem(idItem));
	}

	public String pesquisaPorDescritor(String descritor) {
		return this.listas.get(descritor).toString();
	}
	
	public String pesquisaPorData(String data) {
		List<lista> feiras = new ArrayList<>();
		for  (Lista lista : this.listas.values()) {
			if (lista.getDataHora().contains(data)) {
				
			}
		}
		
	}
	
}

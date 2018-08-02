package projeto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
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
	 * Atributo responsavel pela estrategia de ordenacao das listas no Sistema.
	 */
	private Comparator<Lista> estrategiaDeOrdenacao;

	private String geraData() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		return formatoData.format(new Date(System.currentTimeMillis()));
	}

	/**
	 * Contrutor responsavel por contruir o objeto do tipo ListaController, criando
	 * tambem um HashMap e um ItemController.
	 */
	public ListaController(ItemController controllerItem) {
		this.listas = new LinkedHashMap<>();
		this.controllerItem = controllerItem;
		this.validador = new Validador();
	}

	/**
	 * Metodo responsavel por adicionar novas listas de compras no Sistema.
	 * 
	 * @param descritorLista Descritor da lista de compras (ex. "feira 19/07").
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		this.validador.validaListaDeCompras(descritorLista, "Erro na criacao de lista de compras: ");
		this.listas.put(descritorLista, new Lista(descritorLista));
		return descritorLista;
	}

	/**
	 * Metodo responsavel por pesquisar uma lista de compras no Sistema. A pesquisa
	 * e realizada atraves do descritor da lista de compras.
	 * 
	 * @param descritorLista Descritor da lista de compras a ser pesquisada.
	 * @return Retorna uma representacao em String da lista de compras.
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		this.validador.validaListaDeCompras(descritorLista, "Erro na pesquisa de compra: ");
		if (!this.listas.containsKey(descritorLista)) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: lista de compras nao existe.");
		}
		return descritorLista;

	}

	/**
	 * Metodo responsavel por adicionar compras em uma lista.
	 * 
	 * @param descritorLista Descritor da lista em que a compra sera adicionada.
	 * @param quantidade     Quantidade do item a ser comprado.
	 * @param itemId         Id do item a ser adiconado na compra.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.validador.validaObjeto(this.controllerItem.pegaItem(itemId),
				"Erro na compra de item: item nao existe no sistema.");
		this.listas.get(descritorLista).adicionaCompraALista(quantidade, this.controllerItem.pegaItem(itemId), itemId);
	}

	/**
	 * Metodo responsavel por pesquisar uma determinada compra em uma lista.
	 * 
	 * @param descritorLista Descritor da lista em que sera realizada a pesquisa da
	 *                       compra.
	 * @param itemId         Id do item da compra.
	 * @return Retorna uma representacao da compra que foi pesquisada.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		this.validador.validaListaDeCompras(descritorLista, "Erro na pesquisa de compra: ");
		if (itemId <= 0) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: item id invalido.");
		}
		this.validador.validaObjeto(this.listas.get(descritorLista).pegaCompra(itemId),
				"Erro na pesquisa de compra: compra nao encontrada na lista.");
		return this.listas.get(descritorLista).getCompra(itemId);
	}

	/**
	 * Metodo responsavel por atualizar compra em uma lista de comrpas.
	 * 
	 * @param descritorLista Descritor da lista em que a compra esta localizada.
	 * @param itemId         Id do item da compra.
	 * @param operacao       Operacao de atualizacao ("aumenta" ou "diminui"
	 *                       quantidade).
	 * @param quantidade     Novo valor de quantidade a ser icrementado/decrementado
	 *                       na quantidade da compra.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		this.validador.validaAtualizaCompraDeLista(operacao);
		this.listas.get(descritorLista).atualizaCompraDeLista(itemId, quantidade, operacao);
	}

	/**
	 * Metodo responsavel por finalizar uma lista de compras (quando a compra e
	 * efetivada).
	 * 
	 * @param descritorLista     Descritor da lista a ser finalizada.
	 * @param localDeCompra      Local em que a compra foi realizada.
	 * @param valorFinalDaCompra Valor final da compra.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, int valorFinalDaCompra) {
		this.validador.validaFinalizarListaDeCompras(descritorLista, localDeCompra, valorFinalDaCompra);
		this.listas.get(descritorLista).finalizarListaDeCompras(localDeCompra, valorFinalDaCompra);
	}

	/**
	 * Metodo responsavel por deletar uma compra em uma lista.
	 * 
	 * @param descritorLista Descritor da lista em que sera deletado compra dela.
	 * @param itemId         Id do item da compra.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.validador.validaListaDeCompras(descritorLista, "Erro na exclusao de compra: ");
		this.validador.validaObjeto(this.controllerItem.pegaItem(itemId),
				"Erro na exclusao de compra: item nao existe no sistema.");
		this.validador.validaObjeto(this.listas.get(descritorLista).pegaCompra(itemId),
				"Erro na exclusao de compra: compra nao encontrada na lista.");
		this.listas.get(descritorLista).deletaCompraDeLista(itemId);
	}

	/**
	 * Metodo responsavel por realizar pesquisa em uma lista, retornando o toString
	 * da compra que esta na posicao passada como parametro.
	 * 
	 * @param descritor   Descritor da lista que sera pesquisada.
	 * @param posicaoItem Posicao da compra a ser exibida.
	 * @return Retorna a representacao em String da compra que esta na posicao
	 *         passada como parametro.
	 * @return Retorna a representacao em String da compra que esta na posicao
	 *         passada como parametro.
	 */
	public String getItemLista(String descritor, int posicaoItem) {
		return this.listas.get(descritor).getItemLista(posicaoItem);
	}

	/**
	 * Metodo responsavel por pesquisar uma lista de compras pela sua data de
	 * criacao.
	 * 
	 * @param data         Data de criacao a ser pesquisada
	 * @param posicaoLista Posicao da lista a ser exibida.
	 * @return Retorna uma representacao em String da lista que est� na posicao
	 *         informada e que foi criada na data informada.
	 * @return Retorna uma representacao em String da lista que esta na posicao
	 *         informada e que foi criada na data informada.
	 */
	public String getItemListaPorData(String data, int posicaoLista) {
		this.validador.validaData(data);
		List<Lista> feiras = new ArrayList<>();
		this.estrategiaDeOrdenacao = new OrdenaListaAlfabetica();
		for (Lista lista : this.listas.values()) {
			if (lista.getData().contains(data)) {
				feiras.add(lista);
			}
		}
		Collections.sort(feiras, this.estrategiaDeOrdenacao);
		return feiras.get(posicaoLista).getDescricao();
	}

	/**
	 * Metodo responsavel por pesquisar as listas de compras que cont�m o item
	 * passado como parametro. Metodo responsavel por pesquisar as listas de compras
	 * que contem o item passado como parametro.
	 * 
	 * @param itemId       Id do item.
	 * @param posicaoLista Posicao da lista a ser exibida.
	 * @return Retorna uma representacao em String da compra que esta na posicao em
	 *         que foi passada como parametro.
	 */
	public String getItemListaPorItem(int itemId, int posicaoLista) {
		List<Lista> feiras = new ArrayList<>();
		this.estrategiaDeOrdenacao = new OrdenaListaData();
		for (Lista lista : this.listas.values()) {
			if (lista.verificaItemLista(itemId)) {
				feiras.add(lista);
			}
		}
		Collections.sort(feiras, this.estrategiaDeOrdenacao);
		return feiras.get(posicaoLista).toString();
	}

	/**
	 * Metodo responsavel por retornar a descricao das listas que foram criadas na
	 * data passada como parametro.
	 * 
	 * @param data data a ser pesquisada.
	 * @return Retorna os descritores das listas que foram criadas na data
	 *         informada.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		this.validador.validaData(data);
		String saida = "";
		for (Lista lista : listas.values()) {
			if (lista.getData().equals(data)) {
				saida += lista.getDescricao() + System.lineSeparator();
			}
		}
		return saida;
	}

	/**
	 * Metodo responsavel por retornar a descricao das listas que possuem o item
	 * informado.
	 * 
	 * @param itemId Id do item a ser procurado.
	 * @return Retorna os descritores das listas que possuem o item informado.
	 */
	public String pesquisaListasDeComprasPorItem(int itemId) {
		String saida = "";
		for (Lista lista : listas.values()) {
			if (lista.pegaCompra(itemId) != null) {
				saida += lista.getDescricao() + System.lineSeparator();
			}
		}
		if ("".equals(saida)) {
			throw new IllegalArgumentException("Erro na pesquisa de compra: compra nao encontrada na lista.");
		}
		return saida;
	}

	/**
	 * Metodo responsavel por gerar uma nova lista a partir da ultima lista cadastrada.
	 * @return a descricao da nova lista
	 */
	public String geraAutomaticaUltimaLista() {
		List<Lista> listas = new ArrayList<>(this.listas.values());
		Lista novaLista = new Lista("Lista automatica 1 " + this.geraData());
		novaLista.addAll(listas.get(this.listas.size() - 1));
		this.listas.put(novaLista.getDescricao(), novaLista);
		return novaLista.getDescricao();
	}

	/**
	 * Metodo responsavel por gerar uma nova lista a partir de um item especifico.
	 * @param descritorItem Descritor do item base.
	 * @return a descricao da nova lista
	 */
	public String geraAutomaticaItem(String descritorItem) {
		boolean temItem = false;

		List<Lista> listas = new ArrayList<>(this.listas.values());
		Collections.reverse(listas);
		Lista ultimaLista = new Lista("Lista automatica 2 " + this.geraData());
		for (Lista lista : listas) {
			if (lista.contains(descritorItem)) {
				temItem = true;
				ultimaLista.addAll(lista);
				this.listas.put(ultimaLista.getDescricao(), ultimaLista);
				return ultimaLista.getDescricao();

			}
		}
		if(!(temItem)) {
				throw new IllegalArgumentException("Erro na geracao de lista automatica por item: nao ha compras cadastradas com o item desejado.");
				
			}	
		
		return "";
	}

	public String geraAutomaticaItensMaisPresentes() {
		Lista novaLista = new Lista("Lista automatica 3 " + this.geraData());

		for (Item item : this.controllerItem.getItens().values()) {
			if (verificacaItemNaLista(item) > 0) {
				novaLista.adicionaCompraALista(verificacaItemNaLista(item), item, item.getId());
			}

		}
		this.listas.put(novaLista.getDescricao(), novaLista);

		return novaLista.getDescricao();
	}

	private int verificacaItemNaLista(Item item) {
		int aparece = 0;
		int quantidade = 0;

		for (Lista lista : this.listas.values()) {
			if (lista.getCompras().containsKey(item.getId())) {
				quantidade += lista.getCompras().get(item.getId()).getQuantidade();
				aparece++;

			}
		}
		if (aparece >= this.listas.size() / 2) {
			return (int) Math.floor(quantidade / aparece);
		} else {
			return -1;
		}

	}

	public String sugereMelhorEstabelecimento() {
		return null;
	}

}

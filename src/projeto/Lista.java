package projeto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;

/**
 * Classe responsavel por representar uma lista de compras no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class Lista {
	
	/**
	 * Mapa de compras.
	 */
	private Map<Integer, Compra> compras;
	
	/**
	 * Data da criacao da lista.
	 */
	private String data;
	
	/**
	 * Descricao da lista.
	 */
	private String descricao;
	
	/**
	 * Local onde a lista foi finalizada.
	 */
	private String localDaCompra;
	
	/**
	 * Valor final da lista finalizada.
	 */
	private int valorFinalCompra;
	
	/**
	 * Ordenador de compras.
	 */
	private Comparator<Compra> ordenacaoCompras;

	/**
	 * Atributor responsavel por armazenar o validador de parametros.
	 */
	private Validador validador;

	/**
	 * Constroi uma lista a partir de sua descricao.
	 * 
	 * @param descricao Descricao da lista
	 */
	public Lista(String descricao) {
		validador = new Validador();
		this.validador.validaListaDeCompras(descricao);
		this.descricao = descricao;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		this.data = formatoData.format(new Date(System.currentTimeMillis()));
		this.compras = new HashMap<>();
		this.ordenacaoCompras = new OrdenacaoDefault();

	}

	/**
	 * Metodo que adiciona uma compra a uma lista.
	 * 
	 * @param itemId     Id do item
	 * @param quantidade Quantidade a ser passada
	 * @param operacao   Operacao
	 */
	public void adicionaCompraALista(int quantidade, Item item, int itemId) {
		Compra compra = new Compra(quantidade, item);
		this.compras.put(itemId, compra);
	}

	/**
	 * Metodo que retorna uma compra a partir do id do item associada a essa compra.
	 * 
	 * @return a representacao textual da compra
	 */
	public String getCompra(int itemId) {
		return compras.get(itemId).toString();
	}

	/**
	 * Metodo que atualiza uma compra a uma lista.
	 * 
	 * @param itemId     Id do item
	 * @param quantidade Quantidade a ser passada
	 * @param operacao   Operacao
	 */
	public void atualizaCompraDeLista(int itemId, int quantidade, String operacao) {
		if (!this.compras.containsKey(itemId)) {
			throw new IllegalArgumentException("Erro na atualizacao de compra: compra nao encontrada na lista.");
		}
		this.compras.get(itemId).atualizaCompra(operacao, quantidade);
		if (this.compras.get(itemId).getQuantidade() == 0) {
			this.compras.remove(itemId);
		}
	}

	/**
	 * Metodo que finaliza a lista.
	 * 
	 * @param localDeCompra      Local de compra
	 * @param valorFinalDaCompra Valor Final
	 */
	public void finalizarListaDeCompras(String localDeCompra, int valorFinalDaCompra) {
		this.localDaCompra = localDeCompra;
		this.valorFinalCompra = valorFinalDaCompra;

	}

	/**
	 * Metodo que retorna o local da compra ao finalizar a lista.
	 * 
	 * @return uma String do local
	 */
	public String getLocalDaCompra() {
		return localDaCompra;
	}

	/**
	 * Metodo que retorna o valor final da compra ao finalizar a lista.
	 * 
	 * @return um inteiro com o valor
	 */
	public int getValorFinalCompra() {
		return valorFinalCompra;
	}

	/**
	 * Metodo que deleta uma compra da lista
	 * 
	 * @param idItem do item da compra
	 */
	public void deletaCompraDeLista(int idItem) {
		this.compras.remove(idItem);
	}

	/**
	 * Metodo que retorna a descricao da lista.
	 * 
	 * @return a descricao
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Metodo que retorna a data da criacao da lista.
	 * 
	 * @return a data
	 */
	public String getData() {
		return this.data;
	}

	/**
	 * Metodo que retorna a representacao textual de um compra a partir da posicao
	 * do item a ela associada.
	 * 
	 * @param posicaoItem Posicao do item
	 * 
	 * @return uma String da compra
	 */
	public String getItemLista(int posicaoItem) {
		List<Compra> listaCompras = new ArrayList<>(this.compras.values());
		Collections.sort(listaCompras, ordenacaoCompras);
		if (posicaoItem >= this.compras.size() || null == listaCompras.get(posicaoItem)) {
			return "";
		}
		return listaCompras.get(posicaoItem).toString();
	}

	/**
	 * Metodo que verifica se na lista ja existe uma compra com o item passado como
	 * parametro.
	 * 
	 * @param itemId do item da compra
	 * @return um boolean
	 */
	public boolean verificaItemLista(int itemId) {
		if (this.compras.containsKey(itemId)) {
			return true;
		}
		return false;
	}

	/**
	 * Metodo que retorna uma compra a partir do item a ela associado.
	 * 
	 * @param idItem id do item
	 * @return a compra pesquisada
	 */
	public Compra pegaCompra(int itemId) {
		return this.compras.get(itemId);
	}

	/**
	 * Metodo que copia todas as compras de uma lista para outra.
	 * 
	 * @param lista Uma lista
	 */
	public void addAll(Lista lista) {
		for (Entry<Integer, Compra> entry : lista.compras.entrySet()) {
			this.compras.put(entry.getKey(), entry.getValue());
		}
	}

	/**
	 * Metodo que verifica se na lista existe uma compra com o item especificado
	 * 
	 * @param descritorItem Descritor do item
	 * @return um boolean
	 */
	public boolean contains(String descritorItem) {
		for (Compra compra : this.compras.values()) {
			if (compra.getItem().getNome().equals(descritorItem)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo que retorna o mapa contendo todas as compras da lista.
	 * 
	 * @return um mapa contendo todas as compras da lista
	 */
	public Map<Integer, Compra> getCompras() {
		return this.compras;
	}
	
	@Override
	public String toString() {
		return this.data + " - " + this.descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lista other = (Lista) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
}
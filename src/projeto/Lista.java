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

public class Lista {
	private Map<Integer, Compra> compras;
	private String data;
	private String descricao;
	private String localDaCompra;
	private int valorFinalCompra;
	private Comparator<Compra> ordenacaoCompras;

	public Lista(String descricao) {
		this.descricao = descricao;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		this.data = formatoData.format(new Date(System.currentTimeMillis()));
		this.compras = new HashMap<>();
		this.ordenacaoCompras = new OrdenacaoDefault();
	}

	/**
	 * Metodo que adiciona uma compra a uma lista.
	 * 
	 * @param itemId     Id do item.
	 * @param quantidade Quantidade a ser passada.
	 * @param operacao   Operacao.
	 */
	public void adicionaCompraALista(int quantidade, Item item, int itemId) {
		Compra compra = new Compra(quantidade, item);
		this.compras.put(itemId, compra);
	}

	/**
	 * Metodo que ira armazenar as compras.
	 * 
	 * @return compras.
	 */
	public String getCompra(int itemId) {
		return compras.get(itemId).toString();
	}

	/**
	 * Metodo que atualiza uma compra a uma lista.
	 * 
	 * @param itemId     Id do item.
	 * @param quantidade Quantidade a ser passada.
	 * @param operacao   Operacao.
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
	 * @param localDeCompra      Local de compra.
	 * @param valorFinalDaCompra Valor Final.
	 */
	public void finalizarListaDeCompras(String localDeCompra, int valorFinalDaCompra) {
		this.localDaCompra = localDeCompra;
		this.valorFinalCompra = valorFinalDaCompra;

	}

	/**
	 * Metodo onde deleta uma compra.
	 * 
	 * @param idItem do item da compra.
	 */
	public void deletaCompraDeLista(int idItem) {
		this.compras.put(idItem, null);
	}

	/**
	 * Metodo que captura uma descricao.
	 * 
	 * @return uma descricao.
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Metodo que recupera a data e hora.
	 * 
	 * @return data atual.
	 */

	public String getData() {
		return this.data;
	}

	/**
	 * Metodo que captura um item da lista.
	 * 
	 * @param posicaoItem
	 * 
	 * @return a lista com a posicao do item.
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
	 * Verifica se a lista ja possue um item.
	 * 
	 * @param itemId do item da compra.
	 * @return um boolean.
	 */
	public boolean verificaItemLista(int itemId) {
		if (this.compras.get(itemId) != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que pesquisa em uma compra
	 * 
	 * @param idItem id do item.
	 * @return a compra pesquisada.
	 */
	public Compra pegaCompra(int itemId) {
		return this.compras.get(itemId);
	}
	
	public void addAll(Lista lista) {
		for (Entry<Integer, Compra> entry : lista.compras.entrySet()) {
			this.compras.put(entry.getKey(), entry.getValue());
		}
	}
	
	public boolean contains(String descritorItem) {
		for (Compra compra : this.compras.values()) {
			if (compra.getItem().getNome().equals(descritorItem)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Sobrescita do metodo toString.
	 */
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
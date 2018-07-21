package projeto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Lista {
	private Map<Integer, Compra> compras;
	private LocalDateTime data;
	private String descricao;
	private String localDaCompra;
	private int valorFinalCompra;

	public Lista(String descricao) {
		this.descricao = descricao;
		this.data = LocalDateTime.now();
		this.compras = new HashMap<>();
	}

	public void adicionaCompraALista(int quantidade, Item item, int itemId) {
		Compra compra = new Compra(quantidade, item);
		this.compras.put(itemId, compra);
	}
	
	public String getCompra(int itemId) {
		return compras.get(itemId).toString();
	}

	public void atualizaCompraDeLista(int itemId, int quantidade, String operacao) {
		this.compras.get(itemId).atualizaCompra(operacao, quantidade);
		if (this.compras.get(itemId).getQuantidade() == 0) {
			this.compras.remove(itemId);
		}
	}
	
	public void finalizarListaDeCompras(String localDeCompra, int valorFinalDaCompra) {
		this.localDaCompra = localDeCompra;
		this.valorFinalCompra = valorFinalDaCompra;
		
	}
	
	public void deletaCompraDeLista(int idItem) {
		this.compras.put(idItem, null);
	}

	public String getDescricao() {
		return this.descricao;
	}

	public String getData() {
		return this.data + "";
	}

	public String getItemLista(int posicaoItem) {
		List<Compra> listaCompras = new ArrayList<>(this.compras.values());
		Collections.sort(listaCompras, new OrdenacaoDefault());
		if (listaCompras.get(posicaoItem) == null) {
			return "";
		}
		return listaCompras.get(posicaoItem).toString();
	}
	
	public Item pegaItemLista(int itemId) {
		return this.compras.get(itemId).getItem();
	}
	
	public Compra pegaCompra(int itemId) {
		return this.compras.get(itemId);
	}

	@Override
	public String toString() {
		return this.descricao + " - " + this.data;
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

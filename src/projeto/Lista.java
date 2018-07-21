package projeto;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Lista {
	private HashMap<Integer, Compra> compras;
	private LocalDateTime data;
	private String descricao;
	private String localDaCompra;
	private double valorFinalCompra;

	public Lista(String descricao) {
		setDescricao(descricao);
		this.data = LocalDateTime.now();
	}

	public String getLocaDaCompra() {
		return localDaCompra;
	}

	public void setLocaDaCompra(String localDaCompra) {
		if (localDaCompra.trim().isEmpty() || localDaCompra == null) {
			throw new IllegalArgumentException("local nao pode ser vazio ou nulo.");
		}
		this.localDaCompra = localDaCompra;
	}

	public double getValorFinalCompra() {
		return valorFinalCompra;
	}

	public void setValorFinalCompra(double valorFinalCompra) {
		if (valorFinalCompra <= 0) {
			throw new IllegalArgumentException("valor final da lista invalido.");
		}
		this.valorFinalCompra = valorFinalCompra;
	}

	public HashMap<Integer, Compra> getcompras() {
		return compras;
	}

	public LocalDateTime getData() {
		return data;
	}

	private void setDescricao(String novaDescricao) {
		if (novaDescricao.trim().isEmpty() || novaDescricao == null) {
			throw new IllegalArgumentException("descritor nao pode ser vazio ou nulo.");
		}
		this.descricao = novaDescricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void adicionarCompra(int quantidade, Item item) {
		Compra compra = new Compra(quantidade, item);
		this.compras.put(item.getId(), compra);
	}

	public String pesquisaCompra(int idNumerico) {
		Compra compra = this.compras.get(idNumerico);
		if (compra == null) {
			throw new NullPointerException("compra nao encontrada na lista.");
		}
		return compra.toString();
	}

	public String retornaCompra(int posicaoItem) {
		return compras.get(posicaoItem).toString();
	}

	@Override
	public String toString() {
		return descricao + data;
	}
}

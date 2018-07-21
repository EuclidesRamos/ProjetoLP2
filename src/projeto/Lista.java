package projeto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Lista {

	private String descritor;
	private List<Compra> compras;
	private LocalDateTime dataHora;
	private String LocalDeCompra;
	private int valorFinalDaCompra;

	public Lista(String descritor) {
		this.descritor = descritor;
		this.compras = new ArrayList<>();
		this.dataHora = LocalDateTime.now();
	}

	// private Compra procuraCompra(Item pegaItem) {
	// for (int i = 0; i < compras.length; i++) {
	//
	// }
	// return null;
	// }

	public void adicionaCompraALista(int quantidade, Item item) {
		compras.add(new Compra(quantidade, item));
	}

	public Item pegaItemLista(int itemId) {
		// Pega a compra que tem o valor assiciado a chave (passada como paramentro).
		return null;
	}

	public void atualizaCompraDeLista(int itemId, int quantidade, String operacao) {
		// pegaCompra.get(pegaCompra).atualizaCompra();
	}

	public void finalizarListaDeCompras(String localDeCompra, int valorFinalDaCompra) {

	}

	public void deletaCompraDeLista(int idItem) {
		// deleta pela chave.

	}

	public String getDescritor() {
		return this.descritor;
	}

	public String getDataHora() {
		return this.dataHora + "";
	}

	public String getCompra(int itemId) {
		// retorna o toString da compra que esta associado a chava que foi passada como parametro.
		return null;
	}

	@Override
	public String toString() {
		// Data e o descritor.
		return null;
	}

	public String getItemLista(int posicaoItem) {
		// retorna o toString da compra que esta na posicao passada no parametro.
		return null;
	}
}

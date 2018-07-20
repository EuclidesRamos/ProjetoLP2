package projeto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Lista {

	private String descritor;
	private Set<Compra> compras;
	private LocalDateTime dataHora;
	private String LocalDeCompra;
	private int valorFinalDaCompra;
	private String estado;
	private boolean ocorreu;

	public Lista(String descritor) {
		this.descritor = descritor;
		this.compras = new HashSet<>();
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

	public String pegaItemLista(int id) {
		return null;
	}

	public void atualizaCompraDeLista(Item pegaItem, int quantidade, String operacao) {
		// pegaCompra.get(pegaCompra).atualizaCompra();
	}

	public void finalizarListaDeCompras(String localDeCompra, int valorFinalDaCompra) {
		if (this.estado.startsWith("Finalizado"))
			throw new UnsupportedOperationException("Mensagem de erro a ser dada.");
		this.ocorreu = ocorreu;
		if (ocorreu)
			this.estado = "Finalizado (ocorreu)";
		else
			this.estado = "Finalizado (n ocorreu)";
	}

	public void deletaCompraDeLista(Item pegaItem) {

	}

	@Override
	public String toString() {
		return this.descritor + dataHora;
	}

	public String getDescritor() {
		return descritor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

}

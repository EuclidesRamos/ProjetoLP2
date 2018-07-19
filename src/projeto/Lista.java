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
	
	public Lista(String descritor) {
		this.descritor = descritor;
		this.compras = new HashSet<>();
		this.dataHora = LocalDateTime.now();
	}

	public void adicionaCompra(int quantidade, Item item) {
		
	}
	
	@Override
	public String toString() {
		return null;
	}

	public String pegaItemLista(Item pegaItem) {
		return null;
	}

	public void atualizaCompra(Item pegaItem, int quantidade, String operacao) {
		
	}

	public void finalizaLista(String localDeCompra, int valorFinalDaCompra) {
		
	}

	public void deletaCompra(Item pegaItem) {
		
	}
	
	
	
	

}

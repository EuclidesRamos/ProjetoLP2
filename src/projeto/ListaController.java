package projeto;

import java.util.HashMap;
import java.util.Map;

public class ListaController {
	
	private Map<String, Lista> listas;
	
	public ListaController() {
		this.listas = new HashMap<>();
	}
	
	public void adicionaListaDeCompras(String descritor) {
		Lista lista = new Lista(descritor);
		this.listas.put(descritor, lista);
	}
	
	public String pesquisaListaDeCompras(String descritor) {
		return this.listas.get(descritor).toString();
	}
	
	public void adicionaCompraALista(int quantidade, int idItem) {
		
	}

}

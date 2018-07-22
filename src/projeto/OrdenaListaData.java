package projeto;

import java.util.Comparator;

/**
 * Classe responsavel por comparar duas Listas pela data.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class OrdenaListaData implements Comparator<Lista> {
	
	/**
	 * Metodo que compara os itens do tipo Lista pela data da compra. Se forem comprados na mesma data, compara lexicograficamente.
	 */
	public int compare(Lista lista1, Lista lista2) {
		if (lista1.getData().equals(lista2.getData())) {
			return lista1.getDescricao().toLowerCase().compareTo(lista2.getDescricao().toLowerCase());
		}
		return lista1.getData().compareTo(lista2.getData());
	}

}

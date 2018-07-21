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
	public int compare(Lista o1, Lista o2) {
		if (o1.getData() == o2.getData()) {
			return o1.getDescricao().compareTo(o2.getDescricao());
		}
		return o1.getData().compareTo(o2.getData());
	}

}

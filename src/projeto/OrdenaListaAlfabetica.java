package projeto;

import java.util.Comparator;

public class OrdenaListaAlfabetica implements Comparator<Lista> {
	
	/**
	 * Método que compara os itens lexicograficamente.
	 * @param dois itens
	 * @return os itens ordenados.
	 */
	public int compare(Lista o1, Lista o2) {
		return o1.getDescritor().compareTo(o2.getDescritor());
}}

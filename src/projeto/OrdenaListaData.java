package projeto;

import java.util.Comparator;


public class OrdenaListaData implements Comparator<Lista> {
	
	/**
	 * Método que ordena os itens pela data da compra, se forem comprados na mesma data, comapra lexicograficamente.
	 * @param dois itens.
	 * @return os itens ordenados.
	 */
	
	public int compare(Lista o1, Lista o2) {
		if (o1.getDataHora() == o2.getDataHora()) {
			return o1.getDescritor().compareTo(o2.getDescritor());
		}
		return o1.getDataHora().compareTo(o2.getDataHora());
	}

}

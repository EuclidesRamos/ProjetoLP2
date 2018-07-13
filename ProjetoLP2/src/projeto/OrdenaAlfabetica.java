package projeto;

import java.util.Comparator;

/**
 * Sobrescrita do Comparator de Ordem Alfabetica.
 * 
 */
public class OrdenaAlfabetica implements Comparator <Item> {
	/**
	 * Compara o nome de dois itens distintos.
	 * @return um inteiro
	 */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}
}

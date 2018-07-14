package projeto;

import java.util.Comparator;

/**
 * Sobrescrita do Comparator de ordem crescente do preço.
 *
 */
public class OrdenaPreco implements Comparator<Item> {
	
	@Override
	public int compare(Item item1, Item item2) {
		if (item1.menorPreco() < item2.menorPreco()) {
			return -1;
		} else {
			return 1;			
		}
	}
}

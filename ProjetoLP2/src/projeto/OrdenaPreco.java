package projeto;

import java.util.Comparator;

/**
 * Sobrescrita do Comparator de ordem crescente do preço.
 *
 */
public class OrdenaPreco implements Comparator <Item> {
	/**
	 * Compara o preço de dois itens distintos.
	 * @return um inteiro.
	 */
	
	@Override
	public int compare(Item item1, Item item2) {
		return (int) (item1.menorPreco() - item2.menorPreco());
			
		}
}

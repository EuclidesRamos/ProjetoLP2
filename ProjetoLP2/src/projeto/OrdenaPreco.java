package projeto;

import java.util.Comparator;

/**
 * Sobrescrita do Comparator de ordem crescente do preço.
 *
 */
public class OrdenaPreco implements Comparator <Item> {
	/**
	 * Compara o preço de dois itens distintos.
	 * @return Retorna um inteiro.
	 */
	
	@Override
	public int compare(Item arg0, Item arg1) {
		return (int) (arg0.menorPreco() - arg1.menorPreco());
			
		}
}

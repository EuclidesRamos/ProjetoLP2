package projeto;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Sobrescrita do Comparator de ordem crescente do preco.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class OrdenaPreco implements Comparator<Item>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6510244646388532216L;

	/**
	 * Compara o preco de dois itens distintos.
	 * 
	 */
	@Override
	public int compare(Item item1, Item item2) {
		if (item1.menorPreco() < item2.menorPreco()) {
			return -1;
		} else {
			return 1;	
		}
	}
}

package projeto;

import java.util.Comparator;

/**
 * Classe responsavel por comparar dois itens pelo nome.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 * 
 */
public class OrdenaAlfabetica implements Comparator<Item> {
	
	/**
	 * Compara o nome de dois itens distintos.
	 * 
	 */
	@Override
	public int compare(Item item1, Item item2) {
		return item1.getNome().compareTo(item2.getNome());
	}
}

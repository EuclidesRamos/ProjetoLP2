package projeto;

import java.util.Comparator;

/**
 * Sobrescrita do Comparator de Ordem Alfabetica.
 * 
 */
public class OrdenaAlfabetica implements Comparator <Item> {
	
	@Override
	public int compare(Item arg0, Item arg1) {
		return arg0.getNome().compareTo(arg1.getNome());
	}
}

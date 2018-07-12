package projeto;

import java.util.Comparator;

/**
 * 
 * @author Grupo LP2 Sobrescrita do Comparator
 *
 */
public class OrdenaPelaCategoria implements Comparator<Item> {

	@Override
	public int compare(Item arg0, Item arg1) {
		return arg0.getCategoria().compareTo(arg1.getCategoria());
	}
}
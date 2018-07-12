package projeto;

import java.util.Comparator;

public class OrdenaPreco implements Comparator <Item> {
	
	@Override
	public int compare(Item arg0, Item arg1) {
		return (int) (arg0.menorPreco() - arg1.menorPreco());
			
		}
}

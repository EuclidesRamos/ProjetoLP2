package projeto;

import java.util.Comparator;

public class OrdenacaoDefault implements Comparator<Compra> {

	@Override
	public int compare(Compra compra1, Compra compra2) {
		if (compra1.getItem().getPrecedencia() == compra2.getItem().getPrecedencia()) {
			return compra1.getItem().getNome().compareTo(compra2.getItem().getNome());
		}
		return compra1.getItem().getPrecedencia() - compra2.getItem().getPrecedencia();
	}

}

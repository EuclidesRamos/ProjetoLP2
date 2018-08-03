package projeto;

import java.util.Comparator;

public class OrdenaSupermercadosPeloValor implements Comparator<Supermercado> {

	@Override
	public int compare(Supermercado supermercado1, Supermercado supermercado2) {
		if (supermercado1.getValorCompras() > supermercado2.getValorCompras()) {
			return 1;
		}
		return -1;
	}

}

package projeto;

import java.util.Comparator;

/**
 * Classe Abstrata que representa um item no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 * 
 */
public class OrdenaSupermercadosPeloValor implements Comparator<Supermercado> {
	
	/**
	 * Compara o preco das compras em dois Supermercados.
	 */
	@Override
	public int compare(Supermercado supermercado1, Supermercado supermercado2) {
		if (supermercado1.getValorCompras() > supermercado2.getValorCompras()) {
			return 1;
		}
		return -1;
	}

}

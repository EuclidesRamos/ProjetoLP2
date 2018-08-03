package projeto;

import java.io.Serializable;
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
public class OrdenacaoDefault implements Comparator<Compra>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6865603154931787509L;

	/**
	 * Metodo que compara duas compras.
	 */
	@Override
	public int compare(Compra compra1, Compra compra2) {
		if (compra1 == null) {
			return 1;
		} else if (compra2 == null) {
			return -1;
		}
		if (compra1.getItem().getPrecedencia() == compra2.getItem().getPrecedencia()) {
			return compra1.getItem().getNome().compareTo(compra2.getItem().getNome());
		}
		return compra1.getItem().getPrecedencia() - compra2.getItem().getPrecedencia();
	}

}

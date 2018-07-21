package projeto;

import java.util.Comparator;

/**
 * Classe responsavel por comparar duas listas pela descricao.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class OrdenaListaAlfabetica implements Comparator<Lista> {
	
	/**
	 * Metodo que compara dois objetos do tipo Lista lexicograficamente.
	 */
	public int compare(Lista o1, Lista o2) {
		return o1.getDescricao().compareTo(o2.getDescricao());
}}

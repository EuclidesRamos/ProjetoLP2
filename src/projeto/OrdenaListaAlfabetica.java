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
	public int compare(Lista lista1, Lista lista2) {
		return lista1.getDescricao().toLowerCase().compareTo(lista2.getDescricao().toLowerCase());
}}

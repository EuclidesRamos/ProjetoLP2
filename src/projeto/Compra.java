package projeto;

import java.io.Serializable;

/**
 * 
 * Classe responsavel por representar uma Compra no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 */
public class Compra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 677402145184145021L;

	/**
	 * Quantidade de itens
	 */
	private int quantidade;

	/**
	 * Item adicionado a compra
	 */
	private Item item;

	private Validador validador;

	/**
	 * Constroi uma compra a partir do item e a quantidade de itens.
	 * 
	 * @param quantidade Quantidade de itens
	 * @param item       Item
	 */
	public Compra(int quantidade, Item item) {
		this.validador = new Validador();
		this.validador.validaCompra(quantidade, item);
		this.quantidade = quantidade;
		this.item = item;
	}

	/**
	 * Metodo que atualiza a quantidade de itens em uma compra.
	 * 
	 * @param operacao   Operacao "aumenta" ou "diminui"
	 * @param quantidade Quantidade a ser aumentada ou diminuida
	 */
	public void atualizaCompra(String operacao, int quantidade) {
		this.validador.validaAtualizaCompraDeLista(operacao);

		switch (operacao) {
		case "diminui":
			this.quantidade -= quantidade;
			break;
		case "adiciona":
			this.quantidade += quantidade;
			break;
		}
	}

	/**
	 * Metodo que retorna o item associado a compra.
	 * 
	 * @return o Item
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * Metodo que retorna a quantidade de itens da compra.
	 * 
	 * @return a quantidade de itens
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Metodo que retorna a representacao textual da compra
	 * 
	 * @return uma String
	 */
	@Override
	public String toString() {
		return this.quantidade + " " + this.item.representacaoLista();
	}
}

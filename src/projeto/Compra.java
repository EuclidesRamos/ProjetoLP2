package projeto;

/**
 * 
 * Classe responsavel por representar uma Compra no sistema.
 * 
 * @author Eduardo Pereira - 117210342
 *
 */
public class Compra {
	
	/**
	 * Quantidade de itens
	 */
	private int quantidade;
	
	/**
	 * Item adicionado a compra
	 */
	private Item item;

	/**
	 * Constroi uma compra a partir do item e a quantidade de itens.
	 * 
	 * @param quantidade Quantidade de itens
	 * @param item       Item
	 */
	public Compra(int quantidade, Item item) {
		this.quantidade = quantidade;
		this.item = item;
	}

	/**
	 * Atualiza a quantidade de itens em uma compra.
	 * 
	 * @param operacao   Operacao "aumenta" ou "diminui"
	 * @param quantidade Quantidade a ser aumentada ou diminuida
	 */
	public void atualizaCompra(String operacao, int quantidade) {
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
	 * Retorna o item pertencente a compra.
	 * 
	 * @return o Item
	 */
	public Item getItem() {
		return this.item;
	}

	/**
	 * Retorna a quantidade de itens da compra.
	 * 
	 * @return a quantidade de itens
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Retorna a representacao textual da compra
	 * 
	 * @return uma String
	 */
	@Override
	public String toString() {
		return this.quantidade + " " + this.item.representacaoLista();
	}
}

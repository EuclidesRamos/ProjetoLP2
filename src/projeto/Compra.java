package projeto;

/**
 * 
 * Classe responsável por representar uma Compra no sistema.
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
	 * Validador de entradas
	 */
	private Validador valida;

	/**
	 * Constroi uma compra a partir do item e a quantidade de itens.
	 * 
	 * @param quantidade Quantidade de itens
	 * @param item       Item
	 */
	public Compra(int quantidade, Item item) {
		this.valida = new Validador();
		valida.validaCompra(quantidade, item);
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
		case "aumenta":
			this.quantidade += quantidade;
			break;
		default:
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");

		}

	}

	/**
	 * Retorna o item pertencente a compra.
	 * 
	 * @return o Item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * Retorna a quantidade de itens da compra.
	 * 
	 * @return a quantidade de itens
	 */
	public int getQuantidade() {
		return quantidade;
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

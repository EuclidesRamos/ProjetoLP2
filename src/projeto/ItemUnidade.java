package projeto;

/**
 * Representa um item por unidade no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */

public class ItemUnidade extends Item {
	/**
	 * Quantidade de unidades de um item.
	 */
	private int unidade;

	/**
	 * Constroi um item por unidade a partir de seu id, nome, categoria, quantidade
	 * de unidades, local de compra e preco.
	 * 
	 * @param id
	 *            Identificacao do item
	 * @param nome
	 *            Nome do item
	 * @param categoria
	 *            Categoria do item
	 * @param unidade
	 *            Quantidade de Unidades
	 * @param localDeCompra
	 *            Local de compra
	 * @param preco
	 *            Preco do item
	 */
	public ItemUnidade(int id, String nome, String categoria, int unidade, String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		super.validador.validaItemUnidade(nome, categoria, unidade, localDeCompra, preco);
		this.unidade = unidade;
	}

	/**
	 * Retorna a quantidade de unidades de um item por unidade.
	 * 
	 * @return um inteiro representando a quantidade de unidades
	 */
	public int getUnidade() {
		return unidade;
	}

	/**
	 * Retorna uma representacao textual do item.
	 * 
	 * @return uma String representado o item
	 */
	@Override
	public String toString() {
		return super.toString() + "Preco: " + "<" + super.precos() + ">";
	}

	/**
	 * Atualiza o item a partir do nome do atrinuto e o valor a ser atualizado.
	 */
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		super.atualizaItem(atributo, novoValor);

		switch (atributo) {

		case "unidades":
			int novoValorInteiro = Integer.parseInt(novoValor);
			this.unidade = novoValorInteiro;
			break;
		}

	}
}
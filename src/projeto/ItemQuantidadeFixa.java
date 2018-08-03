package projeto;

/**
 * Representa um item por quantidade fixa no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */

public class ItemQuantidadeFixa extends Item {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7229045156139586108L;

	/**
	 * Quantidade de itens.
	 */
	private int quantidade;

	/**
	 * Unidade de medida.
	 */
	private String unidadeDeMedida;

	/**
	 * Constroi um item por quantidade fixa a partir de seu id, nome, categoria,
	 * quantidade, unidade de medida, local de compra e preco.
	 * 
	 * @param id Identificacao do item
	 * @param nome Nome do item
	 * @param categoria Categoria do item
	 * @param quantidade Quantidade de itens
	 * @param unidadeDeMedida Unidade de medida
	 * @param localDeCompra Local de compra
	 * @param preco Preco do item
	 */
	public ItemQuantidadeFixa(int id, String nome, String categoria, int quantidade, String unidadeDeMedida,
			String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		super.validador.validaItemQuantidadeFixa(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		this.quantidade = quantidade;
		this.unidadeDeMedida = unidadeDeMedida;

	}

	/**
	 * Retorna a quantidade itens.
	 * 
	 * @return um inteiro representando a quantidade itens
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * Retorna a unidade de medida do item.
	 * 
	 * @return uma String representando a unidade de medida
	 */
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}

	/**
	 * Retorna uma representacao textual do item.
	 * 
	 * @return uma String representado o item
	 */
	@Override
	public String toString() {
		return super.toString() + this.quantidade + " " + this.unidadeDeMedida + ", Preco: " + "<" + super.precos()
				+ ">";
	}
	
	@Override
	public String representacaoLista() {
		return super.representacaoLista() + ", " + this.quantidade + " " + this.unidadeDeMedida;
		
	}

	/**
	 * Atualiza o item a partir do nome do atrinuto e o valor a ser atualizado.
	 */
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		super.atualizaItem(atributo, novoValor);
		switch (atributo) {

		case "quantidade":
			int novoValorInteiro = Integer.parseInt(novoValor);
			this.quantidade = novoValorInteiro;
			break;
		case "unidade de medida":
			this.unidadeDeMedida = novoValor;
			break;

		}

	}
}
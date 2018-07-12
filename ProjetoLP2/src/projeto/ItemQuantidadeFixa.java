package projeto;

public class ItemQuantidadeFixa extends Item {

	/**
	 * Quantidade de itens.
	 */
	private int quantidade;
	/**
	 * Unidade de medida.
	 */
	private String unidadeDeMedida;

	public ItemQuantidadeFixa(int id, String nome, String categoria, int quantidade, String unidadeDeMedida,
			String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		super.validador.validaItemQuantidadeFixa(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		this.quantidade = quantidade;
		this.unidadeDeMedida = unidadeDeMedida;

	}


	@Override
	public String toString() {
		return super.toString() + this.quantidade + " " + this.unidadeDeMedida + ", Preco: " + "<" + super.precos()
				+ ">";
	}

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
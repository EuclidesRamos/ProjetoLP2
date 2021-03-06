package projeto;

/**
 * Representa um item por quilo no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class ItemQuilo extends Item {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8192038426325404284L;
	
	/**
	 * Quantidade de quilos de um item.
	 */
	private double kg;

	/**
	 * Constroi um item por quilo a partir de seu id, nome, categoria, quantidade de
	 * quilos, local de compra e preco.
	 * 
	 * @param id             Identificacao do item
	 * @param nome           Nome do item
	 * @param categoria      Categoria do item
	 * @param kg             Quantidade de quilos
	 * @param localDeCompra  Local de compra
	 * @param preco          Preco do item
	 */
	public ItemQuilo(int id, String nome, String categoria, double kg, String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		super.validador.validaItemQuilo(nome, categoria, kg, localDeCompra, preco);
		this.kg = kg;
	}

	/**
	 * Retorna a quantidade de quilos de um item por quilo.
	 * 
	 * @return um inteiro representando a quantidade de unidades
	 */
	public double getKg() {
		return kg;
	}

	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna uma representacao em String do item.
	 */
	@Override
	public String toString() {
		return super.toString() + "Preco por quilo: " + "<" + super.precos() + ">";
	}

	/**
	 * Metodo que sobrescreve o metodo da classe pai.
	 */
	@Override
	public void atualizaItem(String atributo, String novoValor) {
		super.atualizaItem(atributo, novoValor);
		switch (atributo) {
		case "kg":
			double novoValorDouble = Double.parseDouble(novoValor);
			this.kg = novoValorDouble;
			break;
		}
	}
}
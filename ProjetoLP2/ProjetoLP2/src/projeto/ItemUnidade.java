package projeto;

public class ItemUnidade extends Item {

	private int unidade;

	public ItemUnidade(int id, String nome, String categoria, int unidade, String mercado, double preco) {
		super(id,nome,categoria,mercado,preco);
		super.validador.validaItemUnidade(nome, categoria, unidade, mercado, preco);
		this.unidade = unidade;
	}
	
	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return super.toString() + "Preco: " + "<" + super.precos() + ">";
	}
}

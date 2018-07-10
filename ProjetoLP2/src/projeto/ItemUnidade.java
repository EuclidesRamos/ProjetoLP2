package projeto;

public class ItemUnidade extends Item {

	private int unidade;

	public ItemUnidade(int id, String nome, String categoria, int unidade, String mercado, double preco) {
		super(id,nome,categoria,mercado,preco);

		if (unidade < 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: valor de unidade nao pode ser menor que zero.");
		}
		this.unidade = unidade;
	}

	@Override
	public String toString() {
		return super.toString() + "Preco: " + "<" + super.precos() + ">";
	}
	
	public int getUnidade() {
		return unidade;
	}

	public void setUnidadeDeMedida(int unidade) {
		this.unidade = unidade;
	}

}

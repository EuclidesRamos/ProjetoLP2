package projeto;

public class ItemQuantidadeFixa extends Item {
	
	private int quantidade;
	private String unidadeDeMedida;

	public ItemQuantidadeFixa(int id, String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		super(id,nome,categoria,localDeCompra,preco);
		super.validador.validaItemQuantidadeFixa(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		this.quantidade = quantidade;
		this.unidadeDeMedida = unidadeDeMedida;
		
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	@Override
	public String toString() {
		return super.toString() + this.quantidade + " " + this.unidadeDeMedida +  ", Preco: " + "<" + super.precos() + ">";
	}
}

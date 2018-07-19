package projeto;

public class Compra {

	private int quantidade;
	private Item item;
	private Validador valida;

	public Compra(int quantidade, Item item) {
		this.valida = new Validador();
		valida.validaCompra(quantidade, item);
		this.quantidade = quantidade;
		this.item = item;
	}

	public void atualizaQuantidade(String operacao, int quantidade) {

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


	public Item getItem() {
		return item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	@Override
	public String toString() {
		return this.quantidade + " " + this.item.representacaoLista();
	}

}

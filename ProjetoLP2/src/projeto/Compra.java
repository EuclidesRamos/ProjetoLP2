package projeto;

public class Compra {
	
	private Object quantidade;
	private Item item;

	public Compra(int quantidade, Item item) {
		this.quantidade = quantidade;
		this.item = item;
	}
	
	public Compra(double quantidade, Item item) {
		this.quantidade = quantidade;
		this.item = item;
	}

}

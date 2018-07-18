package projeto;

public class Compra {
	
	private int quantidade;
	private Item item;

	public Compra(int quantidade, Item item) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade nao pode ser menor ou igual a zero.");

		}
		if(item == null) {
			throw new NullPointerException("Item nao pode ser nulo.");
		}
		this.quantidade = quantidade;
		this.item = item;
	}
	
	public void adicionaQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public void removeQuantidade(int quantidade) {
		this.quantidade -= quantidade;
		
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

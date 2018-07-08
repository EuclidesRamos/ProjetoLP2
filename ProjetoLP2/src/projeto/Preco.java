package projeto;

public class Preco {
	
	private String mercado;
	private double preco;
	
	public Preco(String mercado, double valor) {
		this.mercado = mercado;
		this.preco = valor;
	}

	@Override
	public String toString() {
		return this.mercado + ", R$ " + this.preco;
	}

	public double getPreco() {
		return preco;
	}

	


}

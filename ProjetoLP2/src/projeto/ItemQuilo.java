package projeto;

public class ItemQuilo extends Item {

	private double kg;

	public ItemQuilo(int id, String nome, String categoria, double kg, String localDeCompra, double preco) {
		super(id, nome, categoria, localDeCompra, preco);
		super.validador.validaItemQuilo(nome, categoria, kg, localDeCompra, preco);
		this.kg = kg;
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

	@Override
	public String toString() {
		return super.toString() + "Preco por quilo: " + "<" + super.precos() + ">";
	}

}

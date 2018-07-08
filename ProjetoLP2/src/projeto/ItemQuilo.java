package projeto;

import java.util.HashMap;

public class ItemQuilo extends Item {

	private double kg;

	public ItemQuilo(int id, String nome, String categoria, double kg, String mercado, double preco) {

		super.valida(nome, categoria, mercado, preco);
		if (kg < 0) {
			throw new IllegalArgumentException(
					"Erro no cadastro de item: valor de quilos nao pode ser menor que zero.");
		}
		this.kg = kg;
		this.mapaDePrecos = new HashMap<>();
		this.categoria = categoria;
		this.id = id;
		this.nome = nome;
		this.mapaDePrecos.put(mercado, preco);
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

	@Override
	public String toString() {
		return this.id + ". " + this.nome + "," + this.categoria + ", Preco por quilo: " + "<" + super.precos() + ">";
	}

}

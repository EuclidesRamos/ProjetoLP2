package projeto;

import java.util.ArrayList;

public class ItemQuilo extends Item {

	private double kg;

	public ItemQuilo(int id, String nome, String categoria, double kg, String mercado, double valor) {
		this.kg = kg;
		this.mapadeprecos = new ArrayList<>();
		this.categoria = categoria;
		this.id = id;
		this.nome = nome;
		Preco preco = new Preco(mercado, valor);
		this.mapadeprecos.add(preco);
	}


	
	
	

	public double getKg() {
		return kg;
	}






	public void setKg(double kg) {
		this.kg = kg;
	}






	@Override
	public String toString() {
		return this.id + ". " + this.nome + "," +  this.categoria + ", Preco por quilo: " + "<" + super.precos() + ">";
	}

}

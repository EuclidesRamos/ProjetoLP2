package projeto;

import java.util.ArrayList;

public class ItemUnidade extends Item {

	private int unidade;

	public int getUnidade() {
		return unidade;
	}

	public void setUnidade(int unidade) {
		this.unidade = unidade;
	}

	public ItemUnidade(int id, String nome, String categoria, int unidade, String mercado, double valor) {
		this.unidade = unidade;
		this.mapadeprecos = new ArrayList<>();
		this.categoria = categoria;
		this.id = id;
		this.nome = nome;
		Preco preco = new Preco(mercado, valor);
		this.mapadeprecos.add(preco);
	}

	@Override
	public String toString() {
		return this.id + ". " + this.nome + " ," +  this.categoria + ", Preco: " + "<" + super.precos() + ">";
	}

}

package projeto;

import java.util.ArrayList;

public class ItemQuantidadeFixa extends Item {
	
	
	private int quantidade;
	private  String unidadeMedida;

	@Override
	public String toString() {
		return this.id + ". " + this.nome + ", " +  this.categoria +", " + this.quantidade + " " + this.unidadeMedida +  ", Preco: " + "<" + super.precos() + ">";
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public ItemQuantidadeFixa(int id, String nome,String categoria, int quantidade, String unidadeMedida,String mercado,double valor) {
		this.mapadeprecos = new ArrayList<>();
		this.categoria = categoria;
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		Preco preco = new Preco(mercado,valor);
		this.mapadeprecos.add(preco);
	}

}

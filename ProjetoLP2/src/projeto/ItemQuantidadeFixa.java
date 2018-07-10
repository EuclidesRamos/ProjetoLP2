package projeto;


import java.util.HashMap;

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

	public ItemQuantidadeFixa(int id, String nome,String categoria, int quantidade, String unidadeMedida,String mercado,double preco) {

		super.valida(nome, categoria, mercado, preco);
		if (unidadeMedida.trim().isEmpty()|| unidadeMedida == null) {
			throw new IllegalArgumentException("Erro no cadastro de item: unidade de medida nao pode vazia ou nula.");
			
		}
		if(quantidade < 0) {
			 throw  new IllegalArgumentException("Erro no cadastro de item: valor de quantidade nao pode ser menor que zero.");
		}
		this.mapaDePrecos = new HashMap<>();
		this.categoria = categoria;
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.mapaDePrecos.put(mercado, preco);
	}
}

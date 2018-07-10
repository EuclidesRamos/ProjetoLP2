package projeto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Item {

	protected Map<String, Double> mapaDePrecos;
	protected int id;
	protected String nome;
	protected String categoria;

	public Item(int id, String nome, String categoria, String mercado, double preco) {
		if (categoria.trim().isEmpty() || categoria == null) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		} else if (!(categoria.equals("alimento industrializado") || categoria.equals("alimento nao industrializado")
				|| categoria.equals("limpeza") || categoria.equals("higiene pessoal"))) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao existe.");
		} else if (nome.trim().isEmpty() || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro de item: nome nao pode ser vazio ou nulo.");
		} else if (mercado.trim().isEmpty() || mercado == null) {
			throw new IllegalArgumentException("Erro no cadastro de item: local de compra nao pode ser vazio ou nulo.");
		} else if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro de item: preco de item invalido.");
		}
		this.mapaDePrecos = new HashMap<>();
		this.mapaDePrecos.put(mercado, preco);
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void cadastraPreco(String mercado, double valor) {

		if (mercado.trim().isEmpty() || mercado == null) {
			throw new IllegalArgumentException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		}
		if (valor < 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		}

		this.mapaDePrecos.put(mercado, valor);

	}

	public String precos() {
		String precos = "";
		for (Entry<String, Double> preco : this.mapaDePrecos.entrySet()) {
			precos += preco.getKey() + ", R$ " + String.format("%.2f", preco.getValue()) + ";";
		}
		return precos;
	}

	public double menorPreco() {
		double menorPreco = Double.POSITIVE_INFINITY;
		for (Double preco : this.mapaDePrecos.values()) {
			if (preco < menorPreco) {
				menorPreco = preco;
			}
		}

		return menorPreco;

	}
	
	public void adicionaPrecoItem(String localDeCompra, double preco) {
		this.mapaDePrecos.put(localDeCompra, preco);
	}

	public String toString() {
		return this.id + ". " + this.nome + ", " +  this.categoria + ", ";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setQuantidade(int quantidade) {	
		
	}
	
	public void setUnidadeDeMedida(String unidadeMedida) {
		
	}

	public void setKg(double kg) {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}

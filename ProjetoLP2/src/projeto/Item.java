package projeto;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Item {

	protected Map<String, Double> mapaDePrecos;
	protected int id;
	protected String nome;
	protected String categoria;

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	public Item(int id, String nome, String categoria, String mercado, double preco) {
		valida(nome, categoria, mercado, preco);

		this.mapaDePrecos = new HashMap<>();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void cadastraPreco(String mercado, double valor) {

		if (mercado.trim().isEmpty() || mercado == null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		}
		if (valor < 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		}

		this.mapaDePrecos.put(mercado, valor);

	}

	public String precos() {
		int controle = 0;
		String precos = "";
		for (Entry<String, Double> preco : this.mapaDePrecos.entrySet()) {
			controle++;
			if (controle == 1) {
				precos += preco.getKey() + ", R$ " + String.format("%.2f", preco.getValue());
			} else {
				precos += "; " + preco.getKey() + ", R$ " + String.format("%.2f", preco.getValue());
			}
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

	public void valida(String nome, String categoria, String mercado, double preco) {

		if (categoria.trim().isEmpty() || categoria == null) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao pode ser vazia ou nula.");
		}

		if (!(categoria.equals("alimento industrializado") || categoria.equals("alimento nao industrializado")
				|| categoria.equals("limpeza") || categoria.equals("higiene pessoal"))) {
			throw new IllegalArgumentException("Erro no cadastro de item: categoria nao existe.");
		}
		if (nome.trim().isEmpty() || nome == null) {
			throw new IllegalArgumentException("Erro no cadastro do item: nome nao pode ser vazio ou nulo.");
		}

		if (mercado.trim().isEmpty() || mercado == null) {
			throw new IllegalArgumentException("Erro no cadastro do item: local de compra nao pode ser vazio ou nulo.");
		}
		if (preco < 0) {
			throw new IllegalArgumentException("Erro no cadastro do item: preco de item invalido.");
		}

	}

	public abstract String toString();

	public void setQuantidade(int quantidade) {	
		
	}
	
	public void setUnidadeDeMedida(String unidadeMedida) {
		
	}

	public void setKg(double kg) {
		
	}

	public void adicionaPrecoItem(String localDeCompra, double preco) {
		this.mapaDePrecos.put(localDeCompra, preco);
	}
}

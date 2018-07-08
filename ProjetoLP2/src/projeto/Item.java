package projeto;

import java.util.List;

public abstract class Item {

	protected List<Preco> mapadeprecos;
	protected int id;
	protected String nome;
	protected String categoria;

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
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

	public void adicionaPreco(String mercado, double valor) {
		Preco preco = new Preco(mercado, valor);
		this.mapadeprecos.add(preco);

	}

	public String precos() {
		String precos = "";
		for (int i = 0; i < this.mapadeprecos.size(); i++) {
			if (i == 0) {
				precos += this.mapadeprecos.get(i).toString();
			} else {
				precos += "; " + this.mapadeprecos.get(i).toString();
			}
		}

		return precos;
	}

	public double menorPreco() {
		double menorPreco = this.mapadeprecos.get(0).getPreco();
		for (Preco preco : this.mapadeprecos) {
			if (preco.getPreco() < menorPreco) {
				menorPreco = preco.getPreco();
			}
		}

		return menorPreco;

	}

	public abstract String toString();

}

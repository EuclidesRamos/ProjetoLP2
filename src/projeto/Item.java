package projeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Classe Abstrata que representa um item no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 * 
 */
public abstract class Item {

	/**
	 * Mapa de precos de um item.
	 */
	private Map<String, Double> mapaDePrecos;

	/**
	 * Identificacao do item.
	 */
	private int id;

	/**
	 * Nome do item.
	 */
	private String nome;

	/**
	 * Categoria do item
	 */
	private Categoria categoria;
	
	/**
	 * Validador de entradas.
	 */
	protected Validador validador;
	
	/**
	 *
	 * Constroi um item a partir do seu id, nome, categoria, local de compra e
	 * preco.
	 *
	 * @param id            Identificacao do item
	 * @param nome          Nome do item
	 * @param categoria     Categoria do item
	 * @param localDeCompra Local onde foi comprado o item
	 * @param preco         Preco do item
	 * @param precedencia   Precedencia para ordenacao ()
	 */
	public Item(int id, String nome, String categoria, String localDeCompra, double preco) {
		this.validador = new Validador();
		this.mapaDePrecos = new HashMap<>();
		this.mapaDePrecos.put(localDeCompra, preco);
		this.id = id;
		this.nome = nome;
		this.categoria = new Categoria(categoria);
	}

	/**
	 * Retorna a identificacao do item.
	 * 
	 * @return um inteiro que representa o id do item
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Retorna o nome do item.
	 * 
	 * @return uma String representando o nome do item
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Retorna a categoria do item.
	 * 
	 * @return uma String representando a categoria do item
	 */
	public String getCategoria() {
		return this.categoria.getCategoria();
	}

	/**
	 * Cadastra um novo preco para o item. A partir do local de compra e o valor do
	 * item.
	 * 
	 * @param localDeCompra Local de compra
	 * @param valor         Valor do item
	 */
	public void adicionaPrecoItem(String localDeCompra, double valor) {
		this.validador.validaAdicionaPrecoItem(localDeCompra, valor);
		if (localDeCompra == null) {
			throw new NullPointerException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		}
		if (localDeCompra.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		}
		if (valor < 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		}
		this.mapaDePrecos.put(localDeCompra, valor);
	}

	/**
	 * Retorna uma representacao textual dos precos cadastrados para o item.
	 * 
	 * @return uma String com os precos do item
	 */
	public String precos() {
		String precos = "";
		for (Entry<String, Double> preco : this.mapaDePrecos.entrySet()) {
			precos += preco.getKey() + ", R$ " + String.format("%.2f", preco.getValue()) + ";";
		}
		return precos;
	}

	/**
	 * Retorna o menor preco cadastrado para o item
	 * 
	 * @return um double do menor preco
	 */
	public double menorPreco() {
		double menorPreco = Double.POSITIVE_INFINITY;
		for (Double preco : this.mapaDePrecos.values()) {
			if (preco < menorPreco) {
				menorPreco = preco;
			}
		}
		return menorPreco;
	}

	/**
	 * Retorna uma representacao textual do item.
	 * 
	 * @return uma String
	 */
	public String toString() {
		return this.id + ". " + this.nome + ", " + this.categoria.getCategoria() + ", ";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	/**
	 * Retorna a representacao do Item na lista
	 * 
	 * @return Uma String
	 */
	public String representacaoLista() {
		return this.nome + ", " + categoria.getCategoria();
	}
	
	/**
	 * Retorna a precedencia da categoria do item.
	 * 
	 * @return Retorna um inteiro informando a precedencia da categoria.
	 */
	public int getPrecedencia() {
		return this.categoria.getPrecedencia();
	}
	
	/**
	 * Atualiza os atributos de um item.
	 * 
	 * @param atributo  Nome do atributo a ser alterado
	 * @param novoValor Novo valor que sera atualizado
	 */
	public void atualizaItem(String atributo, String novoValor) {
		
		switch (atributo) {
		case "nome":
			this.nome = novoValor;
			break;
		case "categoria":
			this.categoria = new Categoria(novoValor);
			break;
		}
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public List<List<String>> getMapaDePrecos() {
		List<List<String>> precos = new ArrayList<>();
		for (String key : this.mapaDePrecos.keySet()) {
			List<String> preco = new ArrayList<>();
			preco.add(key);
			preco.add(this.mapaDePrecos.get(key) + "");
			precos.add(preco);
		}
		return precos;
	}

}
package projeto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemController {

	private Map<Integer, Item> itens;
	private int id;
	private Item item;
	private Validador validador;
	private Comparator<Item> estrategiaDeOrdenacao;
	
	private int identificador() {
		this.id += 1;
		return this.id;
	}
	
	private boolean verificaIgualdade(Item item) {
		for (Item itemSistema : this.itens.values()) {
			if (itemSistema.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	public ItemController() {
		this.itens = new HashMap<>();
		this.id = 0;
		this.validador = new Validador();
		this.estrategiaDeOrdenacao = new OrdenaAlfabetica();
	}
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		int id = identificador();
		this.item = new ItemQuantidadeFixa(id, nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		this.validador.validaItemQuantidadeFixa(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		if (!verificaIgualdade(item)) {
			this.itens.put(id, item);
		}
		return id;
	}
	
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		int id = identificador();
		this.item = new ItemQuilo(id, nome, categoria, kg, localDeCompra, preco);
		this.validador.validaItemQuilo(nome, categoria, kg, localDeCompra, preco);
		if (!verificaIgualdade(item)) {
			this.itens.put(id, item);
		}
		return id;
	}
	
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		int id = identificador();
		this.item = new ItemUnidade(id, nome, categoria, unidade, localDeCompra, preco);
		this.validador.validaItemUnidade(nome, categoria, unidade, localDeCompra, preco);
		if (!verificaIgualdade(item)) {
			this.itens.put(id, item);
		}
		return id;
	}

	public String exibeItem(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		} else if (!this.itens.containsKey(id)) {
			throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
		}
		return this.itens.get(id).toString();
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		this.validador.validaAtualizaItem(atributo, novoValor);
		if (!this.itens.containsKey(id)) {
			throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		}
		this.itens.get(id).atualizaItem(atributo, novoValor);

	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");	
		} else if (!this.itens.containsKey(id)) {
			throw new IllegalArgumentException("Erro no cadastro de preco: item nao existe.");
		}
		this.validador.validaAdicionaPrecoItem(localDeCompra, preco);
		this.itens.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	public void deletaItem(int id) {
		this.itens.remove(id);
	}
	
	public String getItem(int posicao) {
		List<Item> listaItens = new ArrayList<>(itens.values());
		Collections.sort(listaItens, this.estrategiaDeOrdenacao);
		return listaItens.get(posicao).toString();
	}
}
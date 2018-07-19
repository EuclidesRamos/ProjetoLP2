package projeto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por controlar a classe Item.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class ItemController {

	/**
	 * Atributo do tipo mapa que armazena todos os itens do sistema (chave=id, valor=item).
	 */
	private Map<Integer, Item> itens;
	
	/**
	 * Atributo que armazena o ultimo id que foi setado para o item.
	 */
	private int id;
	
	/**
	 * Atributo que armazena um item.
	 */
	private Item item;
	
	/**
	 * Atributo que armazena o validador dos parametros de entrada.
	 */
	private Validador validador;
	
	/**
	 * Atributo que armazena a estrategia de ordenacao dos itens.
	 */
	private Comparator<Item> estrategiaDeOrdenacao;
	
	/**
	 * Metodo responsavel por criar o id do item.
	 * 
	 * @return Retorna um int representando o ID.
	 */
	private int identificador() {
		this.id += 1;
		return this.id;
	}
	
	/**
	 * Metodo responsavel por verificar se um item ja foi adicionado ao Sistema.
	 * 
	 * @param item objeto a ser verificado.
	 * @return Retorna true, quando o item existir, ou false, quando o item não existir.
	 */
	private boolean verificaIgualdade(Item item) {
		for (Item itemSistema : this.itens.values()) {
			if (itemSistema.equals(item)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Construtor responsavel por construir o objeto controller.
	 */
	public ItemController() {
		this.itens = new HashMap<>();
		this.id = 0;
		this.validador = new Validador();
		this.estrategiaDeOrdenacao = new OrdenaAlfabetica();
	}
	
	/**
	 * Metodo responsavel por adicionar um item com quantidade fixa no Sistema.
	 * 
	 * @param nome Nome do item.
	 * @param categoria Categoria do item (alimento industrializado, alimento nao industrializado, limpeza e higiene pessoal.
	 * @param quantidade Quantidade do item a ser adicionada.
	 * @param unidadeDeMedida Unidade de medida da quantidade (l, kg, etc)
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 * @return Retorna o id (gerado automaticamente) do item.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		int id = identificador();
		this.item = new ItemQuantidadeFixa(id, nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		this.validador.validaItemQuantidadeFixa(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
		if (!verificaIgualdade(item)) {
			this.itens.put(id, item);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		}
		return id;
	}
	
	/**
	 * Metodo responsavel por adicionar um item pela quantidade em quilos no Sistema.
	 * 
	 * @param nome Nome do item.
	 * @param categoria Categoria do item (alimento industrializado, alimento nao industrializado, limpeza e higiene pessoal.
	 * @param kg Valor, em quilos, do item.
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 * @return Retorna o id (gerado automaticamente) do item.
	 */
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		int id = identificador();
		this.item = new ItemQuilo(id, nome, categoria, kg, localDeCompra, preco);
		this.validador.validaItemQuilo(nome, categoria, kg, localDeCompra, preco);
		if (!verificaIgualdade(item)) {
			this.itens.put(id, item);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		}
		return id;
	}
	
	/**
	 * Metodo responsavel por adicionar um item por unidade n Sistema.
	 * 
	 * @param nome Nome do item.
	 * @param categoria Categoria do item (alimento industrializado, alimento nao industrializado, limpeza e higiene pessoal.
	 * @param unidade valor da unidade a ser adicionada.
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 * @return Retorna o id (gerado automaticamente) do item.
	 */
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		int id = identificador();
		this.item = new ItemUnidade(id, nome, categoria, unidade, localDeCompra, preco);
		this.validador.validaItemUnidade(nome, categoria, unidade, localDeCompra, preco);
		if (!verificaIgualdade(item)) {
			this.itens.put(id, item);
		} else {
			throw new IllegalArgumentException("Erro no cadastro de item: item ja cadastrado no sistema.");
		}
		return id;
	}

	/**
	 * Metodo que captura um Item e exibe ao usuario.
	 * 
	 * @param id Id do item a ser exibido.
	 * @return Retorna o toString() do item.
	 */
	public String exibeItem(int id) {
		if (id <= 0) {
			throw new ArrayIndexOutOfBoundsException("Erro na listagem de item: id invalido.");
		} else if (!this.itens.containsKey(id)) {
			throw new ArrayIndexOutOfBoundsException("Erro na listagem de item: item nao existe.");
		}
		return this.itens.get(id).toString();
	}

	/**
	 * Metodo responsavel por atualizar algum atributo de Item.
	 * 
	 * @param id Id do item a ser atualizado.
	 * @param atributo Atributo a ser atualizado.
	 * @param novoValor Novo valor para o atributo informado.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.validador.validaAtualizaItem(atributo, novoValor);
		if (!this.itens.containsKey(id)) {
			throw new ArrayIndexOutOfBoundsException("Erro na atualizacao de item: item nao existe.");
		}
		this.itens.get(id).atualizaItem(atributo, novoValor);

	}
	
	/**
	 * Metodo responsavel por adicionar mais precos ao Item.
	 * 
	 * @param id Id do Item a ser colocado mais preco.
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id <= 0) {
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: id de item invalido.");	
		} else if (!this.itens.containsKey(id)) {
			throw new ArrayIndexOutOfBoundsException("Erro no cadastro de preco: item nao existe.");
		}
		this.validador.validaAdicionaPrecoItem(localDeCompra, preco);
		this.itens.get(id).adicionaPrecoItem(localDeCompra, preco);
	}

	/**
	 * Metodo responsavel por deletar um Item do Sistema.
	 * 
	 * @param id Id do item a ser deletado.
	 */
	public void deletaItem(int id) {
		this.itens.remove(id);
	}
	
	/**
	 * Exibe um Item ordenado em ordem alfabetica.
	 * 
	 * @param posicao Id do item a ser exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItem(int posicao) {
		List<Item> listaItens = new ArrayList<>(itens.values());
		Collections.sort(listaItens, this.estrategiaDeOrdenacao);
		if (listaItens.size() <= posicao) {
			return "";
		}
		return listaItens.get(posicao).toString();
	}
	
	/**
	 * Exibe um Item ordenado de acordo com sua categoria.
	 * 
	 * @param categoria Categoria a ser exibida.
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		this.validador.validaGetItemPorCategoria(categoria);
		List<Item> listaItens = new ArrayList<>();
		for (Item item : this.itens.values()) {
			if (item.getCategoria().equals(categoria)) {
				listaItens.add(item);
			}
		}
		Collections.sort(listaItens, this.estrategiaDeOrdenacao);
		if (listaItens.size() <= posicao) {
			return "";
		}
		return listaItens.get(posicao).toString();			
	}

	/**
	 * Exibe um Item ordenado pelo menor preco.
	 * 
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		this.estrategiaDeOrdenacao = new OrdenaPreco();
		return this.getItem(posicao);
	}

	/**
	 * Exibe um Item a partir de uma String recebida.
	 * 
	 * @param strPesquisa String a ser utilizada para verificacao dos Itens.
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorPesquisa(String strPesquisa, int posicao) {
		this.estrategiaDeOrdenacao = new OrdenaAlfabetica();
		List<Item> listaItens = new ArrayList<>();
		for (Item item : this.itens.values()) {
			if (item.toString().toLowerCase().contains(strPesquisa)) {
				listaItens.add(item);
			}
		}
		Collections.sort(listaItens, this.estrategiaDeOrdenacao);
		if (listaItens.size() <= posicao) {
			return "";
		}
		return listaItens.get(posicao).toString();		
	}
	
	/**
	 * Metodo responsavel por capturar e retornar um objeto do tipo Item no Map.
	 * 
	 * @param id Id do item a ser capturado
	 * @return Retorna o objeto do tipo Item.
	 */
	public Item pegaItem(int id) {
		return this.itens.get(id);
	}
}
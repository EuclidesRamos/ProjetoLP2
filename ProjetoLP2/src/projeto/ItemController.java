package projeto;

import java.util.HashMap;
import java.util.Map;

public class ItemController {

	private Map<Integer, Item> itens;
	private int id;
	
	private int identificador() {
		this.id += 1;
		return this.id;
	}
	
	public ItemController() {
		this.itens = new HashMap<>();
		this.id = 0;
	}
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		int id = identificador();
		this.itens.put(id, new ItemQuantidadeFixa(id, nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco));
		return id;
	}
	
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		int id = identificador();
		this.itens.put(id, new ItemQuilo(id, nome, categoria, kg, localDeCompra, preco));
		return id;
	}
	
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		int id = identificador();
		this.itens.put(id, new ItemUnidade(id, nome, categoria, unidade, localDeCompra, preco));
		return id;
	}

	public String exibeItem(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro na listagem de item: id invalido.");
		}else if (!this.itens.containsKey(id)) {
			throw new IllegalArgumentException("Erro na listagem de item: item nao existe.");
		}
		return this.itens.get(id).toString();
	}

	public void atualizaItem(int id, String atributo, String novoValor) {
		if (atributo.trim().isEmpty() || atributo == null) {
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao pode ser vazio ou nulo.");
		} else if (novoValor.trim().isEmpty() || novoValor == null) {
			throw new IllegalArgumentException("Erro na atualizacao de item: novo valor de atributo nao pode ser vazio ou nulo.");
		}
		if (!this.itens.containsKey(id)) {
			throw new IllegalArgumentException("Erro na atualizacao de item: item nao existe.");
		} 
		switch (atributo) {
		case "nome":
			this.itens.get(id).setNome(novoValor);
			break;
		case "categoria":
			if (!(novoValor.equals("alimentos industrializados") || novoValor.equals("alimentos nao industrializados") || novoValor.equals("limpeza") || novoValor.equals("higiene pessoal"))) {
				throw new IllegalArgumentException("Erro na atualizacao de item: categoria nao existe.");
			}
			this.itens.get(id).setCategoria(novoValor);
			break;
		case "quantidade":
			int novoValorInteiro = Integer.parseInt(novoValor);
			if( novoValorInteiro < 0) {
				 throw new IllegalArgumentException("Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");                                  
			}
			this.itens.get(id).setQuantidade(novoValorInteiro);
			break;
		case "unidade de medida":
			this.itens.get(id).setUnidadeDeMedida(novoValor);
			break;
		case "kg":
			double novoValorDouble = Double.parseDouble(novoValor);
			if (novoValorDouble < 0) {
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de quilos nao pode ser menor que zero.");
			}
			this.itens.get(id).setKg(novoValorDouble);
			break;
		case "unidades":
			int novoValorInt = Integer.parseInt(novoValor);
			if (novoValorInt <= 0) {
				throw new IllegalArgumentException("Erro na atualizacao de item: valor de quantidade nao pode ser menor que zero.");
			}
			break;
		default:
			throw new IllegalArgumentException("Erro na atualizacao de item: atributo nao existe.");
		}
		
	}

	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		if (id <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: id de item invalido.");	
		} else if (localDeCompra.trim().isEmpty() || localDeCompra == null) {
			throw new IllegalArgumentException("Erro no cadastro de preco: local de compra nao pode ser vazio ou nulo.");
		} else if (preco <= 0.0) {
			throw new IllegalArgumentException("Erro no cadastro de preco: preco de item invalido.");
		} else if (!this.itens.containsKey(id)) {
			throw new IllegalArgumentException("Erro no cadastro de preco: item nao existe.");
		}
		this.itens.get(id).adicionaPrecoItem(localDeCompra, preco);
		
	}

	public void deletaItem(int id) {
		this.itens.remove(id);
	}
}

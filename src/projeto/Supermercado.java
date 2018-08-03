package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe responsavel pelo supermercado, armazenando os itens que estao disponiveis para compra nele.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class Supermercado {

	/**
	 * Atributo que armazena o nome do Supermercado.
	 */
	private String nomeEstabeleciomento;
	
	/**
	 * Atributo que armazena o valor total das compras para o supermercado.
	 */
	private double valorCompras;
	
	/**
	 * Lista de compras disponiveis no supermercado.
	 */
	private List<Compra> compras;
	
	/**
	 * Construtor responsavel por construir um supermercado.
	 * 
	 * @param nomeEstabelecimento Nome do supermercado.
	 */
	public Supermercado(String nomeEstabelecimento) {
		this.nomeEstabeleciomento = nomeEstabelecimento;
		this.compras = new ArrayList<>();
	}
	
	/**
	 * Metodo responsavel por adicionar uma nova compra no supermercado.
	 * 
	 * @param compra Compra a ser adicionada.
	 * @param precoCompra Preco da compra que sera adicionada.
	 */
	public void adicionaCompra(Compra compra, Double precoCompra) {
		this.compras.add(compra);
		this.valorCompras += precoCompra * compra.getQuantidade();
	}

	/**
	 * Metodo responsavel por retornar o valor das compras do Supermercado.
	 * 
	 * @return Retorna o valor das compras do supermercado.
	 */
	public double getValorCompras() {
		return this.valorCompras;
	}

	/**
	 * Metodo responsavel por capturar uma compra na lista de compras.
	 * 
	 * @param posicaoLista Posicao da compra.
	 * @return Retorna o toString da compra, acrescido de "-".
	 */
	public String getCompra(int posicaoLista) {
		Collections.sort(this.compras, new OrdenacaoDefault());
		if (this.compras.size() >= posicaoLista) {
			return "- " + this.compras.get(posicaoLista - 1).toString();			
		}
		return "";
	}
	
	@Override
	public String toString() {
		return this.nomeEstabeleciomento + ": R$ " + String.format("%.2f", this.valorCompras);
	}
	
}

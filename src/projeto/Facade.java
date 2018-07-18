package projeto;

import easyaccept.EasyAccept;

/**
 * Classe de fachada. Responsavel pela "comunicacao" entre a interface e o codigo em si.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class Facade {

	/**
	 * Atributo responsavel por armazenar o controlador da classe Item.
	 */
	private ItemController controller = new ItemController();
	
	/**
	 * Metodo main da Facade, responsavel por realizar os testes do EasyAccept.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[] {"projeto.Facade", "testesDeAceitacao/use_case1.txt", "testesDeAceitacao/use_case1_exception.txt", "testesDeAceitacao/use_case2.txt", "testesDeAceitacao/use_case2_exception.txt"};
		EasyAccept.main(args);
	}
	
	/**
	 * Metodo responsavel por adicionar um item com quantidade fixa no Sistema.
	 * 
	 * @param nome Nome do item.
	 * @param categoria Categoria do item (alimento industrializado, alimento nao industrializado, limpeza e higiene pessoal).
	 * @param quantidade Quantidade do item a ser adicionada.
	 * @param unidadeDeMedida Unidade de medida da quantidade (l, kg, etc).
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 * @return Retorna o id (gerado automaticamente) do item.
	 */
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorQtd(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
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
		return this.controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
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
		return this.controller.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	/**
	 * Metodo que captura um Item e exibe ao usuario.
	 * 
	 * @param id Id do item a ser exibido.
	 * @return Retorna o toString() do item.
	 */
	public String exibeItem(int id) {
		return this.controller.exibeItem(id);
	}
	
	/**
	 * Metodo responsavel por atualizar algum atributo de Item.
	 * 
	 * @param id Id do item a ser atualizado.
	 * @param atributo Atributo a ser atualizado.
	 * @param novoValor Novo valor para o atributo informado.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controller.atualizaItem(id, atributo, novoValor);
	}
	
	/**
	 * Metodo responsavel por adicionar mais precos ao Item.
	 * 
	 * @param id Id do Item a ser colocado mais preco.
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controller.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	/**
	 * Metodo responsavel por deletar um Item do Sistema.
	 * 
	 * @param id Id do item a ser deletado.
	 */
	public void deletaItem(int id) {
		this.controller.deletaItem(id);
	}
	
	/**
	 * Exibe um Item ordenado em ordem alfabetica.
	 * 
	 * @param posicao Id do item a ser exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItem(int posicao) {
		return this.controller.getItem(posicao);
	}
	
	/**
	 * Exibe um Item ordenado de acordo com sua categoria.
	 * 
	 * @param categoria Categoria a ser exibida.
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controller.getItemPorCategoria(categoria, posicao);
	}
	
	/**
	 * Exibe um Item ordenado pelo menor preco.
	 * 
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controller.getItemPorMenorPreco(posicao);
	}
	
	/**
	 * Exibe um Item a partir de uma String recebida.
	 * 
	 * @param strPesquisa String a ser utilizada para verificacao dos Itens.
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorPesquisa(String strPesquisa, int posicao) {
		return this.controller.getItemPorPesquisa(strPesquisa, posicao);
	}
}

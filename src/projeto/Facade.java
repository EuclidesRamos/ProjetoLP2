package projeto;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	public ItemController controllerItem = new ItemController();
	
	/**
	 * Atributo responsavel por armazenar o controlador da classe Lista.
	 */
	private ListaController controllerLista = new ListaController(controllerItem);
	
	/**
	 * Metodo main da Facade, responsavel por realizar os testes do EasyAccept.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		args = new String[] {"projeto.Facade", "testesDeAceitacao/use_case1.txt", "testesDeAceitacao/use_case1_exception.txt", 
				"testesDeAceitacao/use_case2.txt", "testesDeAceitacao/use_case2_exception.txt", 
				"testesDeAceitacao/use_case3.txt", "testesDeAceitacao/use_case3_exception.txt", 
				"testesDeAceitacao/use_case4.txt", "testesDeAceitacao/use_case4_exception.txt","testesDeAceitacao/use_case5.txt"};
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
		return this.controllerItem.adicionaItemPorQtd(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
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
		return this.controllerItem.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
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
		return this.controllerItem.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	/**
	 * Metodo que captura um Item e exibe ao usuario.
	 * 
	 * @param id Id do item a ser exibido.
	 * @return Retorna o toString() do item.
	 */
	public String exibeItem(int id) {
		return this.controllerItem.exibeItem(id);
	}
	
	/**
	 * Metodo responsavel por atualizar algum atributo de Item.
	 * 
	 * @param id Id do item a ser atualizado.
	 * @param atributo Atributo a ser atualizado.
	 * @param novoValor Novo valor para o atributo informado.
	 */
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controllerItem.atualizaItem(id, atributo, novoValor);
	}
	
	/**
	 * Metodo responsavel por adicionar mais precos ao Item.
	 * 
	 * @param id Id do Item a ser colocado mais preco.
	 * @param localDeCompra Nome do local em que o item foi comprado.
	 * @param preco Preco do item.
	 */
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controllerItem.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	/**
	 * Metodo responsavel por deletar um Item do Sistema.
	 * 
	 * @param id Id do item a ser deletado.
	 */
	public void deletaItem(int id) {
		this.controllerItem.deletaItem(id);
	}
	
	/**
	 * Exibe um Item ordenado em ordem alfabetica.
	 * 
	 * @param posicao Id do item a ser exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItem(int posicao) {
		return this.controllerItem.getItem(posicao);
	}
	
	/**
	 * Exibe um Item ordenado de acordo com sua categoria.
	 * 
	 * @param categoria Categoria a ser exibida.
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorCategoria(String categoria, int posicao) {
		return this.controllerItem.getItemPorCategoria(categoria, posicao);
	}
	
	/**
	 * Exibe um Item ordenado pelo menor preco.
	 * 
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorMenorPreco(int posicao) {
		return this.controllerItem.getItemPorMenorPreco(posicao);
	}
	
	/**
	 * Exibe um Item a partir de uma String recebida.
	 * 
	 * @param strPesquisa String a ser utilizada para verificacao dos Itens.
	 * @param posicao Id do item a se exibido.
	 * @return Retorna o toString() do item.
	 */
	public String getItemPorPesquisa(String strPesquisa, int posicao) {
		return this.controllerItem.getItemPorPesquisa(strPesquisa, posicao);
	}
	
	/**
	 * Metodo responsavel por adicionar novas listas de compras ao sistema.
	 * 
	 * @param descritorLista Descritor da lista a ser adicionada.
	 * @return Retorna o descritor, no formato de String, da lista que foi adicionada.
	 */
	public String adicionaListaDeCompras(String descritorLista) {
		return this.controllerLista.adicionaListaDeCompras(descritorLista);
	}
	
	/**
	 * Metodo responsavel por pesquisar uma determinada lista de compras no sistema.
	 * 
	 * @param descritorLista Descritor da lista a ser pesquisada.
	 * @return Retorna o descritor da lista (caso ela ja tenha sido adicionada).
	 */
	public String pesquisaListaDeCompras(String descritorLista) {
		return this.controllerLista.pesquisaListaDeCompras(descritorLista);
	}
	
	/**
	 * Metodo responsavel por adicionar novas compras a lista ja cadastradas no sistma.
	 * 
	 * @param descritorLista Descritor da lista a ser acrescida de uma nova compra.
	 * @param quantidade Quantidade do item a ser inserido.
	 * @param itemId Id do item a ser inserido.
	 */
	public void adicionaCompraALista(String descritorLista, int quantidade, int itemId) {
		this.controllerLista.adicionaCompraALista(descritorLista, quantidade, itemId);
	}
	
	/**
	 * Metodo responsavel por pesquisar compras em uma determinada lista.
	 * 
	 * @param descritorLista Descritor da lista a ser percorrida.
	 * @param itemId Id do item a ser pesquisado.
	 * @return Retorna o toString da compra.
	 */
	public String pesquisaCompraEmLista(String descritorLista, int itemId) {
		return this.controllerLista.pesquisaCompraEmLista(descritorLista, itemId);
	}
	
	/**
	 * Metodo responsavel por atualizar a quantidade de uma determinada compra em uma determinada lista.
	 * 
	 * @param descritorLista Descritor da lista ser percorrida.
	 * @param itemId Id do item a ser alterada sua quantidade.
	 * @param operacao Operacao de alteracao (adiciona ou diminui).
	 * @param quantidade Quantidade a ser adicionada/diminuida.
	 */
	public void atualizaCompraDeLista(String descritorLista, int itemId, String operacao, int quantidade) {
		this.controllerLista.atualizaCompraDeLista(descritorLista, itemId, operacao, quantidade);
	}
	
	/**
	 * Metodo responsavel por finalizar uma lista de compras (compra efetivada).
	 * 
	 * @param descritorLista Descritor da lista a ser finalizada.
	 * @param localDeCompra Local onde as compras foram realizadas.
	 * @param valorFinalDaCompra Valor final das compras.
	 */
	public void finalizarListaDeCompras(String descritorLista, String localDeCompra, int valorFinalDaCompra) {
		this.controllerLista.finalizarListaDeCompras(descritorLista, localDeCompra, valorFinalDaCompra);
	}
	
	/**
	 * Captura um item em uma determinada lista de compras.
	 * 
	 * @param descritorLista Descritor da lista a ser percorrida.
	 * @param posicaoItem Posicao do item a ser capturado.
	 * @return Retorna o toString da compra.
	 */
	public String getItemLista(String descritorLista, int posicaoItem) {
		return this.controllerLista.getItemLista(descritorLista, posicaoItem);
	}
	
	/**
	 * Metodo responsavel por deletar uma compra em uma determinada lista.
	 * 
	 * @param descritorLista Descritor da lista a ser decrescida de uma compra.
	 * @param itemId Id do item a ser removido.
	 */
	public void deletaCompraDeLista(String descritorLista, int itemId) {
		this.controllerLista.deletaCompraDeLista(descritorLista, itemId);
	}
	
	/**
	 * Metodo responsavel por pesquisar uma lista de compras pela sua data de criacao.
	 * 
	 * @param dataAtual Data em que a lista de compras foi criada.
	 * @param posicaoLista Posicao da lista a ser exibida.
	 * @return Retorna uma representacao em String da lista que est� na posicao informada e que foi criada na data informada.
	 */
	public String getItemListaPorData(String dataAtual, int posicaoLista) {
		return this.controllerLista.getItemListaPorData(dataAtual, posicaoLista);
	}
	
	/**
	 * Metodo responsavel por pesquisar as listas de compras que contem o item passado como parametro.
	 * 
	 * @param id Id do item a ser pesquisado.
	 * @param posicaoLista Posicao da lista a ser exibida.
	 * @return Retorna uma representacao em String da compra que esta na posicao em que foi passada como parametro.
	 */
	public String getItemListaPorItem(int id, int posicaoLista) {
		return this.controllerLista.getItemListaPorItem(id, posicaoLista);
	}
	
	/**
	 * Metodo responsavel por retornar a data atual.
	 * 
	 * @return Retorna a data atual.
	 */
	public String dataAtual() {
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		return formatoData.format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * Metodo responsavel por retornar a descricao das listas que foram criadas na data passada como parametro.
	 * 
	 * @param data data a ser pesquisada.
	 * @return Retorna os descritores das listas que foram criadas na data informada.
	 */
	public String pesquisaListasDeComprasPorData(String data) {
		return this.controllerLista.pesquisaListasDeComprasPorData(data);
	}
	
	/**
	 * Metodo responsavel por retornar a descricao das listas que possuem o item informado.
	 * 
	 * @param itemId Id do item a ser procurado.
	 * @return Retorna os descritores das listas que possuem o item informado.
	 */
	public String pesquisaListasDeComprasPorItem(int itemId) {
		return this.controllerLista.pesquisaListasDeComprasPorItem(itemId);
	}
	 
	public String geraAutomaticaUltimaLista() {
		return this.controllerLista.geraAutomaticaUltimaLista();
	}
}

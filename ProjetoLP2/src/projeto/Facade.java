package projeto;

public class Facade {

	private ItemController controller = new ItemController();
	
	public int adicionaItemPorQtd(String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorQtd(nome, categoria, quantidade, unidadeDeMedida, localDeCompra, preco);
	}
	
	public int adicionaItemPorQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorQuilo(nome, categoria, kg, localDeCompra, preco);
	}
	
	public int adicionaItemPorUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		return this.controller.adicionaItemPorUnidade(nome, categoria, unidade, localDeCompra, preco);
	}
	
	public String exibeItem(int id) {
		return this.controller.exibeItem(id);
	}
	
	public void atualizaItem(int id, String atributo, String novoValor) {
		this.controller.atualizaItem(id, atributo, novoValor);
	}
	
	public void adicionaPrecoItem(int id, String localDeCompra, double preco) {
		this.controller.adicionaPrecoItem(id, localDeCompra, preco);
	}
	
	public void deletaItem(int id) {
		this.controller.deletaItem(id);
	}
}

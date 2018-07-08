package projeto;

public class Main {

	public static void main(String[] args) {
		
		ItemQuilo item = new ItemQuilo(34,"Chuchu","alimentos nao industrializados",1,"Supermercado BaratoD+ ", 1.34);
		ItemQuantidadeFixa item1 = new ItemQuantidadeFixa(219,"Algodão Clemer","Higiene Pessoal",300,"gramas","Supermercado BaratoD+",2.33);
		ItemUnidade item2 = new ItemUnidade(87,"Queijo minas dali","alimentos nao industrializados",8,"Baratao",4.30);
		item.adicionaPreco("Baratao", 2.30);
		System.out.println(item1);
		System.out.println(item);
		System.out.println(item2);
		System.out.println(item.menorPreco());
	
	}

}

package projeto;

public class Validador {

	public Validador() {
		
	}
	
	public void validaItemQuantidadeFixa(String nome, String categoria, int quantidade, String unidadeDeMedida, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroInteiroInvalido(quantidade, mensagem + "valor de quantidade nao pode ser menor que zero.");
		parametroInvalido(unidadeDeMedida, mensagem + "unidade de medida nao pode ser vazia ou nula.");
	}
	
	public void validaItemQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroDoubleInvalido(kg, mensagem + "valor de quilos nao pode ser menor que zero.");
	}
	
	public void validaItemUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroInteiroInvalido(unidade, mensagem + "valor de unidade nao pode ser menor que zero.");
	}
	
	public void validaAtualizaItem(String atributo, String novoValor) {
		String mensagem = "Erro na atualizacao de item: ";
		parametroInvalido(atributo, mensagem + "atributo nao pode ser vazio ou nulo.");
		parametroInvalido(novoValor, mensagem + "novo valor de atributo nao pode ser vazio ou nulo.");
		switch (atributo) {
		case "nome":
			break;
		case "categoria":
			validaCategoria(novoValor, mensagem);
			break;
		case "quantidade":
			parametroInteiroInvalido(Integer.parseInt(novoValor), mensagem + "valor de quantidade nao pode ser menor que zero.");
			break;
		case "unidade de medida":
			break;
		case "kg":
			parametroDoubleInvalido(Double.parseDouble(novoValor), mensagem + "valor de quilos nao pode ser menor que zero.");
			break;
		case "unidades":
			parametroInteiroInvalido(Integer.parseInt(novoValor), mensagem + "valor de quantidade nao pode ser menor que zero.");
		default:
			throw new IllegalArgumentException(mensagem + "atributo nao existe.");
		}
	}
	
	public void validaAdicionaPrecoItem(String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de preco: ";
		parametroInvalido(localDeCompra, mensagem + "local de compra nao pode ser vazio ou nulo.");
		parametroDoubleInvalido(preco, mensagem + "preco de item invalido.");
	}

	private static void validaParametrosCadastro(String nome, String categoria, String localDeCompra, double preco, String mensagem) {
		parametroInvalido(nome, mensagem + "nome nao pode ser vazio ou nulo.");
		validaCategoria(categoria, mensagem);
		parametroInvalido(localDeCompra, mensagem + "local de compra nao pode ser vazio ou nulo.");
		parametroDoubleInvalido(preco, mensagem + "preco de item invalido.");
	}
	
	private static void parametroInvalido(String parametro, String mensagem) {
		if (parametro == null) {
			throw new NullPointerException(mensagem);
		} else if ("".equals(parametro.trim())) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	private static void validaCategoria(String categoria, String mensagem) {
		if (categoria == null) {
			throw new NullPointerException(mensagem + "categoria nao pode ser vazia ou nula.");
		} else if ("".equals(categoria.trim())) {
			throw new IllegalArgumentException(mensagem + "categoria nao pode ser vazia ou nula.");
		} else if (!(categoria.equals("alimento industrializado") || categoria.equals("alimento nao industrializado") || categoria.equals("limpeza") || categoria.equals("higiene pessoal"))) {
			throw new IllegalArgumentException(mensagem + "categoria nao existe.");
		}
	}
	
	private static void parametroDoubleInvalido(double parametro, String mensagem) {
		if (parametro < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	private static void parametroInteiroInvalido(int paramentro, String mensagem) {
		if (paramentro < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
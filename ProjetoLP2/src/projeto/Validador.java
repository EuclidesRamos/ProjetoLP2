package projeto;

public class Validador {
	/**
	 * Construtor de validador, onde não e setado nada.
	 */
	public Validador() {
	}

	/**
	 * Metodo onde valida a quantidade fixa de item.
	 * 
	 * @param nome
	 *            Nome do item.
	 * @param categoria
	 *            Categoria do item.
	 * @param quantidade
	 *            Quantidade do item.
	 * @param unidadeDeMedida
	 *            Unidade do item.
	 * @param localDeCompra
	 *            Local onde foi comprado.
	 * @param preco
	 *            Preco do item.
	 */
	public void validaItemQuantidadeFixa(String nome, String categoria, int quantidade, String unidadeDeMedida,
			String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroInteiroInvalido(quantidade, mensagem + "valor de quantidade nao pode ser menor que zero.");
		parametroInvalido(unidadeDeMedida, mensagem + "unidade de medida nao pode ser vazia ou nula.");
	}

	/**
	 * Metodo onde valida o item quando ele e por quilo.
	 * 
	 * @param nome
	 *            Nome do item.
	 * @param categoria
	 *            Categoria do item.
	 * @param kg
	 *            Total de quilogramas do item.
	 * @param localDeCompra
	 *            Local onde foi comprado.
	 * @param preco
	 *            Preco do item.
	 */
	public void validaItemQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroDoubleInvalido(kg, mensagem + "valor de quilos nao pode ser menor que zero.");
	}

	/**
	 * Metodo onde valida o item quando ele e vendido por unidade.
	 * 
	 * @param nome
	 *            Nome do item.
	 * @param categoria
	 *            Categoria do item.
	 * @param unidade
	 *            Total de unidades do item.
	 * @param localDeCompra
	 *            Local onde foi comprado.
	 * @param preco
	 *            Preco do item.
	 */
	public void validaItemUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroInteiroInvalido(unidade, mensagem + "valor de unidade nao pode ser menor que zero.");
	}

	/**
	 * Metodo onde faz a validacao, para poder atualizar o item.
	 * 
	 * @param atributo
	 *            Atributo do item.
	 * @param novoValor
	 *            Novo valor do item.
	 */
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
			parametroInteiroInvalido(Integer.parseInt(novoValor),
					mensagem + "valor de quantidade nao pode ser menor que zero.");
			break;
		case "unidade de medida":
			break;
		case "kg":
			parametroDoubleInvalido(Double.parseDouble(novoValor),
					mensagem + "valor de quilos nao pode ser menor que zero.");
			break;
		case "unidades":
			parametroInteiroInvalido(Integer.parseInt(novoValor),
					mensagem + "valor de quantidade nao pode ser menor que zero.");
		default:
			throw new IllegalArgumentException(mensagem + "atributo nao existe.");
		}
	}

	/**
	 * Metodo onde faz a validacao para a adicao do preco.
	 * 
	 * @param localDeCompra
	 *            Local onde o item foi comprado.
	 * @param preco
	 *            Preco a ser adicionado ao item.
	 */
	public void validaAdicionaPrecoItem(String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de preco: ";
		parametroInvalido(localDeCompra, mensagem + "local de compra nao pode ser vazio ou nulo.");
		parametroDoubleInvalido(preco, mensagem + "preco de item invalido.");
	}

	/**
	 * Metodo onde faz a validacao dos parametros, para cadastrar um novo item.
	 * 
	 * @param nome
	 *            Nome do item,
	 * @param categoria
	 *            Categoria do item.
	 * @param localDeCompra
	 *            Local onde o item foi comprado.
	 * @param preco
	 *            Preco do item.
	 * @param mensagem
	 *            Mensagem de checagem.
	 */
	private static void validaParametrosCadastro(String nome, String categoria, String localDeCompra, double preco,
			String mensagem) {
		parametroInvalido(nome, mensagem + "nome nao pode ser vazio ou nulo.");
		validaCategoria(categoria, mensagem);
		parametroInvalido(localDeCompra, mensagem + "local de compra nao pode ser vazio ou nulo.");
		parametroDoubleInvalido(preco, mensagem + "preco de item invalido.");
	}

	/**
	 * Metodo onde verfica se o parametro e ou nao permitido.
	 * 
	 * @param parametro
	 *            Que pode ser, nome, local, categoria, preco, mensagem, ou seja, as
	 *            caracteristicas do item.
	 * 
	 * @param mensagem
	 *            Mensagem de checagem.
	 */
	private static void parametroInvalido(String parametro, String mensagem) {
		if (parametro == null) {
			throw new NullPointerException(mensagem);
		} else if ("".equals(parametro.trim())) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Metodo onde verica a Categoria.
	 * 
	 * @param categoria
	 *            Categoria do item.
	 * @param mensagem
	 *            Mensagem de checagem.
	 */
	private static void validaCategoria(String categoria, String mensagem) {
		if (categoria == null) {
			throw new NullPointerException(mensagem + "categoria nao pode ser vazia ou nula.");
		} else if ("".equals(categoria.trim())) {
			throw new IllegalArgumentException(mensagem + "categoria nao pode ser vazia ou nula.");
		} else if (!(categoria.equals("alimento industrializado") || categoria.equals("alimento nao industrializado")
				|| categoria.equals("limpeza") || categoria.equals("higiene pessoal"))) {
			throw new IllegalArgumentException(mensagem + "categoria nao existe.");
		}
	}

	/**
	 * Metodo onde verifica se o parametro é negativo.
	 * 
	 * @param parametro
	 *            Numero flutuante a ser comparado.
	 * @param mensagem
	 *            Mensagem de checagem.
	 */
	private static void parametroDoubleInvalido(double parametro, String mensagem) {
		if (parametro < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Metodo onde verifica se o parametro é negativo.
	 * 
	 * @param paramentro
	 *            Numero int a ser comparado.
	 * @param mensagem
	 *            Mensagem de checagem.
	 */
	private static void parametroInteiroInvalido(int paramentro, String mensagem) {
		if (paramentro < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}
}
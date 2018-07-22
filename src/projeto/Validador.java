package projeto;

/**
 * Classe responsavel por validar parametros de entrada.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 *
 */
public class Validador {
	/**
	 * Construtor de validador, onde nao e setado nada.
	 */
	public Validador() {
	}

	/**
	 * Metodo onde valida a quantidade fixa de item.
	 * 
	 * @param nome            Nome do item.
	 * @param categoria       Categoria do item.
	 * @param quantidade      Quantidade do item.
	 * @param unidadeDeMedida Unidade do item.
	 * @param localDeCompra   Local onde foi comprado.
	 * @param preco           Preco do item.
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
	 * @param nome          Nome do item.
	 * @param categoria     Categoria do item.
	 * @param kg            Total de quilogramas do item.
	 * @param localDeCompra Local onde foi comprado.
	 * @param preco         Preco do item.
	 */
	public void validaItemQuilo(String nome, String categoria, double kg, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroDoubleInvalido(kg, mensagem + "valor de quilos nao pode ser menor que zero.");
	}

	/**
	 * Metodo onde valida o item quando ele e vendido por unidade.
	 * 
	 * @param nome          Nome do item.
	 * @param categoria     Categoria do item.
	 * @param unidade       Total de unidades do item.
	 * @param localDeCompra Local onde foi comprado.
	 * @param preco         Preco do item.
	 */
	public void validaItemUnidade(String nome, String categoria, int unidade, String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de item: ";
		validaParametrosCadastro(nome, categoria, localDeCompra, preco, mensagem);
		parametroInteiroInvalido(unidade, mensagem + "valor de unidade nao pode ser menor que zero.");
	}

	/**
	 * Metodo onde faz a validacao, para poder atualizar o item.
	 * 
	 * @param atributo  Atributo do item.
	 * @param novoValor Novo valor do item.
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
		case "unidade":
			parametroInteiroInvalido(Integer.parseInt(novoValor),
					mensagem + "valor de unidade nao pode ser menor que zero.");
			break;
		default:
			throw new IllegalArgumentException(mensagem + "atributo nao existe.");
		}
	}

	/**
	 * Metodo onde faz a validacao para a adicao do preco.
	 * 
	 * @param localDeCompra Local onde o item foi comprado.
	 * @param preco         Preco a ser adicionado ao item.
	 */
	public void validaAdicionaPrecoItem(String localDeCompra, double preco) {
		String mensagem = "Erro no cadastro de preco: ";
		parametroInvalido(localDeCompra, mensagem + "local de compra nao pode ser vazio ou nulo.");
		parametroDoubleInvalido(preco, mensagem + "preco de item invalido.");
	}

	public void validaGetItemPorCategoria(String categoria) {
		String mensagem = "Erro na listagem de item: ";
		validaCategoria(categoria, mensagem);
	}

	/**
	 * Metodo que verifica se os parametros ao construir um compra sao validos.
	 * 
	 * @param quantidade Quantidade de itens
	 * @param item       Item
	 */
	public void validaCompra(int quantidade, Item item) {
		if (quantidade <= 0) {
			throw new IllegalArgumentException("Quantidade nao pode ser menor ou igual a zero.");
			
		}
		this.validaObjeto(item, "");
	}
	
	/**
	 * Metodo que verifica se o descritor de uma lista de compra e valido.
	 * 
	 * @param descritor descritor da lista.
	 * @param mensagem mensagem a ser exibida, caso seja lancando execao.
	 */
	public void validaListaDeCompras(String descritor, String mensagem) {
		parametroInvalido(descritor, mensagem + "descritor nao pode ser vazio ou nulo.");
	}
	
	/**
	 * Metodo que verifica se a operacao de atualizacao de item em lista e valida.
	 * 
	 * @param operacao Operacao a ser analizada.
	 */
	public void validaAtualizaCompraDeLista(String operacao) {
		if ("adiciona".equals(operacao) || "diminui".equals(operacao)) {
			
		} else {
			throw new IllegalArgumentException("Erro na atualizacao de compra: operacao invalida para atualizacao.");
		}
	}
	
	/**
	 * Metodo que verifica se os atributos para finalizar a lista sao validos.
	 * 
	 * @param descritorLista Descricao da lista.
	 * @param localDeCompra Local onde a compra foi efetivada.
	 * @param valorFinalDaCompra Valor final da compra.
	 */
	public void validaFinalizarListaDeCompras(String descritorLista, String localDeCompra, int valorFinalDaCompra) {
		String mensagem = "Erro na finalizacao de lista de compras: ";
		parametroInvalido(descritorLista, mensagem + "descritor nao pode ser vazio ou nulo.");
		parametroInvalido(localDeCompra, mensagem + "local nao pode ser vazio ou nulo.");
		parametroInteiroInvalido(valorFinalDaCompra - 1, mensagem + "valor final da lista invalido.");
		
	}
	
	/**
	 * Metodo responsavel por verificar se um objeto e nulo.
	 * 
	 * @param objeto Objeto a ser verificado.
	 * @param mensagem Mensagem a ser exibida na excecao.
	 */
	public void validaObjeto(Object objeto, String mensagem) {
		if (objeto == null) {
			throw new NullPointerException(mensagem);
		}
	}
	
	/**
	 * Metodo que verifica se a data esta no formato adequado.
	 * 
	 * @param data Data a ser verificada.
	 */
	public void validaData(String data) {
		String formatoData = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
		String mensagem = "Erro na pesquisa de compra: ";
		if (data == null) {
			throw new NullPointerException(mensagem + "data nao pode ser vazia ou nula.");
		} else if ("".equals(data.trim())) {
			throw new IllegalArgumentException(mensagem + "data nao pode ser vazia ou nula.");
		}
		if (!data.matches(formatoData)) {
			throw new IllegalArgumentException(mensagem + "data em formato invalido, tente dd/MM/yyyy");
		}
	}
	
	/**
	 * Metodo onde faz a validacao dos parametros, para cadastrar um novo item.
	 * 
	 * @param nome          Nome do item,
	 * @param categoria     Categoria do item.
	 * @param localDeCompra Local onde o item foi comprado.
	 * @param preco         Preco do item.
	 * @param mensagem      Mensagem de checagem.
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
	 * @param parametro Que pode ser, nome, local, categoria, preco, mensagem, ou
	 *                  seja, as caracteristicas do item.
	 * 
	 * @param mensagem  Mensagem de checagem.
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
	 * @param categoria Categoria do item.
	 * @param mensagem  Mensagem de checagem.
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
	 * Metodo onde verifica se o parametro e negativo.
	 * 
	 * @param parametro Numero flutuante a ser comparado.
	 * @param mensagem  Mensagem de checagem.
	 */
	private static void parametroDoubleInvalido(double parametro, String mensagem) {
		if (parametro < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Metodo onde verifica se o parametro e negativo.
	 * 
	 * @param paramentro Numero int a ser comparado.
	 * @param mensagem   Mensagem de checagem.
	 */
	private static void parametroInteiroInvalido(int paramentro, String mensagem) {
		if (paramentro < 0) {
			throw new IllegalArgumentException(mensagem);
		}
	}

}
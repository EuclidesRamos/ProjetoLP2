package projeto;

import java.io.Serializable;

/**
 * Classe responsavel por representar uma categoria no sistema.
 * 
 * @author Euclides Ramos - 117210377
 * @author Edson Weslley - 117211348
 * @author Eduardo Pereira - 117210342
 * @author Joao Antonio Bandeira - 117210692
 */
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5011186241133421277L;
	
	/**
	 * Nome da categoria.
	 */
	private String nomeCategoria;
	
	/**
	 * Precedencia.
	 */
	private int precedencia;
	
	/**
	 * Validador
	 */
	private Validador validador;

	/**
	 * Constroi uma categoria a partir de seu nome.
	 * 
	 * @param nomeCategoria Nome da categoria
	 */
	public Categoria(String nomeCategoria) {
		validador = new Validador();
		this.validador.validaCategoria(nomeCategoria);
		this.nomeCategoria = nomeCategoria;
		precedencia(nomeCategoria);
	}

	/**
	 * Metodo que calcula a precedencia da categoria do item.
	 * 
	 * @param categoria Categoria a ser verificada.
	 */
	private void precedencia(String nomeCategoria) {
		if (nomeCategoria.equals("higiene pessoal")) {
			this.precedencia = 1;
		} else if (nomeCategoria.equals("limpeza")) {
			this.precedencia = 2;
		} else if (nomeCategoria.equals("alimento industrializado")) {
			this.precedencia = 3;
		} else if (nomeCategoria.equals("alimento nao industrializado")) {
			this.precedencia = 4;
		}
	}

	/**
	 * Metodo que retorna o nome da categoria.
	 * 
	 * @return Retorna a categoria, em forma de string.
	 */
	public String getCategoria() {
		return this.nomeCategoria;
	}

	/**
	 * Metodo que retorna a precedencia de uma categoria.
	 * 
	 * @return Retorna um inteiro representando a precedencia da categoria(higiene pessoa: 1, limpeza: 2, alimento industrializado: 3, alunomento nao industrializado: 4)
	 */
	public int getPrecedencia() {
		return this.precedencia;
	}

	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna uma representacao para o objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
		return result;
	}

	/**
	 * Metodo que sobrescreve o metodo da classe pai. Retorna true, para objetos iguais, ou false, para objetos diferentes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (nomeCategoria == null) {
			if (other.nomeCategoria != null)
				return false;
		} else if (!nomeCategoria.equals(other.nomeCategoria))
			return false;
		return true;
	}
}

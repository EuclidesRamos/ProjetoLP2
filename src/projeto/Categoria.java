package projeto;

public class Categoria {
	
	private String nomeCategoria;
	private int precedencia;
	
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
	
	public Categoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
		precedencia(nomeCategoria);
	}
	
	public String getCategoria() {
		return this.nomeCategoria;
	}
	
	public int getPrecedencia() {
		return this.precedencia;
	}

}

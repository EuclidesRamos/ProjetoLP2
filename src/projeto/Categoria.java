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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCategoria == null) ? 0 : nomeCategoria.hashCode());
		return result;
	}

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

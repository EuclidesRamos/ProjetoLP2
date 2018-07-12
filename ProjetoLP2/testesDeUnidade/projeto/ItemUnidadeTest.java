package projeto;


import org.junit.Before;
import org.junit.Test;
/**
 * Responsavel pelos testes da classe ItemUnidade
 * @author eduardo
 *
 */
public class ItemUnidadeTest {
	
	private ItemUnidade item;

	@Before
	public void criaItemUnidade() {
		this.item = new ItemUnidade(1,"Sabao","limpeza",2,"baratao",2.50);
	}
	@Test(expected = IllegalArgumentException.class)
	public void criaItemUnidadeNomeVazio() {
		this.item = new ItemUnidade(1,"","limpeza",2,"baratao",2.50);
	}
	
	

}

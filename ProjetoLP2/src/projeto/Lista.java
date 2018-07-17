package projeto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Lista {
	
	private String descritor;
	private Set<Compra> compras;
	private LocalDateTime dataHora;
	
	public Lista(String descritor) {
		this.descritor = descritor;
		this.compras = new HashSet<>();
		this.dataHora = LocalDateTime.now();
	}
	
	
	
	

}

package domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") // ignora warnings do tipo serial isso vem do IDE 
@MappedSuperclass  // serve para não ser gerada tabela porém pode ser usada por outras classe para gearar tabela
public class GenericDomain implements Serializable { // POJO utiliza o Serializable porque os frameworks vai tentar serializar a classe assim evitnado erros  
	
	// esta classe � uma classe gen�rica para as entidade nesta caso � gerado somete o ID  
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // gera a sequencia de id no potgres 
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "GenericDomain [id=" + id + "]";
	}

	

}

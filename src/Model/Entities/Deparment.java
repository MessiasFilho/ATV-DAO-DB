package Model.Entities;

import java.util.Objects;

public class Deparment {
	
	private Integer ID ; 
	private String Nome ; 
	
	public Deparment () {}

	public Deparment(Integer iD, String nome) {
		
		ID = iD;
		Nome = nome;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deparment other = (Deparment) obj;
		return Objects.equals(ID, other.ID);
	}

	@Override
	public String toString() {
		return "Deparment [ID=" + ID + ", Nome=" + Nome + "]";
	}
	
	
	
}

package modelo;

public class Perro extends Mascota{
	
	String raza;
	boolean tienePulgas;
	
	public Perro() {
		super();
	}

	public Perro(String nombre, String dniDuenio, int edad, String fechaNacimiento, String raza, boolean tienePulgas) {
		super(nombre, dniDuenio, edad, fechaNacimiento);
		this.raza = raza;
		this.tienePulgas = tienePulgas;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public boolean isTienePulgas() {
		return tienePulgas;
	}

	public void setTienePulgas(boolean tienePulgas) {
		this.tienePulgas = tienePulgas;
	}

	@Override
	public String toString() {
		return "Perro [raza=" + raza + ", tienePulgas=" + tienePulgas + ", getNombre()=" + getNombre()
				+ ", getDniDuenio()=" + getDniDuenio() + ", getEdad()=" + getEdad() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getId()=" + getId() + "]";
	}
	
	

}

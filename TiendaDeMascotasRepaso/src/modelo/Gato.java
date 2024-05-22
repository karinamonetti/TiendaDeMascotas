package modelo;

public class Gato extends Mascota{
	
	String colorPelo, largoPelo;
	
	public Gato () {
		super();
	}

	public Gato(String nombre, String dniDuenio, int edad, String fechaNacimiento, String colorPelo, String largoPelo) {
		super(nombre, dniDuenio, edad, fechaNacimiento);
		this.colorPelo = colorPelo;
		this.largoPelo = largoPelo;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public String getLargoPelo() {
		return largoPelo;
	}

	public void setLargoPelo(String largoPelo) {
		this.largoPelo = largoPelo;
	}

	@Override
	public String toString() {
		return "Gato [colorPelo=" + colorPelo + ", largoPelo=" + largoPelo + ", getNombre()=" + getNombre()
				+ ", getDniDuenio()=" + getDniDuenio() + ", getEdad()=" + getEdad() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getId()=" + getId() + "]";
	}
	
	

}

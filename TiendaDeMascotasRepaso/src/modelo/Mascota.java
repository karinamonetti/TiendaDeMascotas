package modelo;

public class Mascota {
	
	private static int nextId = 1; // Contador de IDs
	private int id;
	
	private String nombre, dniDuenio;
	private int edad;
	private String fechaNacimiento;
	
	public Mascota() {
		this.id = nextId++;
	}

	public Mascota(String nombre, String dniDuenio, int edad, String fechaNacimiento) {
		this.id = nextId++;
		this.nombre = nombre;
		this.dniDuenio = dniDuenio;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public static int getNextId() {
		return nextId;
	}

	public static void setNextId(int nextId) {
		Mascota.nextId = nextId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDniDuenio() {
		return dniDuenio;
	}

	public void setDniDuenio(String dniDuenio) {
		this.dniDuenio = dniDuenio;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getId() {
		return id;
	}
	
	
}

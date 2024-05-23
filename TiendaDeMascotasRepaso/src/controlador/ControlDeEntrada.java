package controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.Perro;
import modelo.Gato;
import modelo.Mascota;

public class ControlDeEntrada {

	Scanner sc = new Scanner(System.in);

	public ControlDeEntrada() {

	}

	/**
	 * [METODO] - Añadir Mascota ▀ Método padre, contiene addPerro() y addGato()
	 * Recibe ArrayList <Mascota> mascotas para poder realizar operaciones sobre él.
	 */
	public void addMascota(ArrayList<Mascota> mascotas) {
		System.out.println("*** Añadir Mascota ***");
		System.out.println("¿Qué tipo de mascota deseas agregar?\n1. Perro\n2. Gato");

		try {
			int tipoMascota = sc.nextInt();

			if (tipoMascota == 1) {
				addPerro(mascotas);
			}

			else if (tipoMascota == 2) {
				addGato(mascotas);
			}

			else {
				System.err.println("ERROR: Ingresa una opción correcta.");
				addMascota(mascotas);
			}

		} catch (InputMismatchException e) {
			System.err.println("ERROR: Se está esperando un valor numérico..");
			addMascota(mascotas);

		}
	}

	/**
	 * [METODO] - Añadir Perro (ArrayList <Mascota> mascotas) ▀ contiene
	 * isValidDNI()
	 */
	public void addPerro(ArrayList<Mascota> mascotas) {
		sc.nextLine();
		System.out.println("** Agregar un Perro **");

		// Nombre
		System.out.println("Ingresa un nombre: ");
		String nombre = sc.nextLine();

		// Edad
		System.out.println("Ingresa una edad: ");
		// Validación EDAD x INT
		int edad = 0;
		try {
			edad = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("ERROR: Se está esperando un valor numérico..");
			addPerro(mascotas);
		}

		// Fecha de nacimiento
		System.out.println("Fecha de nacimiento: \n¡Importante! Escribir en formato AAAA-MM-DD\n");
		String fecNac = sc.nextLine();

		// Patrón para validar la fecha en formato AAAA-MM-DD
		String datePattern = "^(19[0-9]{2}|20([01][0-9]|2[0-4]))-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
		Pattern pattern = Pattern.compile(datePattern);
		Matcher matcher = pattern.matcher(fecNac);

		if (matcher.matches()) {
			// System.out.println("Fecha válida: " + fecNac);
		} else {
			System.err.println("ERROR: La fecha debe estar en el formato AAAA-MM-DD.");
			addPerro(mascotas);
		}

		// Raza
		System.out.println("Ingresa la raza del perro: ");
		String raza = sc.nextLine();

		// Pulgas
		System.out.println("¿El perro tiene pulgas?");
		System.out.println("1. Si\n2. No");
		boolean pulgas = false;
		try {
			int opcionPulgas = sc.nextInt();
			if (opcionPulgas == 1) {
				pulgas = true;
			} else if (opcionPulgas == 2) {
				pulgas = false;
			} else {
				System.err.println("ERROR: Solo puedes ingresar 1 o 2.");
				System.out.println("¿El perro tiene pulgas?");
				System.out.println("1. Si\n2. No");
				opcionPulgas = sc.nextInt();
			}
		} catch (InputMismatchException e) {
			System.err.println("ERROR: Se está esperando un valor numérico.");
			addPerro(mascotas);
		}

		// DNI Dueño
		sc.nextLine();
		System.out.println("Ingresa el DNI del dueño: \n Ejemplos: 87654321X, 34567890P, 23456789L");
		String dni = sc.nextLine();
		if (isValidDNI(dni)) {
			// System.out.println("DNI válido: " + dni);
		} else {
			System.err.println("ERROR: El DNI ingresado no es válido.");
			addPerro(mascotas);
		}

		mascotas.add(new Perro(nombre, dni, edad, fecNac, raza, pulgas));
		System.out.println("Se ha añadido el Perro correctamente.");
	}

	/**
	 * [METODO] - Validar DNI español
	 */
	public static boolean isValidDNI(String dni) {
		// Verificar que el formato sea correcto: ocho dígitos seguidos de una letra
		return dni != null && dni.matches("\\d{8}[A-Za-z]");
	}

	/**
	 * [METODO] - addGato(ArrayList <Mascota> mascotas) contiene isValidDNI()
	 */

	public void addGato(ArrayList<Mascota> mascotas) {
		sc.nextLine();
		System.out.println("** Agregar un Gato **");

		// Nombre
		System.out.println("Ingresa un nombre: ");
		String nombre = sc.nextLine();

		// Edad
		System.out.println("Ingresa una edad: ");
		// Validación EDAD x INT
		int edad = 0;
		try {
			edad = sc.nextInt();
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("ERROR: Se está esperando un valor numérico..");
			addGato(mascotas);
		}

		// Fecha de nacimiento
		System.out.println("Fecha de nacimiento: \n¡Importante! Escribir en formato AAAA-MM-DD\n");
		String fecNac = sc.nextLine();

		// Patrón para validar la fecha en formato AAAA-MM-DD
		String datePattern = "^(19[0-9]{2}|20([01][0-9]|2[0-4]))-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
		Pattern pattern = Pattern.compile(datePattern);
		Matcher matcher = pattern.matcher(fecNac);

		if (matcher.matches()) {
			// System.out.println("Fecha válida: " + fecNac);
		} else {
			System.err.println("ERROR: La fecha debe estar en el formato AAAA-MM-DD.");
			addGato(mascotas);
		}

		// DNI Dueño
		sc.nextLine();
		System.out.println("Ingresa el DNI del dueño: \n Ejemplos: 87654321X, 34567890P, 23456789L");
		String dni = sc.nextLine();
		if (isValidDNI(dni)) {
			// System.out.println("DNI válido: " + dni);
		} else {
			System.err.println("ERROR: El DNI ingresado no es válido.");
			addGato(mascotas);
		}

		// Color de pelo
		System.out.println("Ingresa el color del pelo:");
		String colorPelo = sc.nextLine();

		// Largo del pelo
		System.out.println("Ingresa el largo del pelo.\n1. Largo\n2. Medio\n3. Corto");
		int opcionPelo = 1;
		String opcionPeloChar = "";
		try {
			opcionPelo = sc.nextInt();
			if (opcionPelo == 1) {
				System.out.println("El gato tiene pelo largo.");
				opcionPeloChar = "L";
			} else if (opcionPelo == 2) {
				System.out.println("El gato tiene pelo medio.");
				opcionPeloChar = "M";
			} else if (opcionPelo == 3) {
				System.out.println("El gato tiene pelo corto.");
				opcionPeloChar = "C";
			} else {
				System.err.println("ERROR: Ingresa una opción válida");
				addGato(mascotas);
			}
		} catch (InputMismatchException e) {
			System.err.println("ERROR: Se esperaba un valor numérico.");
			addGato(mascotas);
		}

		mascotas.add(new Gato(nombre, dni, edad, fecNac, colorPelo, opcionPeloChar));
		System.out.println("Se ha añadido el Gato correctamente.");

	}

	/**
	 * [METODO] - recorrerArrayMascotas()
	 */
	public void recorrerArrayMascotas(ArrayList<Mascota> mascotas) {
		for (int i = 0; i < mascotas.size(); i++) {
			System.out.println(mascotas.get(i).toString());
		}
	}

	/**
	 * [METODO] - modificarMascota() { El usuario indicará el identificador de la
	 * mascota y se comprobará si existe entre las mascotas de la estructura única
	 * de almacenamiento. En caso de existir, únicamente se permitirá modificar el
	 * nombre, fecha de nacimiento y edad de la mascota}
	 */

	public void modificarMascota(ArrayList<Mascota> mascotas) {
		System.out.println("*** Modificar datos de una Mascota ***");
		System.out.println("Ingresa el IDENTIFICADOR de la mascota, si existe en nuestro programa podrás modificar "
				+ "su NOMBRE, FECHA DE NACIMIENTO y EDAD.");
		int dniIngresado = sc.nextInt();
		sc.nextLine();

		boolean found = false;

		for (int i = 0; i < mascotas.size(); i++) {
			if (dniIngresado == mascotas.get(i).getId()) {
				found = true;
				System.out.println("El ID ingresado corresponde a la mascota " + mascotas.get(i).toString());

				// Nombre
				System.out.println("Ingresa un nuevo nombre: ");
				String nombreMascota = sc.nextLine();
				mascotas.get(i).setNombre(nombreMascota);

				// Fecha de nacimiento
				System.out.println(
						"Ingresa una nueva fecha de nacimiento: \n¡Importante! Escribir en formato AAAA-MM-DD");
				String fecNac = sc.nextLine();

				// Patrón para validar la fecha en formato AAAA-MM-DD
				String datePattern = "^(19[0-9]{2}|20([01][0-9]|2[0-4]))-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
				Pattern pattern = Pattern.compile(datePattern);
				Matcher matcher = pattern.matcher(fecNac);

				if (matcher.matches()) {
					mascotas.get(i).setFechaNacimiento(fecNac);
				} else {
					System.err.println("ERROR: La fecha debe estar en el formato AAAA-MM-DD.");
					return; // Salir del método sin recursión
				}

				// Edad
				System.out.println("Ingresa una nueva edad: ");
				try {
					int edad = sc.nextInt();
					sc.nextLine();
					if (edad < 1) {
						System.err.println("ERROR: La edad no puede ser menor a 1.");
						return; // Salir del método sin recursión
					}
					mascotas.get(i).setEdad(edad);
				} catch (InputMismatchException e) {
					System.err.println("ERROR: Se está esperando un valor numérico.");
					sc.nextLine(); // Limpiar el buffer de entrada
					return; // Salir del método sin recursión
				}

				System.out.println("La mascota ha sido modificada correctamente. Los nuevos datos son:\n"
						+ mascotas.get(i).toString());
				break; // Salir del ciclo después de encontrar y modificar la mascota
			}
		}

		if (!found) {
			System.err
					.println("ERROR: El ID ingresado no se corresponde con ninguna mascota en nuestra base de datos.");
		}
	}

	/**
	 * [METODO] - eliminarMascotaPorId() El usuario indicará un identificador de mascota y se
	 * comprobará si existe entre las mascota de la estructura única de
	 * almacenamiento. En caso de existir, se eliminará. En caso de no existir, se
	 * muestra un mensaje de error
	 * 
	 * Funcionamiento:
	 * - dniIngresado -> input para el usuario
	 * - encontrado -> boolean auxiliar
	 * Si dniIngresado es = a mascotas.get(i).getId() entonces encontrado pasa a ser true y elimina la mascota.
	 * Luego realiza otra validación con encontrado, si encontrado = false entonces muestra el MSJ que no lo encontró.
	 */
	public void eliminarMascotaPorId(ArrayList<Mascota> mascotas) {
		System.out.println("*** Eliminar mascota por ID ***");
		System.out
				.println("Ingresa el IDENTIFICADOR de la mascota, si existe en nuestro programa entonces se eliminará");
		int dniIngresado = 0;
		dniIngresado = sc.nextInt();
		sc.nextLine();
		boolean encontrado = false;
		for (int i = 0; i < mascotas.size(); i++) {
			if (dniIngresado == mascotas.get(i).getId()) {
				encontrado = true;
				System.out.println("El ID ingresado corresponde a la mascota " + mascotas.get(i).toString());
				mascotas.remove(i);
				System.out.println("La mascota se ha eliminado correctamente.");
			} 
		}
		
		if (encontrado == false) {
			System.err.println("ERROR: El ID ingresado no se corresponde con ninguna mascota en nuestra base de datos.");
		}
	}
}

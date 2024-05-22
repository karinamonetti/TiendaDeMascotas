package controlador;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import modelo.Perro;
import modelo.Mascota;
import vista.Main;

public class ControlDeEntrada {

	Scanner sc = new Scanner(System.in);
	
	public ControlDeEntrada() {

	}

	
	/**
	 * [METODO] - Añadir Mascota ▀ Método padre, contiene addPerro() y addGato()
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
				System.out.println("Agregar Gato");
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
	 * [METODO] - Añadir Perro ▀ contiene isValidDNI()
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
		String datePattern = "^(\\d{4})-(\\d{2})-(\\d{2})$";
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
			//System.out.println("DNI válido: " + dni);
		} else {
			System.err.println("ERROR: El DNI ingresado no es válido.");
			addPerro(mascotas);
		}
		
		
        mascotas.add(new Perro(nombre, dni, edad, fecNac, raza, pulgas));
        for (int i = 0 ; i<mascotas.size(); i++) {
        	System.out.println(mascotas.get(i).toString());
        }
	}

	/**
	 * [METODO] - Validar DNI español
	 */
	public static boolean isValidDNI(String dni) {
		// Verificar que el formato sea correcto: ocho dígitos seguidos de una letra
		return dni != null && dni.matches("\\d{8}[A-Za-z]");
	}
}

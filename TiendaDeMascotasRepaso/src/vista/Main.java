package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controlador.ControlDeEntrada;
import modelo.Gato;
import modelo.Mascota;
import modelo.Perro;

public class Main {

	private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
	private Scanner sc = new Scanner(System.in);
	private ControlDeEntrada controlDeEntrada = new ControlDeEntrada();
	
	/**
	 * [METODO] - menu()
	 */
	public void menu() {
		System.out.println("*** Menú Tienda de Mascotas ***");
		System.out.println("0. Salir");
		System.out.println("1. Añadir mascota");
		System.out.println("2. Mostrar todas las mascotas");
		System.out.println("3. Modificar mascota");
		System.out.println("4. Eliminar mascota");
		System.out.println("5. Eliminar mascota por dueño");
		System.out.println("6. Mostrar mascotas por dueño");
		try {
			int opcion = sc.nextInt();
			while (opcion != 0) {
				if (opcion == 1) {
					controlDeEntrada.addMascota(mascotas);
				} else if (opcion == 2) {
					System.out.println("2. Mostrar todas las mascotas");
				} else if (opcion == 3) {
					System.out.println("3. Modificar mascota");
				} else if (opcion == 4) {
					System.out.println("4. Eliminar mascota");
				} else if (opcion == 5) {
					System.out.println("5. Eliminar mascota por dueño");
				} else if (opcion == 6) {
					System.out.println("6. Mostrar mascotas por dueño");
				} else {
					System.err.println("ERROR: Ingresa una opción correcta.");
					menu();
				}
			}
		} catch (InputMismatchException e) {
			System.err.println("ERROR: Se está esperando un valor numérico..");
			menu();
		}
		System.out.println("Saliendo...");

	}

	
	public static void main(String[] args) {
		/*Gato g1 = new Gato("Juan", "3456789K", 5, "2045-06-10", "Gris", "L");
		Gato g2 = new Gato("Pepe", "3233289K", 5, "2045-06-10", "Gris", "C");
		Perro p1 = new Perro("Firulais", "4562457O", 8, "2022-45-23", "Gran Danés", false);
		
		System.out.println(g1.toString());
		System.out.println(g2.toString());
		System.out.println(p1.toString());
*/
		Main principal = new Main();
		
		
		principal.menu();
	}

}

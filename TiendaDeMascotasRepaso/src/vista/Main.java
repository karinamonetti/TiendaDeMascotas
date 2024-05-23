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
	
	public Main () {
		mascotas.add(new Perro("Rex", "11223344D", 3, "2021-05-20", "Labrador", false));
		mascotas.add(new Perro("Bella", "55667788E", 5, "2019-09-15", "Beagle", true));
		mascotas.add(new Perro("Max", "99887766F", 2, "2022-11-10", "Bulldog", false));
		mascotas.add(new Gato("Luna", "12345678A", 2, "2022-03-15", "Blanco", "C"));
		mascotas.add(new Gato("Simba", "87654321B", 4, "2020-07-22", "Naranja", "L"));
		mascotas.add(new Gato("Milo", "12348765C", 1, "2023-01-01", "Gris", "M"));
	}
	
	/**
	 * [METODO] - menu()
	 */
	public void menu() {
	    Scanner sc = new Scanner(System.in);
	    boolean continuar = true;

	    // Utilizo un LOOP con una variable externa para que no me genere errores la recursividad
	    while (continuar) {
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
	            sc.nextLine();  

	            switch (opcion) {
	                case 0:
	                    continuar = false;
	                    System.out.println("Saliendo...");
	                    break;
	                case 1:
	                    controlDeEntrada.addMascota(mascotas);
	                    break;
	                case 2:
	                    controlDeEntrada.recorrerArrayMascotas(mascotas);
	                    break;
	                case 3:
	                	controlDeEntrada.modificarMascota(mascotas);
	                    break;
	                case 4:
	                	controlDeEntrada.eliminarMascotaPorId(mascotas);
	                    break;
	                case 5:
	                    System.out.println("5. Eliminar mascota por dueño");
	                    break;
	                case 6:
	                    System.out.println("6. Mostrar mascotas por dueño");
	                    break;
	                default:
	                    System.err.println("ERROR: Ingresa una opción correcta.");
	                    break;
	            }
	        } catch (InputMismatchException e) {
	            System.err.println("ERROR: Se está esperando un valor numérico.");
	            sc.nextLine(); 
	        }}
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

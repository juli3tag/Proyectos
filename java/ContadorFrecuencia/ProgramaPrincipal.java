package ContadorFrecuencia;

import java.util.Scanner;
import java.util.Stack;

public class ProgramaPrincipal {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		System.out.println("Bienvenido al contador de frecuencia!");

		// Definir el tamaño de la pila de palabras
		System.out.print("Ingrese el numero de palabras que desea almacenar en la pila: ");
		int numPalabras = scanner.nextInt();
		scanner.nextLine(); // Consumir salto de linea

		Stack<String> pilaPalabras = new Stack<>();

		// Ingresar palabras en la pila
		for (int i = 0; i < numPalabras; i++) {
			System.out.print("Ingrese la palabra " + (i + 1) + ": ");
			String palabra = scanner.nextLine();
			pilaPalabras.push(palabra);
		}

		// Mostrar todas las palabras almacenadas
		System.out.println("\nPalabras en la pila:");
		for (String palabra : pilaPalabras) {
			System.out.println(palabra);
		}

		// Proceso repetitivo para verificar la frecuencia de letras
		boolean continuar = true;
		while (continuar) {
			System.out.print("\nIngrese la posicion (1 a " + numPalabras
					+ ") de la palabra para contar la frecuencia de letras (o ingrese 0 para salir): ");
			int posicion = scanner.nextInt() - 1;

			if (posicion == -1) {
				// Si el usuario ingresa 0 (restado da -1), salimos del bucle
				continuar = false;
				System.out.println("Saliendo del programa...");
			} else if (posicion >= 0 && posicion < numPalabras) {

				// Creamos una pila temporal para manejar las palabras
				Stack<String> pilaTemporal = new Stack<>();
				String palabraSeleccionada = "";

				// Extraer palabras hasta la posicion deseada
				for (int i = 0; i < numPalabras - posicion - 1; i++) {
					pilaTemporal.push(pilaPalabras.pop());
				}
				palabraSeleccionada = pilaPalabras.pop();

				// Devolver palabras a la pila original
				while (!pilaTemporal.isEmpty()) {
					pilaPalabras.push(pilaTemporal.pop());

				}

				ContadorFrecuencia contador = new ContadorFrecuencia();
				int[] frecuencias = contador.contarFrecuencia(palabraSeleccionada);

				// Imprimir frecuencias
				System.out.println("\nFrecuencia de letras en la palabra '" + palabraSeleccionada + "':");
				for (int i = 0; i < frecuencias.length; i++) {
					if (frecuencias[i] != 0) {
						System.out.println((char) (i + 'A') + ": " + frecuencias[i]);
					}
				}
			} else {
				System.out.println("Posicion no valida. Intente de nuevo.");
			}

		}
	}
}
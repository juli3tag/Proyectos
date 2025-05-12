package ContadorFrecuencia;


import java.util.Scanner;

// Julieta Maiara Gonzalez Gutierrez 🌷

public class Exc2 {

	private static Scanner teclado;

	public static void main(String[] args) {

		teclado = new Scanner(System.in);
		boolean continuar = true;
		
		System.out.println("¡Bienvenido al contador de frecuencia!");

		while (continuar) {

			int[] conteos = new int[26]; // Array para contar letras de la A a la Z
			// Leer palabra del usuario
			System.out.print("Para comenzar, ingrese una palabra (se permiten caracteres): ");
			String palabra = teclado.nextLine();

			// Convertir a mayusculas
			palabra = palabra.toUpperCase();

			// Contar la frecuencia de cada letra...
			for (int i = 0; i < palabra.length(); i++) {
				try {
						conteos[palabra.charAt(i) - 'A']++;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Ups! '" + palabra.charAt(i) + "' no es una letra");
				}
			}

			// Imprimir frecuencias...
			System.out.println("\nFrecuencia de letras:");
			for (int i = 0; i < conteos.length; i++) {
				if (conteos[i] != 0) {
					System.out.println((char) (i + 'A') + ": " + conteos[i]);
				}
			}

			System.out.println("¿Quieres ingresar otra palabra? (s/n): ");
			String respuesta = teclado.nextLine().trim().toLowerCase();
			continuar = respuesta.equals("s");
		}
		System.out.println("¡Gracias por usar el programa! Saliendo...");
	}
}

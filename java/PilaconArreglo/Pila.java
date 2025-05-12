package PilaconArreglo;

// Gonzalez Gutierrez Julieta Maiara 🌷

// Consigna: Implementar una Pila usando un Arreglo
 
import java.util.Scanner;

public class Pila {
	private int[] pila; // Arreglo para almacenar los elementos de la pila
	private int tope; // Indice que representa la posicion del ultimo elemento
	private int capacidad; // Capacidad maxima de la pila
	
	// Constructor que inicializa la pila con el tamaño dado
	public Pila(int tamaño) {
		capacidad = tamaño;
		pila = new int[capacidad];
		tope = -1; // La pila comienza vacia, por lo que el tope es -1
	}
	
	// Metodo para insertar un valor en la pila
	public void push(int valor) {
		if (tope == capacidad - 1) { // Verifica si la pila esta llena
			System.out.println("La pila esta llena.");
		} else {
			pila[++tope] = valor; // Incrementa el rope y agrega el valor en la nueva posicion
			System.out.println("Valor apilado: " + valor);
		}
	}
	
	// Metodo para sacar un valor de la pila
	public int pop() {
		if (tope == -1) { // Verificar si la pila esta vacia
			System.out.println("La pila esta vacia.");
			return -1; // Devolver un valor de error
		} else {
			System.out.println("Valor retirado: " + pila[tope]);
			return pila[tope--]; // Devolver el valor tope y disminuir el indice del tope
		}
	}
	
	// Metodo para verificar si la pila esta vacia
	public boolean isEmpty() {
		return tope == -1; // La pila esta vacia si el tope es -1
	}
	
	// Metodo para mostrar los valores actualmente almacenados en la pila
	public void mostrarValores() {
		if (tope == -1) { // Verificar si la pila esta vacia
			System.out.println("La pila esta vacia.");
		} else {
			System.out.println("Elementos en la pila:");
			System.out.println("TOPE");
			for (int i = tope; i >= 0; i--) { // Recorrer desde el tope hacia el fondo
				System.out.println(pila[i]);
			}
			System.out.println("FONDO");
		}
	}
	
	// Metodo principal para interactuar con la pila utilizando el menu
	public static void main (String[] args) {
		Scanner scanner = new Scanner (System.in);
		System.out.print("Ingrese el tamaño de la pila: ");
		int tamaño = scanner.nextInt(); // Leer el tamaño de la pila
		
		Pila pila = new Pila(tamaño); // Crear una instancia de pila con el tamaño indicado
		
		while (true) {
			// Mostrar el menu de opciones
			System.out.println("\n--- Menu de Opciones ---");
			System.out.println("1. Apilar un valor");
			System.out.println("2. Retirar un valor");
			System.out.println("3. Verificar si la pila esta vacia");
			System.out.println("4. Mostrar valores ingresados");
			System.out.println("5. Salir del programa");
			System.out.print("Seleccion una opcion: ");
			int opcion = scanner.nextInt(); // Leer la opcion seleccionada
			
			// Procesar la opcion seleccionada
			switch (opcion) {
			case 1:
				System.out.print("Ingrese un valor para apilar: ");
				int valor = scanner.nextInt();
				pila.push(valor); // Llamar al metodo para apilar el valor ingresado
				break;
			
			case 2:
				pila.pop(); // Llamar al metodo para retirar el valor del tope ed la pila
				break;
				
			case 3:
				// Verificar si la pila esta vacia e informar al usuario
				if (pila.isEmpty()) {
					System.out.println("La pila se encuentra vacia, utiliza la opcion 1 para agregar valores");
				} else {
					System.out.println("La pila no esta vacia.");
				}
				break;
			
			case 4:
				pila.mostrarValores(); // Llamar al metodo para mostrar los valores
				break;
				
			case 5:
				System.out.println("¡Hasta pronto! Cerrando programa...");
				scanner.close(); // Cerrar el escaner
				return; // Terminar el programa
			
			default:
					System.out.println("¡Ups, opcion no valida! Selecciona una opcion del menu."); // Informar que la opcion es invalida
					break;
			}
		}
	}
}

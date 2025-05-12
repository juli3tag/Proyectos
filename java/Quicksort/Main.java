package Quicksort;

// Clase principal que contiene el metodo main y los metodos de ordenamienrto e impresion
public class Main {
	
	// Metodo quicksort que ordena el arreglo de equipos utilizando el algoritmo Quicksort
	public static void quicksort(Equipo[] equipos, int low, int high) {
		if (low < high) {
			// pi es el indice de particion
			int pi = particion(equipos, low, high);
			// Ordenar los elementos por separado antes y despues de la particion
			quicksort(equipos, low, pi - 1);
			quicksort(equipos, pi + 1, high);
		}
	}
	
	/*  Metodo particion que toma el ultimo elemento como pivote, coloca el pivote en 
	 *  su posicion correcta en el arreglo ordenado, y coloca todos los elementos 
	 *  mayores que el pivote a su izquierda y todos los menores a la derecha
	 */
	public static int particion(Equipo[] equipos, int low, int high) {
		Equipo pivote = equipos[high]; // Elegir el ultimo elemento como pivote
		int i = (low - 1); // Indice del elemento mas pequeño
		for (int j = low; j < high; j++) {
			// Si el elemento actual es mayor que el pivote
			if (equipos[j].puntos > pivote.puntos) {
				i++;
				// intercambiar equipos[i] y equipos[j]
				Equipo temp = equipos[i];
				equipos[i] = equipos[j];
				equipos[j] = temp;
			}
		}
		// intercambiar equipos[i+1] y equipos[high] (o el pivote)
		Equipo temp = equipos[i + 1];
		equipos[i+1] = equipos[high];
		equipos[high] = temp;
		return i + 1;
	}
	
	// Metodo para imprimir la tabla de posiciones
	public static void imprPosiciones (Equipo[] equipos) {
		System.out.printf("%-5s %-20s %-5s\n", "#", "Equipo", "Puntos");
		System.out.println("------------------------------------------");
		for (int i = 0; i< equipos.length; i++) {
			System.out.printf("%-5s %-20s %-5s\n", (i + 1), equipos[i].nombre, equipos[i].puntos);
		}
	}
	
	// Metodo main
	public static void main(String[] args) {
		
		System.out.println("Tabla de posiciones de la Copa América 2024:");
		System.out.println(" ");
		
		// Imprimimos datos de prueba
		Equipo[] equipos = {
				new Equipo("Peru", 1),
				new Equipo("Estados Unidos", 3),
				new Equipo("Uruguay", 9),
				new Equipo("Canada", 4),
				new Equipo("Chile", 2),
				new Equipo("Argentina", 9),
				};
		
		// Imprimimos las posiciones antes de aplicar el metodo de ordenamiento
		System.out.println("Posiciones antes del ordenamiento:");
		imprPosiciones(equipos);
		
		// Se ordenan los equipos usando Quicksort
		quicksort(equipos, 0, equipos.length - 1);
		
		// Imprimimos las posiciones despues del ordenamiento
		System.out.println(" ");
		System.out.println("Posiciones despues del ordenamiento:");
		imprPosiciones(equipos);

	}
}


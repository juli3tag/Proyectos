package Ordenamiento;
public class QuickSort {

    //Nombre: Julieta Maiara Gonzalez Gutierrez 🌷
	
	/*Esta funcion toma el ultimo elemento como pivote
	 * coloca el elemento pivote en su posicion correcta en 
	 * la matriz ordenada y coloca todos los elementos mas 
	 * pequeños (mas pequeños que el pivote) a la izquierda
	 * del pivote y todos los elementos mayores a la derecha
	 * del pivote
	 */
	
	int particion(int arr[], int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); //Indice del elemento mas chico
		for (int j = low; j < high; j++) {
			//Si el elemento actual es mas pequeño o igual que el pivote
			if(arr[j] <= pivot) {
				i++;
				
				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		//Intercambia arr[i+1] y arr[high] (o pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
	
	/* Metodo principal que implementa QuickSort 
	 * arr[] ---> Array a ser ordenado,
	 * low ---> Comienzo de indice,
	 * high ---> Fin de indice */
	
	void ordenar(int arr[], int low, int high) {
		if (low < high) {
			//Encuentra el indice del elemento pivote que se usara para dividir la matriz
			int pi = particion(arr, low, high);
			
			//Ordena los elementos antes y despues del pivote recursivamente
			ordenar(arr, low, pi - 1);
			ordenar(arr, pi + 1, high);
		}
	}

}

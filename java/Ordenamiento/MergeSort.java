package Ordenamiento;
public class MergeSort {

    //Nombre: Julieta Maiara Gonzalez Gutierrez 🌷
	
	/* Mezcla 2 subarrays arr[]
	 * El primer subarray es arr[1...m]
	 * El segundo subarray es arr[m+1..r] */
	
	void mezclar(int arr[], int l, int m, int r) {
		//Obtiene el tamaño de los 2 subarrays a ser mezclados
		int n1 = m - l + 1;
		int n2 = r - m;
		
		//Crea arrays temporales
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		//Copia los datos a los array temporales
		for (int i = 0; i < n1; ++i) {
			L[i] = arr[l + i];
		}
		for (int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}
		
		//Mezcla los array temporales
		
		//Indices iniciales del primer y segundo subarray
		int i = 0, j = 0;
		
		//Indices iniciales de los subarrays mezclados
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
			
		//Copiar los elementos pendientes de L[] si hay
		while (i < n1) {
				arr[k] = L[i];
				i++;
				k++;
		}
			
		//Copiar los elementos pendientes de R[] si hay
		while (j < n2) {
				arr[k] = R[j];
				j++;
				k++;
		}
	}
		
		
	//Funcion principal que ordena arr[1...r] usando mezclar()
	void ordenar(int arr[], int l, int r) {
		if (l < r) {
			//Encuentra el punto medio para dividir la matriz en dos mitades
			int m = (l + r) / 2;
				
			//Ordena la primera y segunda mitad de manera recursiva
			ordenar(arr, l, m);
			ordenar(arr, m + 1, r);
				
			// Une las mitades ordenadas
			mezclar(arr, l, m, r);
		}
	}
		
		//Una funcion que sirve para mostrar un array tamaño n
		static void MostrarArray(int arr[]) {
			int n = arr.length;
			for (int i = 0; i < n; ++i) {
				System.out.print(arr[i] + " ");
			}
			System.out.println(); //Imprime una nueva linea al final
	}
	
}

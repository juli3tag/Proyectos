package Hash;
public class Hash {
	
	// Julieta Maiara Gonzalez Gutierrez 🌷

	int dato;
	int estado; // 0 = Vacio, 1 = Eliminado, 2 = Ocupado
	
	static int FuncionHash (int n, int m) {
		// Se utiliza una funcion hash simple que toma el residuo de la division del numero por el tamaño de la tabla
		return n % m;
	}
	
	static void insertaHash(Hash[]h, int m, int n) {
		boolean i = false;
		int j = FuncionHash(n,m);
		do {
			if (h[j].estado==0||h[j].estado==1) {
				h[j].dato = n;
				h[j].estado = 2;
				i = true;
			} else {
				j++;
			}
		} while (j < m && !i);
		if (i) {
			System.out.println("Elemento " + n + " insertado con exito!");
		} else {
			System.out.println("Tabla llena!!! //n");
		}
	}
	
	static int buscaHash(Hash[]h, int m, int n) {
		// Se calcula la posicion inicial utilizando la funcion hash
		int j = FuncionHash(n, m);
		int contador = 0; // Variable para evitar bucles infinitos
						  // si la tabla esta llena o no se encuentra el elemento
		
		// Se recorre la tabla hasta encontrar un estado vacio o hasta haber recorrido toda la tabla
		while (h[j].estado != 0 && contador < m) {
			// Si se encuentra el elemento y esta marcado como ocupado, se devuelve su valor
			if (h[j].estado == 2 && h[j].dato == n) {
				return j;
			}
			// Si no se encontro el elemento o esta marcado como eliminado, se pasa al siguiente elemento (linear probing)
			j = (j + 1) % m;
			contador++;
		}
		
		// Si se recorrio toda la tabla y no se encontro el elemento, se devuelve -1
		return -1;
	}
	
	
	static int eliminaHash(Hash[]h, int m, int n) {
		int i = buscaHash(h, m, n);
		if (i == -1) {
			return -1;
		} else {
			h[i].estado = 1;
			return 1;
		}
	}
	
	public static void main(String[] args) {
		int i, n, elemento;
		
		// Tabla de la tabla hash
		int m = 15;
		
		Hash[] h = new Hash[m];
		for (i = 0; i < m; i++) {
			h[i] = new Hash();
			h[i].estado = 0; // Inicializar todos los elementos como vacios
		}
		
		// Insertar elementos en la tabla hash
		System.out.println("Insertando elementos en la tabla hash...");
		Hash.insertaHash(h, m, 15);
		Hash.insertaHash(h, m, 130);
		Hash.insertaHash(h, m, 7);
		Hash.insertaHash(h, m, 32);
		
		//Buscar un elemento en la tabla hash
		elemento = 7;
		i = Hash.buscaHash(h, m, elemento);
		if (i != -1) {
			System.out.println("El elemento " + elemento + " se encontro en la posicion " + i + " de la tabla hash.");	
		} else {
			System.out.println("El elemento " + elemento + " no se encontro en la tabla hash.");
		}
		
		// Eliminar un elemento de la tabla hash
		int elementoAEliminar = 130;
		int resultadoEliminacion = Hash.eliminaHash(h, m, elementoAEliminar);
		if (resultadoEliminacion != -1) {
			System.out.println("El elemento " + elementoAEliminar + " fue eliminado de la tabla hash.");
		} else {
			System.out.println("El elemento " + elementoAEliminar + " no se encontro en la tabla hash.");
		}
	}
	
}

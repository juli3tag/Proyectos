package Arboles.ArbolBinario;

//Definición de la clase NodoBinario
class NodoBinario {

    // Julieta Maiara Gonzalez Gutierrez 🌷
    
	int dato;
	NodoBinario Hizq, Hder;

	// Constructor
	NodoBinario(int Elem) {
		// Dato a almacenar
		dato = Elem;
		// Definición de hijos
		Hizq = null;
		Hder = null;
	}
}

//Definición de la clase Arbol
class Arbol {
	NodoBinario Padre;
	public NodoBinario Raiz;

	// Constructor
	public Arbol() {
		Raiz = null;
	}

	// Inserción de un hijo izquierdo
	public NodoBinario InsertaNodoHizq(NodoBinario Nodo, int Elem) {
	    NodoBinario result = null;
	    int Elemento = Elem; // Uso directo de int en lugar de Integer
	    if (Nodo == null) {
	        NodoBinario NodoAux = new NodoBinario(Elem);
	        result = NodoAux;
	        Raiz = NodoAux;
	    } else {
	        if (Nodo.Hizq == null) {
	            NodoBinario NodoAux = new NodoBinario(Elem);
	            Nodo.Hizq = NodoAux;
	            result = NodoAux;
	        } else {
	            // Se elimina la necesidad de toString() en Integer, uso directo de int
	            System.out.print("ERR- Hijo izquierdo de " + Elemento + " no es nulo");
	        }
	    }
	    return result;
	}


	// Inserción de un hijo derecho
	public NodoBinario InsertaNodoHDer(NodoBinario Nodo, int Elem) {
	    NodoBinario result = null;
	    int Elemento = Elem; // Uso directo de int en lugar de Integer
	    if (Nodo == null) {
	        NodoBinario NodoAux = new NodoBinario(Elem);
	        result = NodoAux;
	        Raiz = NodoAux;
	    } else {
	        if (Nodo.Hder == null) {
	            NodoBinario NodoAux = new NodoBinario(Elem);
	            Nodo.Hder = NodoAux;
	            result = NodoAux;
	        } else {
	            // Se elimina la necesidad de toString() en Integer, uso directo de int
	            System.out.print("ERR- Hijo derecho de " + Elemento + " no es nulo");
	        }
	    }
	    return result;
	}


	// Inorden Recursivo del Árbol
	public void Inorden(NodoBinario Nodo) {
		if (Nodo != null) {
			Inorden(Nodo.Hizq); // Recorrer subárbol izquierdo
			System.out.print(Nodo.dato + " "); // Visitar nodo
			Inorden(Nodo.Hder); // Recorrer subárbol derecho
		}
	}

	// Altura del Árbol
	public int Altura(NodoBinario Nodo) {
		if (Nodo == null) {
			return 0; // Si el nodo es nulo, la altura es 0
		} else {
			// Recursivamente se calcula la altura de los subárboles izquierdo y derecho
			int alturaIzq = Altura(Nodo.Hizq);
			int alturaDer = Altura(Nodo.Hder);
			
			// La altura del nodo actual es la mayor entre las alturas de sus subárboles, más 1
			return Math.max(alturaIzq, alturaDer) + 1;
		}
	}
}

class ArbolBinario {
	public static void main(String[] arg) {
		Arbol A = new Arbol();
		System.out.println("==================================");
		System.out.println("      Construcción del Árbol      ");
		System.out.println("==================================");

		System.out.println("\nAgregando la raíz 30\n");
		NodoBinario NodoAux = null, NodoAux2 = null, NodoAux3 = null, NodoAux4 = null;

		// Inserciones en el árbol
		NodoAux2 = A.InsertaNodoHizq(NodoAux, 30); // Inserta la raíz
		System.out.println("Raíz añadida: 30");

		NodoAux = NodoAux2;
		NodoAux2 = A.InsertaNodoHizq(NodoAux, 25); // Inserta hijo izquierdo
		System.out.println("Hijo izquierdo añadido a 30: 25");

		NodoAux3 = A.InsertaNodoHDer(NodoAux, 45); // Inserta hijo derecho
		System.out.println("Hijo derecho añadido a 30: 45");

		NodoAux = NodoAux2;
		NodoAux2 = A.InsertaNodoHizq(NodoAux, 20); // Inserta hijo izquierdo del nodo anterior
		System.out.println("Hijo izquierdo añadido a 25: 20");

		NodoAux4 = A.InsertaNodoHDer(NodoAux, 27); // Inserta hijo derecho del nodo anterior
		System.out.println("Hijo derecho añadido a 25: 27");

		System.out.println("\n==================================");
		System.out.println("   Recorrido Inorden del Árbol    ");
		System.out.println("==================================");
		System.out.print("Inorden: ");
		A.Inorden(A.Raiz);

		// Cálculo de la altura del árbol
		Integer Altura = A.Altura(A.Raiz); 
		System.out.println("\n\n==================================");
		System.out.println("        Altura del Árbol          ");
		System.out.println("==================================");
		System.out.print("La altura del árbol es: " + Altura.toString() + "\n");
	}
}

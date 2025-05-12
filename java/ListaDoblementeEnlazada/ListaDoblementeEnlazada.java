package ListaDoblementeEnlazada;

// Gonzalez Gutierrez Julieta Maiara 🌷

//Clase para manejar una Lista Doblemente Enlazada de Productos ordenados por código
public class ListaDoblementeEnlazada {
	Nodo inicio; // Referencia al primer nodo de la lista
    Nodo fin; // Referencia al último nodo de la lista
    
 // Constructor para inicializar una lista vacía
    public ListaDoblementeEnlazada() {
        this.inicio = null;  // Inicialmente la lista está vacía
        this.fin = null;  // Inicialmente la lista está vacía
    }
    
 // Método para insertar un Producto en la lista de manera ordenada por código
    public void insertarOrdenado(Producto producto) {
        Nodo nuevoNodo = new Nodo(producto);  // Crear un nuevo nodo con el producto

        if (inicio == null) {   // Si la lista está vacía
            inicio = nuevoNodo;  // El nuevo nodo se convierte en el primero
            fin = nuevoNodo;   // Y también en el último nodo
        } else {
            Nodo actual = inicio;  // Comenzar desde el inicio de la lista
            while (actual != null) {
                if (producto.codigo < actual.producto.codigo) {
                	// Insertar el nuevo nodo antes del nodo actual
                    nuevoNodo.siguiente = actual;  // El siguiente del nuevo nodo es el actual
                    nuevoNodo.anterior = actual.anterior; // El anterior es el anterior del actual
                    
                    if (actual.anterior == null) {
                        inicio = nuevoNodo;  // El nuevo nodo se convierte en el inicio de la lista
                    } else {
                        actual.anterior.siguiente = nuevoNodo; // Ajustar el enlace del nodo anterior
                    }
                    actual.anterior = nuevoNodo; // Ajustar el enlace del actual
                    return;  // Salir del método después de insertar
                } else if (producto.codigo == actual.producto.codigo) {
                	// Si el código ya existe, imprimir un error y no insertar
                    System.err.println("Error: El código " + producto.codigo + " ya existe.");
                    return;
                }
                actual = actual.siguiente;   // Mover al siguiente nodo
            }
         // Si llegamos al final de la lista, insertar al final
            fin.siguiente = nuevoNodo;  // El siguiente del último nodo es el nuevo nodo
            nuevoNodo.anterior = fin;  // El anterior del nuevo nodo es el último nodo
            fin = nuevoNodo;  // El nuevo nodo se convierte en el último nodo
        }
    }
    
    // Método para imprimir los elementos de la lista
    public void imprimirLista() {
        Nodo actual = inicio; // Comenzar desde el inicio de la lista
        System.out.println("Código     Descripción                      Precio");  // Imprimir cabecera de la tabla
        System.out.println("-----------------------------------------------------");
        while (actual != null) { // Recorrer la lista hasta el final
            System.out.println(actual.producto); // Imprimir el producto actual
            actual = actual.siguiente;  // Mover al siguiente nodo
        }
        System.out.println("-----------------------------------------------------");
    }
}

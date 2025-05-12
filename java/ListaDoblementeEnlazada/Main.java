package ListaDoblementeEnlazada;

// Gonzalez Gutierrez Julieta Maiara 🌷

public class Main {
	/*
	 * Clase principal que instancia ListaDoblementeEnlazada, inserta productos
	 *  de prueba (incluyendo un código repetido para probar la detección de
	 *   errores), y luego imprime la lista de productos ordenados por código.
	 */
	
	public static void main(String[] args) {
		// Crear una instancia de la lista doblemente enlazada
        ListaDoblementeEnlazada listaProductos = new ListaDoblementeEnlazada();

        listaProductos.insertarOrdenado(new Producto(101, "Producto A", 500.0));
        listaProductos.insertarOrdenado(new Producto(103, "Producto C", 300.0));
        listaProductos.insertarOrdenado(new Producto(102, "Producto B", 400.0));
        listaProductos.insertarOrdenado(new Producto(105, "Producto E", 200.0));
        listaProductos.insertarOrdenado(new Producto(104, "Producto D", 250.0));
        listaProductos.insertarOrdenado(new Producto(101, "Producto Repetido", 60.0));
        
     // Imprimir la lista de productos ordenados por código
        System.out.println("Lista de Productos:");
        listaProductos.imprimirLista();
    }
}

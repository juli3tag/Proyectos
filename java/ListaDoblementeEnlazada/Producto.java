package ListaDoblementeEnlazada;

// Gonzalez Gutierrez Julieta Maiara 🌷

//Clase para representar un Producto con código, descripción y precio
public class Producto {
	int codigo; // Código del producto
    String descripcion; // Descripción del producto
    double precio; // Precio del producto
    
 // Constructor para inicializar un Producto con sus atributos
    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
 // Método para devolver una representación formateada del producto
    @Override
    public String toString() {
    	// Formatea el producto en una cadena de texto con espacios para alineación
        return String.format("%-10d %-30s $%10.2f", codigo, descripcion, precio);
    }
}

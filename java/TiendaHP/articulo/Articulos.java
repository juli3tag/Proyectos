package TiendaHP.articulo;

// Gonzalez Gutierrez Julieta Maiara 🌷

public class Articulos {

    private String nombre; //Variable que tendra el nombre del producto
    private int cantidad; //Cantidad de unidades del producto
    private double precioUnidad; //Establece el precio de cada unidad

    public Articulos() {
    }

    public Articulos(String nombre, int cantidad, double precioUnidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    

    public boolean vendido(int cantidadVendida) {
    if (cantidadVendida <= 0) {
        System.out.println("La cantidad vendida debe ser mayor a cero.");
        return false;
    }

    if (this.cantidad >= cantidadVendida) {
        this.cantidad -= cantidadVendida;
        return true;
    } else {
        System.out.println("No hay suficiente stock para realizar la venta.");
        return false;
        }
}



    @Override
public String toString() {
    return String.format("Nombre: %s | Cantidad: %d | Precio: $%.2f", nombre, cantidad, precioUnidad);
}

    
    
     
    
}

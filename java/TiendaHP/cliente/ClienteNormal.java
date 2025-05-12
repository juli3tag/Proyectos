package TiendaHP.cliente;

// Gonzalez Gutierrez Julieta Maiara 🌷

public class ClienteNormal extends Cliente {

    public ClienteNormal(String nombre, String apellido, String celCliente) {
        super(nombre, apellido, celCliente);
    }

    @Override
    public double calcularDescuento() {
        return 0.0; // Los clientes normales no tienen descuento
    }
}

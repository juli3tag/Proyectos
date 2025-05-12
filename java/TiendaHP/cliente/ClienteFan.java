package TiendaHP.cliente;

// Gonzalez Gutierrez Julieta Maiara 🌷

// Subclase ClienteFan que extiende Cliente
   public class ClienteFan extends Cliente {
       
    private int nivelFan;

    public ClienteFan(int nivelFan, String nombre, String apellido, String celCliente) {
        super(nombre, apellido, celCliente);
        this.nivelFan = nivelFan;
    }
    
    
    @Override
    public double calcularDescuento() {
        // Lógica para calcular el descuento específico para clientes fan
        // Puedes personalizar esta lógica según tus necesidades
        if (nivelFan >= 3) {
            return 0.15; // Por ejemplo, un 15% de descuento para Clientes Fan de nivel 3 o superior
        } else {
            return 0.1; // Por ejemplo, un 10% de descuento para Clientes Fan de nivel 2 o inferior
        }
    }
}
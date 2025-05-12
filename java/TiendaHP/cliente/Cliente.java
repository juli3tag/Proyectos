package TiendaHP.cliente;

// Gonzalez Gutierrez Julieta Maiara 🌷

public abstract class Cliente {
    private static int contadorId = 1; // Contador para asignar IDs únicos
    private int id;
    private String nombre; //Establece el nombre del cliente
    private String apellido; //Establece el apellido del cliente
    private String celCliente; //Establece el numero de telefono del cliente

    public Cliente(String nombre, String apellido, String celCliente) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celCliente = celCliente;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelCliente() {
        return celCliente;
    }

    public void setCelCliente(String celCliente) {
        this.celCliente = celCliente;
    }

  public abstract double calcularDescuento();
    
  @Override
    public String toString() {
        return "Cliente [ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Teléfono: " + celCliente + "]";
    }
}

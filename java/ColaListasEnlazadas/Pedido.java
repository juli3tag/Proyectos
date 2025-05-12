package ColaListasEnlazadas;

// Gonzalez Gutierrez Julieta Maiara 🌷

public class Pedido {
	int codigo;
	String cliente;
	int cantidad;
	
	public Pedido(int codigo, String cliente, int cantidad) {
		this.codigo = codigo;
		this.cliente = cliente;
		this.cantidad = cantidad;
	}
	
	public String toString() {
		return String.format("Codigo: %d, Cliente: %s, Cantidad: %d", codigo, cliente, cantidad);
	}
}

package ColaListasEnlazadas;

public class FabricaDeLadrillos {

    // Gonzalez Gutierrez Julieta Maiara 🌷

	public static void main(String[] args) {
		Cola colaDePedidos = new Cola(); // Crear una nueva cola de pedidos

		System.out.println("*** Pedidos de Ladrillos Realizados ***");

		// Creamos algunos pedidos de prueba
		Pedido pedido1 = new Pedido(1, "Julieta", 100);
		Pedido pedido2 = new Pedido(2, "Nicolas", 200);
		Pedido pedido3 = new Pedido(3, "Brenda", 300);
		Pedido pedido4 = new Pedido(4, "Juan", 400);

		// Agregamos los pedidos a la cola
		System.out.println("\n--- Encolando Pedidos ---");
		colaDePedidos.encolar(pedido1);
		colaDePedidos.encolar(pedido2);
		colaDePedidos.encolar(pedido3);
		colaDePedidos.encolar(pedido4);

		// Mostrar todos los pedidos en la cola
		System.out.println(" ");
		System.out.println("Pedidos en la cola:");
		colaDePedidos.mostrar();

		// Procesamos los pedidos
		System.out.println("\n--- Procesando Pedidos ---");
		colaDePedidos.desencolar();
		colaDePedidos.desencolar();

		// Verificar si quedan pedidos por procesar
		System.out.println("\n--- Estado de la Cola ---");
		if (colaDePedidos.estaVacia()) {
			System.out.println("Todos los pedidos han sido procesados.");
		} else {
			System.out.println("Aún hay pedidos por procesar.");
			// Mostrar los pedidos restantes en la cola
			colaDePedidos.mostrar();

			System.out.println("\nProcesando los pedidos restantes:");
			while (!colaDePedidos.estaVacia()) {
				colaDePedidos.desencolar();
			}
		}

		// Revisión final de la cola
		System.out.println("\n--- Revisión Final de la Cola ---");
		if (colaDePedidos.estaVacia()) {
			System.out.println("La cola está vacía, todos los pedidos han sido procesados.");
		} else {
			System.out.println("Quedan pedidos en la cola:");
			colaDePedidos.mostrar();
		}
	}
}

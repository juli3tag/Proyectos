package TiendaHP.tiendamundomagicohp;

import TiendaHP.articulo.Articulos;
import TiendaHP.cliente.Cliente;
import TiendaHP.cliente.ClienteFan;
import TiendaHP.cliente.ClienteNormal;
import java.util.*;

// Gonzalez Gutierrez Julieta Maiara 🌷

public class TiendaMundoMagicoHP {

    static Hashtable<String, Articulos> arraylist = new Hashtable<>();
    private static int totalVentas = 0;
    private String nombreTienda;
    private static List<Cliente> listaClientes = new ArrayList<>();

    public TiendaMundoMagicoHP() {}

    public TiendaMundoMagicoHP(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getNombreTienda() {
    return nombreTienda;
}

    public void registrarCliente(Cliente nuevoCliente) {
        listaClientes.add(nuevoCliente);
    }

    public void inserta(Articulos a) {
        String clave = a.getNombre();

        if (!arraylist.containsKey(clave)) {
            arraylist.put(clave, a);
            System.out.println("Se añadió correctamente el artículo a la lista.");
        } else {
            System.out.println("El artículo ya se encuentra en el inventario.");
        }
    }

    public Articulos busca(String nombre) {
        if (arraylist.containsKey(nombre)) {
            System.out.println("Artículo encontrado.");
            return arraylist.get(nombre);
        } else {
            System.out.println("Artículo no encontrado");
            return null;
        }
    }

    public double vende(String nombre, int numero) {
        Articulos a = busca(nombre);
        double vendido = 0;

        if (a != null && a.vendido(numero)) {
            vendido = numero * a.getPrecioUnidad();

            if (a.getCantidad() == 0) {
                arraylist.remove(nombre);
            }
        } else {
            vendido = -1; // Venta no realizada
        }

        return vendido;
    }

    public static void menu() {
    System.out.println("\n--- Menú ---");
    System.out.println("1. Agregar producto");
    System.out.println("2. Mostrar todos los artículos");
    System.out.println("3. Buscar un artículo");
    System.out.println("4. Vender");
    System.out.println("5. Total de ventas");
    System.out.println("6. Registrar cliente");
    System.out.println("7. Ver clientes");
    System.out.println("8. Convertir cliente en cliente fan");
    System.out.println("9. Salir");
    System.out.print("Seleccione una opción: ");
}


    public static void salir() {
        System.out.println("Saliendo del programa...");
        System.exit(0);
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        TiendaMundoMagicoHP miTienda = new TiendaMundoMagicoHP("Mundo Mágico");

        System.out.println(" ");
        System.out.println("Bienvenido a " + miTienda.getNombreTienda() + "!");

        int opcion;

        do {
            try {
                menu();
                opcion = Integer.parseInt(entrada.nextLine());

                switch (opcion) {
                    case 1 -> agregarProducto(entrada, miTienda);
                    case 2 -> mostrarArticulos();
                    case 3 -> buscarArticulo(entrada, miTienda);
                    case 4 -> venderProducto(entrada, miTienda);
                    case 5 -> System.out.println("Total de ventas realizadas: " + totalVentas);
                    case 6 -> registrarCliente(entrada, miTienda);
                    case 7 -> mostrarClientes();
                    case 8 -> convertirClienteFan(entrada, miTienda);
                    case 9 -> salir();
                    default -> System.out.println("Opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingresá un número.");
            }
        } while (true);
    }

    private static void agregarProducto(Scanner entrada, TiendaMundoMagicoHP tienda) {
        try {
            System.out.println("Nombre del artículo:");
            String nombre = entrada.nextLine().trim();

            System.out.println("Cantidad:");
            int cantidad = Integer.parseInt(entrada.nextLine());

            System.out.println("Precio por unidad:");
            double precio = Double.parseDouble(entrada.nextLine());

            if (nombre.isEmpty() || cantidad <= 0 || precio <= 0) {
                System.out.println("Error: Datos inválidos.");
                return;
            }

            Articulos articulo = new Articulos(nombre, cantidad, precio);
            tienda.inserta(articulo);

        } catch (NumberFormatException e) {
            System.out.println("Error al ingresar cantidad o precio.");
        }
    }

    private static void mostrarArticulos() {
        if (arraylist.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        List<String> claves = new ArrayList<>(arraylist.keySet());
        Collections.sort(claves);
        System.out.println("Artículos en inventario:");

        for (String clave : claves) {
            System.out.println(arraylist.get(clave));
        }
    }

    private static void buscarArticulo(Scanner entrada, TiendaMundoMagicoHP tienda) {
        System.out.println("Nombre del artículo:");
        String nombre = entrada.nextLine();

        Articulos producto = tienda.busca(nombre);
        if (producto != null) {
            System.out.println(producto);
        }
    }

    private static void venderProducto(Scanner entrada, TiendaMundoMagicoHP tienda) {
    try {
        System.out.println("Nombre del artículo:");
        String nombreArticulo = entrada.nextLine();

        System.out.println("Cantidad a vender:");
        int cantidad = Integer.parseInt(entrada.nextLine());

        double precio = tienda.vende(nombreArticulo, cantidad);

        if (precio >= 0) {
            totalVentas++;

            System.out.println("¿El cliente ya está registrado? (Si/No):");
            String registrado = entrada.nextLine();

            if (registrado.equalsIgnoreCase("Si")) {
                System.out.println("Ingrese nombre del cliente:");
                String nombre = entrada.nextLine();
                System.out.println("Ingrese apellido del cliente:");
                String apellido = entrada.nextLine();

                Cliente clienteEncontrado = null;
                for (Cliente c : listaClientes) {
                    if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
                        clienteEncontrado = c;
                        break;
                    }
                }

                if (clienteEncontrado != null) {
                    if (clienteEncontrado instanceof ClienteFan) {
                        double descuento = ((ClienteFan) clienteEncontrado).calcularDescuento();
                        precio *= (1 - descuento);
                        System.out.println("Descuento aplicado. Total: " + precio + "$");
                    } else {
                        System.out.println("Cliente registrado sin descuento. Total: " + precio + "$");
                    }
                } else {
                    System.out.println("Cliente no encontrado. Venta sin descuento. Total: " + precio + "$");
                }

            } else {
                System.out.println("Venta realizada. Total: " + precio + "$");
            }

        } else {
            System.out.println("No se pudo realizar la venta. Verificá stock o nombre del artículo.");
        }

    } catch (NumberFormatException e) {
        System.out.println("Error: Ingrese un número válido.");
    }
}

private static void convertirClienteFan(Scanner entrada, TiendaMundoMagicoHP tienda) {
    System.out.println("Ingrese nombre del cliente:");
    String nombre = entrada.nextLine();

    System.out.println("Ingrese apellido del cliente:");
    String apellido = entrada.nextLine();

    Cliente clienteEncontrado = null;
    for (Cliente c : listaClientes) {
        if (c.getNombre().equalsIgnoreCase(nombre) && c.getApellido().equalsIgnoreCase(apellido)) {
            clienteEncontrado = c;
            break;
        }
    }

    if (clienteEncontrado != null) {
        if (clienteEncontrado instanceof ClienteFan) {
            System.out.println("Este cliente ya es un cliente fan.");
        } else {
            // Convertimos el cliente normal en cliente fan
            ClienteFan clienteFan = new ClienteFan(clienteEncontrado.getId(), clienteEncontrado.getNombre(), clienteEncontrado.getApellido(), clienteEncontrado.getCelCliente());
            listaClientes.remove(clienteEncontrado); // Eliminamos el cliente normal
            listaClientes.add(clienteFan); // Agregamos el cliente fan

            System.out.println("Cliente convertido a cliente fan con éxito.");
        }
    } else {
        System.out.println("Cliente no encontrado.");
    }
}


    private static void registrarCliente(Scanner entrada, TiendaMundoMagicoHP tienda) {
        System.out.println("Nombre del cliente:");
        String nombre = entrada.nextLine();

        System.out.println("Apellido del cliente:");
        String apellido = entrada.nextLine();

        System.out.println("Número de teléfono:");
        String celCliente = entrada.nextLine();

        Cliente nuevoCliente = new ClienteNormal(nombre, apellido, celCliente); 
        tienda.registrarCliente(nuevoCliente);
        System.out.println("Cliente registrado con éxito.");
    }

    private static void mostrarClientes() {
    if (listaClientes.isEmpty()) {
        System.out.println("No hay clientes registrados.");
        return;
    }

    for (Cliente cliente : listaClientes) {
        System.out.println("Nombre: " + cliente.getNombre());
        System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Teléfono: " + cliente.getCelCliente());

        if (cliente instanceof ClienteFan) {
            System.out.println("Tipo de cliente: Fan (con descuento)");
        } else {
            System.out.println("Tipo de cliente: Normal (sin descuento)");
        }

        System.out.println("------");
    }
}


}

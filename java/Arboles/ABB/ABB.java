package Arboles.ABB;

// Julieta Maiara Gonzalez Gutierrez 🌷

//Clase de Árbol Binario de Búsqueda
public class ABB {

 // Clase Nodo
 class Nodo {
     int clave;
     Nodo izquierda, derecha;

     public Nodo(int data) {
         clave = data;
         izquierda = derecha = null;
     }
 }

 // Nodo raíz, dato referencial
 Nodo raiz;

 // Constructor de ABB - se inicializa como árbol vacío
 ABB() {
     raiz = null;
 }

 // Borrar un Nodo de un Árbol ABB
 void borrarClave(int clave) {
     System.out.println("\n>> Intentando borrar la clave " + clave + "...");
     raiz = borrar_Recursivo(raiz, clave);
     System.out.println(">> Clave " + clave + " borrada correctamente (si estaba presente).\n");
 }

 // Borrado recursivo
 Nodo borrar_Recursivo(Nodo raiz, int clave) {
     if (raiz == null) return raiz;

     if (clave < raiz.clave)
         raiz.izquierda = borrar_Recursivo(raiz.izquierda, clave);
     else if (clave > raiz.clave)
         raiz.derecha = borrar_Recursivo(raiz.derecha, clave);
     else {
         if (raiz.izquierda == null)
             return raiz.derecha;
         else if (raiz.derecha == null)
             return raiz.izquierda;

         raiz.clave = ValorMinimo(raiz.derecha);
         raiz.derecha = borrar_Recursivo(raiz.derecha, raiz.clave);
     }
     return raiz;
 }

 /* Valor Minimo:
  * Este metodo recorre el subarbol izquierdo de un nodo dado para encontrar el valor mas pequeño.
  * Esto es necesario cuando se elimina un noso con dos hijos, ya que el sucesor In-Order debe
  * reemplazar al nodo eliminado.
  */
 
 int ValorMinimo(Nodo raiz) {
     int min = raiz.clave;
     while (raiz.izquierda != null) {
         min = raiz.izquierda.clave;
         raiz = raiz.izquierda;
     }
     return min;
 }

 void insertar(int clave) {
	 if (raiz == null) {
         raiz = insertar_Recursivo(raiz, clave);
         System.out.println(">> Árbol ABB creado con la clave raíz " + clave + ".\n");
     } else {
         raiz = insertar_Recursivo(raiz, clave);
         System.out.println(">> Clave " + clave + " insertada en el árbol.\n");
     }
 }

 /* insertar_Recursivo:
  * la funcion inserta un nodo en el arbol de manera recursiva. Si el arbol esta vacio, crea
  * un nuevo nodo. De lo contrario, busca el lugar adecuado para insertar el nodo, dependiendo
  * de si el valor de la clave es menor o mayor que la clave del nodo actual.
  */
 
 Nodo insertar_Recursivo(Nodo raiz, int clave) {
     if (raiz == null) {
         raiz = new Nodo(clave);
         return raiz;
     }

     if (clave < raiz.clave)
         raiz.izquierda = insertar_Recursivo(raiz.izquierda, clave);
     else if (clave > raiz.clave)
         raiz.derecha = insertar_Recursivo(raiz.derecha, clave);

     return raiz;
 }

 void inorder() {
     System.out.println("\nRecorrido In-Order del árbol ABB:");
     inorder_Recursivo(raiz);
     System.out.println("---------------------------");
 }

 void inorder_Recursivo(Nodo raiz) {
     if (raiz != null) {
         inorder_Recursivo(raiz.izquierda);
         System.out.print(raiz.clave + " ");
         inorder_Recursivo(raiz.derecha);
     }
 }

 boolean buscar(int clave) {
     System.out.println("\n>> Buscando la clave " + clave + " en el árbol...");
     boolean encontrado = buscar_Recursivo(raiz, clave) != null;
     if (encontrado) {
         System.out.println(">> Clave " + clave + " encontrada en el árbol.\n");
     } else {
         System.out.println(">> Clave " + clave + " NO encontrada en el árbol.\n");
     }
     return encontrado;
 }

 Nodo buscar_Recursivo(Nodo raiz, int clave) {
     if (raiz == null || raiz.clave == clave)
         return raiz;

     if (clave < raiz.clave)
         return buscar_Recursivo(raiz.izquierda, clave);

     return buscar_Recursivo(raiz.derecha, clave);
 }

 public static void main(String[] args) {
     ABB ABB = new ABB();

     // Agregar datos al ABB
     ABB.insertar(45);
     ABB.insertar(10);
     ABB.insertar(7);
     ABB.insertar(12);
     ABB.insertar(90);
     ABB.insertar(50);

     // Mostrar el árbol ABB
     ABB.inorder();

     // Borrar nodo hoja
     ABB.borrarClave(12);
     ABB.inorder();

     // Borrar el nodo con un solo hijo
     ABB.borrarClave(90);
     ABB.inorder();

     // Borrar nodo con 2 hijos
     ABB.borrarClave(45);
     ABB.inorder();

     // Buscar clave en el ABB
     ABB.buscar(50);
     ABB.buscar(12);
 }
 
 /* Realice algunos cambios en el codigo dado originalmente, asi como un diseño de
  * impresion mas amigable para el usuario y la creacion de las partes del codigo 
  * faltantes.
  */
}

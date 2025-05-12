package Arboles.Huffman;

import java.io.*;
import java.util.Scanner;

// Gonzalez Gutierrez Julieta Maiara 🌷

public class huffman {

	// Sub clase para manejar el arbol de Huffman
	class ArbolHuffman {
		// Clase nodo de arbol de huffman
		class NodoArbol {
			char clave; // Caracter almacenado en el nodo
			int frecuencia; // Frecuencia del caracter
			boolean esdato; // Flag que indica si es un nodo hoja
			NodoArbol izquierda, derecha; // Referencias a los nodos hijo

			public NodoArbol(char car, int frec, boolean EsD) {
				clave = car;
				frecuencia = frec;
				esdato = EsD;
				izquierda = derecha = null;
			}
		}

		// Clase nodo de una lista (lista de arboles)
		class NodoLista {
			public NodoArbol raiz; // Raiz del árbol
			public NodoLista siguiente; // Siguiente nodo en la lista

			public NodoLista(NodoArbol Nodo) {
				raiz = Nodo;
				siguiente = null;
			}
		}

		// Nodo inicial de la lista, dato referencial
		NodoLista NodoInicial;

		// Tabla Huffman para caracteres ASCCI
		int TablaHuffman[];
		// Tabla Huffman para las frecuencias
		String TablaHuffmanCodigos[];
		int tamañotabla = 0;  // Tamaño de la tabla

		// Convierte un byte en un entero no negativo
		int ByteToUnsignedByte(byte dato) {
			int resultado = (int) dato;
			if (dato < 0) {
				resultado = (int) dato + 256; // Ajusta el valor si es negativo
			}
			return resultado;
		}

		// Carga la tabla de frecuencias desde un archivo
		void CargarTablaDeArchivo(String NombreArchivo) {
			NodoInicial = null;
			TablaHuffman = new int[256];
			TablaHuffmanCodigos = new String[256];
			for (int i = 0; i <= 255; i++) {
				TablaHuffman[i] = 0;
				TablaHuffmanCodigos[i] = "";
			}

			System.out.println("Cargar archivo: " + NombreArchivo);
			try {
				RandomAccessFile file = new RandomAccessFile(NombreArchivo, "r");
				byte dato;
				int entero;
				long cont = 0;
				long tamaño = file.length();
				System.out.print("Tamaño: ");
				System.out.println(tamaño);
				// Contar frecuencias de cada byte en el archivo
				while (cont < tamaño) {
					file.seek(cont);
					dato = file.readByte();
					entero = ByteToUnsignedByte(dato);
					TablaHuffman[entero]++;
					cont++;
				}
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Contar caracteres unicos
			for (int i = 0; i <= 255; i++) {
				if (TablaHuffman[i] > 0) {
					tamañotabla++;
				}
			}

			System.out.print("Tamaño de la tabla: ");
			System.out.println(tamañotabla);
		}

		// Inserta un nodo en la lista de arboles de forma ordenada
		void InsertarNodoLista(NodoLista NodoAInsertar) {
			NodoLista AUXposnodo, AUXposnodoant, auxnodo;
			// Insertar el nodo en la lista
			if (NodoInicial == null) {
				NodoInicial = NodoAInsertar; // Lista vacia, inserta como primer nodo
			} else {
				AUXposnodo = NodoInicial;
				AUXposnodoant = null;

				// Buscar la posicion correcta para insertar el nuevo nodo
				while ((NodoAInsertar.raiz.frecuencia >= AUXposnodo.raiz.frecuencia) & (AUXposnodo.siguiente != null)) {
					AUXposnodoant = AUXposnodo;
					AUXposnodo = AUXposnodo.siguiente;
				}

				// Inserta el nodo en la posición correcta
				if (AUXposnodoant == null) {
					// Inserta al inicio si tiene menor frecuencia que el primer nodo
					if (NodoAInsertar.raiz.frecuencia >= AUXposnodo.raiz.frecuencia) {
						AUXposnodo.siguiente = NodoAInsertar;
						NodoAInsertar.siguiente = null;
					} else {
						NodoAInsertar.siguiente = NodoInicial;
						NodoInicial = NodoAInsertar;
					}

				} else {
					// Inserta en medio o al final
					if (NodoAInsertar.raiz.frecuencia >= AUXposnodo.raiz.frecuencia) {
						auxnodo = AUXposnodo.siguiente;
						AUXposnodo.siguiente = NodoAInsertar;
						NodoAInsertar.siguiente = auxnodo;
					} else {
						AUXposnodoant.siguiente = NodoAInsertar;
						NodoAInsertar.siguiente = AUXposnodo;
					}
				}
			}
		}

		// Muestra la lista de arboles y sus frecuencias
		void MostrarListaDeArboles() {
			NodoLista AUXnodo = NodoInicial;
			int count = 0;
			System.out.print("Lista de Arboles: ");
			while (AUXnodo != null) {
				count++;
				System.out.print(count);
				System.out.print("'" + AUXnodo.raiz.clave);
				System.out.print("(");
				System.out.print(AUXnodo.raiz.frecuencia);
				System.out.print("), ");
				AUXnodo = AUXnodo.siguiente;
			}
			System.out.println(" ");
		}

		// Crea la lista de arboles basada en la tabla de frecuencias
		void CrearListaDeArboles() {
			int entero;
			int pos = 0;
			char Caracter;
			NodoLista AUXultimonodo = NodoInicial, AUXposnodo, AUXposnodoant;
			System.out.println("Tabla: ");
			for (int i = 0; i <= 255; i++) {
				if (TablaHuffman[i] > 0) {
					pos++;
					Caracter = (char) i;

					// Crear un nodo raiz de arbol que contiene DATOS (flag en true)
					NodoArbol AUXNA = new NodoArbol((char) i, TablaHuffman[i], true);
					NodoLista AUXNL = new NodoLista(AUXNA);
					NodoLista AUXRECORIDONL;

					// Contenido ded la tabla
					System.out.print("Nodo ");
					System.out.print(pos);
					System.out.print(" " + (char) i + "(");
					System.out.print(TablaHuffman[i]);
					System.out.print("); ");

					InsertarNodoLista(AUXNL);
				}
			}
			System.out.println(" ");
			MostrarListaDeArboles();
		}

		// Reduce la lista a un solo arbol combinando los nodos
		void ProcesarListaDeArboles() {
			if (NodoInicial != null) {
				NodoLista AUXRECORIDONL, AUXNL1, AUXNL2, AUXNODOANT = null;
				NodoArbol AUXNAR1, AUXNAR2;
				AUXRECORIDONL = NodoInicial;
				// Verificar que exista la lista
				if (AUXRECORIDONL != null) {
					// Mientras la lista tenga mas de dos nodos, procesar.
					while (AUXRECORIDONL.siguiente != null) {

						// Buscar los 2 primeros nodos
						AUXNL1 = AUXRECORIDONL;
						AUXNL2 = AUXRECORIDONL.siguiente;

						// Asignar los arboles a cada nodo
						AUXNAR1 = AUXNL1.raiz;
						AUXNAR2 = AUXNL2.raiz;

						// Eliminar ambos nodos de la lista
						NodoInicial = AUXNL2.siguiente;

						// Crear un nuevo nodo raiz que tenga los 2 subarboles que NO contiene DATOS
						// (flag en false) con la sumatoria de frecuencias
						NodoArbol AUXNA = new NodoArbol('*', AUXNL1.raiz.frecuencia + AUXNL2.raiz.frecuencia, false);
						AUXNA.izquierda = AUXNL1.raiz;
						AUXNA.derecha = AUXNL2.raiz;

						// Creamos un nuevo nodo de lista para insertar en reemplazo de los 2 eliminados
						NodoLista AUXNL = new NodoLista(AUXNA);

						// Insertar nodo nuevo a la lista en forma ordenada
						InsertarNodoLista(AUXNL);
						AUXRECORIDONL = NodoInicial;

					}
				}
			}
		}

		// Genera los códigos de Huffman de forma recursiva
		void GenerarCodigosDeHuffman_recursivo(NodoArbol nodo, String codigo) {
		    if (nodo != null) {
		        // Si es un nodo con datos (es una hoja)
		        if (nodo.esdato) {
		            TablaHuffmanCodigos[(int)nodo.clave] = codigo;
		        } else {
		            // Si no es un nodo hoja, seguimos recorriendo
		            GenerarCodigosDeHuffman_recursivo(nodo.izquierda, codigo + "0");
		            GenerarCodigosDeHuffman_recursivo(nodo.derecha, codigo + "1");
		        }
			}
		}

		byte stringbytetobyte(String strtobyte) {
			byte Byteresult = 0;
			int Intresult = 0;
			
			if (strtobyte.length() > 0) {
				if (Integer.parseInt(strtobyte.substring(0,1)) > 0)
					Intresult=Intresult+128;
					 if (strtobyte.length()>1)
					 if (Integer.parseInt(strtobyte.substring(1,2)) > 0)
					Intresult=Intresult+64;
					 if (strtobyte.length()>2)
					 if (Integer.parseInt(strtobyte.substring(2,3)) > 0)
					Intresult=Intresult+32;
					 if (strtobyte.length()>3)
					 if (Integer.parseInt(strtobyte.substring(3,4)) > 0)
					Intresult=Intresult+16;
					 if (strtobyte.length()>4)
					 if (Integer.parseInt(strtobyte.substring(4,5)) > 0)
					Intresult=Intresult+8;
					 if (strtobyte.length()>5)
					 if (Integer.parseInt(strtobyte.substring(5,6)) > 0)
					Intresult=Intresult+4;
					 if (strtobyte.length()>6)
					 if (Integer.parseInt(strtobyte.substring(6,7)) > 0)
					Intresult=Intresult+2;
					 if (strtobyte.length()>7)
					 if (Integer.parseInt(strtobyte.substring(7,8)) > 0)
					Intresult=Intresult+1;
					 Byteresult=(byte)Intresult;
			} return Byteresult;	
			}

		String procesarbuffer(String STRBUFF, RandomAccessFile archivo) throws IOException {
			String Auxstr = STRBUFF, STRINGBYTE = "";
			while (Auxstr.length() >= 8) {
				STRINGBYTE = Auxstr.substring(0, 8);
				Auxstr = Auxstr.substring(8, Auxstr.length());
				archivo.writeByte(stringbytetobyte(STRINGBYTE));

			}
			return Auxstr;
		}

		void GenerarArchivoComprimido(String NombreArchivoO, String NombreArchivoD) {
			// Grabamos el archivo a comprimir
			String STRBuffer = "";
			String STRBuffertmp = "";
			// Borrar si existe el archivo
			File arch = new File(NombreArchivoD);
			if (arch.delete())
				System.out.println("archivo borrado");
			try {
				// Abriendo el archivo original de solo lectura
				RandomAccessFile archivoorigen = new RandomAccessFile(NombreArchivoO, "r");
				// Abriendo el archivo destino como lectura escritura
				RandomAccessFile archivodestino = new RandomAccessFile(NombreArchivoD, "rw");
				int entero;
				byte dato;
				long cont = 0;
				long tamano = archivoorigen.length();
				// System.out.println(STRBuffer);
				while (cont < tamano) {
					archivoorigen.seek(cont);
					dato = archivoorigen.readByte();
					entero = ByteToUnsignedByte(dato);
					// Codificar en buffer de string
					// System.out.println(entero);
					STRBuffer = STRBuffer + TablaHuffmanCodigos[entero];
					STRBuffertmp = STRBuffertmp + " " + TablaHuffmanCodigos[entero];
					// System.out.println(TablaHuffmanCodigos[entero]);
					STRBuffer = procesarbuffer(STRBuffer, archivodestino);

					cont++;
				}
				System.out.println(STRBuffertmp);
				archivoorigen.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// Huffman
	public ArbolHuffman AH;

	void Comprimir(String NombreArchivo) {
		ArbolHuffman AH = new ArbolHuffman();
		if (AH != null) {
			AH.CargarTablaDeArchivo(NombreArchivo);
			// System.out.println("crea lista: ");
			AH.CrearListaDeArboles();
			AH.ProcesarListaDeArboles();
			AH.GenerarCodigosDeHuffman_recursivo(AH.NodoInicial.raiz, "");
			AH.GenerarArchivoComprimido(NombreArchivo, NombreArchivo + ".compress");
		}
	}

	public static void main(String[] args) {

		// Crear arbol de huffman
		huffman AHuffman = new huffman();
		// Cambiar el nombre del archivo por el archivo deseado
		AHuffman.Comprimir("C:\\Users\\julie\\Documentos\\Semestre 4 - Algoritmos y Estructuras de Datos II\\mariposa.txt");

	}

}

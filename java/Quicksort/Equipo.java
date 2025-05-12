package Quicksort;

// Clase Equipo que represenra a un equipo de futbol con su nombre y puntos
public class Equipo {
	String nombre; // Nombre del equipo
	int puntos; // Puntos del equipo
	
	// Constructor de la clase Equipo
	public Equipo(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
	// Metodo toString para formatear la salida del equipo
	@Override
	public String toString() {
		return String.format("%-20s %5d", nombre, puntos);
	}

}

package ContadorFrecuencia;

public class ContadorFrecuencia {
	
	public int[] contarFrecuencia(String palabra) {
		int[] conteos = new int[26];
		palabra = palabra.toUpperCase();
		
		for (int i = 0; i < palabra.length(); i++) {
			try {
				conteos[palabra.charAt(i) - 'A']++;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("No es una letra: " + palabra.charAt(i));
			}
		}
		
		return conteos;
	}

}

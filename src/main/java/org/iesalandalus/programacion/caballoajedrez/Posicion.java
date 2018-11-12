package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;

	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		if (fila<1 || fila>8) {
			throw new IllegalArgumentException("El valor de la fila no es correcto.");
		} else {
			this.fila = fila;
		}

	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		if (columna == 'a' || columna == 'b' || columna == 'c' || columna == 'd' || columna == 'e' || columna == 'f' || 
				columna == 'g' || columna =='h') {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException("La posición de la columna no es correcta.");
		}




	}





}

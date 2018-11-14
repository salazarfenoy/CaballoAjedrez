package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;

	public Posicion (int fila, char columna) throws IllegalArgumentException {
		setFila(fila);
		setColumna(columna);
	}
	public Posicion (Posicion posicion) {
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();
		
	}


	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		if (fila<1 || fila>8) {
			throw new IllegalArgumentException("ERROR: Fila no válida.");
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
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}

	}
	@Override
	public String toString() {
		return "[fila="+fila+", columna="+columna+"]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Posicion)) {
			return false;
		}
		Posicion other = (Posicion) obj;
		if (fila != other.fila) {
			return false;
		}
		if (columna != other.columna) {
			return false;
		}
		return true;
	}





}

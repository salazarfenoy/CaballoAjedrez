package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

public class Caballo {
	private Color color;
	private Posicion posicion;

	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'b');
	}

	public Caballo(Color color) {
		this.color = color;
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");

		} else {
			if (this.color == Color.NEGRO){

				posicion = new Posicion(8, 'b');


			}
			if (this.color == Color.BLANCO){

				posicion = new Posicion(1, 'b');
			}

		}
	}
	public Caballo(Color color, char columna) {
		this.color = color;
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
		if (columna == 'b' || columna == 'g') {
			if (this.color == Color.NEGRO){

				posicion = new Posicion(8, columna);
			}
			if (this.color == Color.BLANCO) {

				posicion = new Posicion(1, columna);

			} 

		} else {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		}
	}


	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion Posicion) {
		this.posicion = Posicion;
	}
	public void mover(Direccion direccion) throws OperationNotSupportedException {
		switch (direccion) {
		case ARRIBA_IZQUIERDA:
			try {
				setPosicion(new Posicion(posicion.getFila() + 2, (char)(posicion.getColumna() - 1)));

			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ARRIBA_DERECHA:
			try {
				setPosicion(new Posicion(posicion.getFila() + 2, (char)(posicion.getColumna() + 1)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_IZQUIERDA:
			try {
				setPosicion(new Posicion(posicion.getFila() - 2, (char)(posicion.getColumna() - 1)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case ABAJO_DERECHA:
			try {
				setPosicion(new Posicion(posicion.getFila() - 2, (char)(posicion.getColumna() + 1)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA_ARRIBA:
			try {
				setPosicion(new Posicion(posicion.getFila() + 1, (char)(posicion.getColumna() + 2)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case DERECHA_ABAJO:
			try {
				setPosicion(new Posicion(posicion.getFila() - 1, (char)(posicion.getColumna() + 2)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA_ARRIBA:
			try {
				setPosicion(new Posicion(posicion.getFila() + 1, (char)(posicion.getColumna() - 2)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		case IZQUIERDA_ABAJO:
			try {
				setPosicion(new Posicion(posicion.getFila() - 1, (char)(posicion.getColumna() - 2)));
			} catch (IllegalArgumentException e) {
				throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
			}
			break;
		}
	}
	public String toString() {
		return ("Caballo [posición="+getPosicion()+", color="+getColor()+"]");
	}
}




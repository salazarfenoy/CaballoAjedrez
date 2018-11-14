package org.iesalandalus.programacion.caballoajedrez;

public class Caballo {
	private Color color;
	private Posicion posicion;

	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'b');
	}

	public Caballo (String color) {
		if (this.color == Color.NEGRO){
			posicion = new Posicion(8, 'b');
		}
		if (this.color == Color.BLANCO) {
			posicion = new Posicion(1, 'b');
		}

	}
	public Caballo (String color, char columna) {
		if (columna == 'b' || columna == 'g') {
			if (this.color == Color.NEGRO){
				posicion = new Posicion(8, columna);
			}
			if (this.color == Color.BLANCO) {
				posicion = new Posicion(1, columna);

			} else {
				throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
			}
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
public void setPosicion(Posicion posicion) {
	this.posicion = posicion;
}

}

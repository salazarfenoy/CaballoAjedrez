package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static int opcionElegida;
	private static int elegirMovimiento;
	private static Caballo caballo;

	private static void mostrarMenu() {
		System.out.println("");
		System.out.println("1. Crear caballo por defecto.");
		System.out.println("2. Crear caballo de un color.");
		System.out.println("3. Crear caballo de un color en una columna.");
		System.out.println("4. Mover el caballo.");
		System.out.println("5. Salir.");
		elegirOpcion();

		ejecutarOpcion(opcionElegida);
	}

	private static int elegirOpcion() {
		System.out.println("");
		System.out.print("Elige una opción: ");
		opcionElegida = Entrada.entero();

		while (opcionElegida < 1 || opcionElegida > 5) {
			System.out.print("Por favor, elige una opción válida (entre 1 y 5): ");
			opcionElegida = Entrada.entero();
		} 

		return opcionElegida;
	}


	private static void ejecutarOpcion (int opcionElegida) {

		switch (opcionElegida) {
		case 1:
			crearCaballoDefecto();
			break;
		case 2:
			crearCaballoDefectoColor();
			break;
		case 3:
			crearCaballoColorPosicion();
			break;
		case 4:
			mover();
			break;
		case 5:
			System.out.print("Programa finalizado.");
			break;
		}


	}
	private static void crearCaballoDefecto() {
		System.out.println("");
		caballo = new Caballo();
		System.out.println("");
		System.out.println("Caballo creado.");
		System.out.print(caballo.toString());
		System.out.println("");
		mostrarMenu();
		elegirOpcion();
		ejecutarOpcion(opcionElegida);
	}
	private static void crearCaballoDefectoColor() {
		System.out.println("");
		caballo = new Caballo(elegirColor());
		System.out.println("");
		System.out.println("Caballo creado.");
		System.out.print(caballo.toString());
		System.out.println("");
		mostrarMenu();
		elegirOpcion();
		ejecutarOpcion(opcionElegida);
	}
	private static Color elegirColor() {
		System.out.println("Color del caballo");
		System.out.println("1. Negro.");
		System.out.println("2. Blanco.");
		System.out.print("Elige un color: ");
		int elegirColor = Entrada.entero(); 

		while (elegirColor != 1 && elegirColor != 2) {
			System.out.print("Por favor, elige un color válido (1 o 2): ");
			elegirColor = Entrada.entero();
		}
		switch (elegirColor) {
		case 1:
			return Color.NEGRO;
		case 2:
			return Color.BLANCO;
		}
		return null;
	}
	private static void crearCaballoColorPosicion() {
		System.out.println("");
		caballo = new Caballo(elegirColor(), elegirColumnaInicial());
		System.out.println("");
		System.out.println("Caballo creado.");
		System.out.print(caballo.toString());
		System.out.println("");
		mostrarMenu();
		elegirOpcion();
		ejecutarOpcion(opcionElegida);


	}
	private static char elegirColumnaInicial() {
		System.out.print("Elige una columna inicial (b o g): ");
		char columnaInicial = Entrada.caracter();
		while (columnaInicial != 'b' && columnaInicial != 'g') {
			System.out.print("Elige una columna inicial (b o g): ");
			columnaInicial = Entrada.caracter();
		}
		return (char)columnaInicial;
	}
	private static void mover() {

		try {mostrarMenuDirecciones();
		caballo.mover(elegirDireccion());
		System.out.println("");
		System.out.print(caballo.toString());
		System.out.println("");
		mostrarMenu();
		} catch (OperationNotSupportedException e) {
			System.out.println("");
			System.out.println(e.getMessage());
			System.out.println("Elige otro movimiento que sea válido:");
			mostrarMenuDirecciones();

		}



	} 
	private static void mostrarMenuDirecciones() {
		System.out.println("");
		System.out.println("1. Arriba e izquierda.");
		System.out.println("2. Arriba y derecha.");
		System.out.println("3. Abajo e izquierda.");
		System.out.println("4. Abajo y derecha.");
		System.out.println("5. Izquierda y arriba.");
		System.out.println("6. Izquierda y abajo.");
		System.out.println("7. Derecha y arriba.");
		System.out.println("8. Derecha y abajo.");



	}
	private static Direccion elegirDireccion() {
		System.out.print("Elige un movimiento: ");
		elegirMovimiento = Entrada.entero();
		while (elegirMovimiento < 1 && elegirMovimiento > 8) {
			System.out.print("Por favor, elige un movimiento correcto (entre 1 y 8): ");
			elegirMovimiento = Entrada.entero();
		}
		switch (elegirMovimiento) {
		case 1:
			return Direccion.ARRIBA_IZQUIERDA;
		case 2:
			return Direccion.ARRIBA_DERECHA;
		case 3:
			return Direccion.ABAJO_IZQUIERDA;
		case 4:
			return Direccion.ABAJO_DERECHA;
		case 5:
			return Direccion.IZQUIERDA_ARRIBA;
		case 6:
			return Direccion.IZQUIERDA_ABAJO;
		case 7:
			return Direccion.DERECHA_ARRIBA;
		case 8:
			return Direccion.DERECHA_ABAJO;
		}
		return null;
	}

	public static void main(String[] args) {

		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");

		mostrarMenu();
	}

}
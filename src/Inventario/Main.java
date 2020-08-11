package Inventario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.text.html.HTMLEditorKit.Parser;

public class Main {
	static List<Inventario> lstInventario = new ArrayList<>();
	static Scanner entrada = new Scanner(System.in);
	static boolean isMenu = true;

	public static void main(String[] args) {
		llenarListaDeInvertarios();
		while (isMenu) {
			menu();

		}

		System.out.println("FIN DEL PROGRAMA");
	}

	private static void llenarListaDeInvertarios() {

		lstInventario.add(new Inventario(1, 2, "libro2020", "Odisea", 3.75));
		lstInventario.add(new Inventario(1, 2, "libro2021", "Iliada", 3.10));
		lstInventario.add(new Inventario(1, 2, "libro2022", "Odisea", 3.50));
		lstInventario.add(new Inventario(1, 2, "libro2023", "Odisea", 3.30));
		lstInventario.add(new Inventario(1, 2, "libro2024", "Odisea", 3.90));
		lstInventario.add(new Inventario(1, 2, "libro2025", "Odisea", 3.10));
		lstInventario.add(new Inventario(1, 2, "libro2026", "Odisea", 3.60));
		lstInventario.add(new Inventario(1, 2, "libro2027", "Odisea", 3.20));
		lstInventario.add(new Inventario(1, 2, "libro2028", "Odisea", 3.3));
		lstInventario.add(new Inventario(1, 2, "libro2029", "Odisea", 3.0));

	}

	private static void menu() {

		System.out.println("Menu Principal");
		System.out.println("----------------------");
		System.out.println("1. SOLICITAR DATOS");
		System.out.println("2. ACTUALIZAR DATOS");
		System.out.println("3. MOSTRAR DATOS");
		System.out.println("4. CONSULTAR DATOS");
		System.out.println("5. SALIR");
		System.out.println("MENU");

		int option = entrada.nextInt();
		switch (option) {
		case 1:
			ingresoDato();
			break;
		case 2:
			actualizarDato();
			break;
		case 3:
			PreciosAltos();
			break;
		case 4:
			consultarDato();
			break;
		case 5:
			isMenu = false;
			break;

		default:
			isMenu = false;
			break;

		}
	}

	private static void PreciosAltos() {
		List<Inventario> objInventario = retornoLosTresPerciosAltosInventario();
		int i = 0;
		for (Inventario temp : objInventario) {
			if (i <= 2)
				System.out.println(temp.getPrecio() + " precio");
			else
				break;
			i++;

		}

	}

	private static void consultarDato() {
		String codigoLibro = null;
		Inventario objLocalInventario;
		Scanner entrada2 = new Scanner(System.in);
		System.out.println("INGRESE EL CODIGO DEL LIBRO : ");
		codigoLibro = entrada2.nextLine();

		if (codigoLibro != null && !codigoLibro.isEmpty()) {
			objLocalInventario = devolverEntidadInvetario(codigoLibro);
			if (objLocalInventario != null)
				System.out.println("Autor : " + objLocalInventario.getAutor() + " Existe : "  + objLocalInventario.getCantidadLibro() + " Su codio es" + objLocalInventario.getCodigo() + " El numero del libro es" + objLocalInventario.getNumerosLibro() + " Su precio es : $" + objLocalInventario.getPrecio());
			
			else
				System.out.println("NO EXISTE INFORMACION");
		}
	}

	private static void ingresoDato() {
		String codigoLibro = null;
		String autor = null;
		int cantidadLibro;
		int numeroLibro;
		double precioLibro;
		Inventario objLocalInventario;
		Scanner entrada2 = new Scanner(System.in);
		System.out.println("INGRESE EL CODIGO DEL LIBRO : ");
		codigoLibro = entrada2.nextLine();
		System.out.println("INGRESE EL NOMBRE DEL AUTOR DEL LIBRO : ");
		autor = entrada2.nextLine();
		System.out.println("INGRESE LA CANTIDAD DE LIBRO : ");
		cantidadLibro = entrada2.nextInt();
		System.out.println("INGRESE EL NUMERO DEL LIBRO : ");
		numeroLibro = entrada2.nextInt();
		System.out.println("INGRESE EL PRECIO DEL LIBRO : ");
		precioLibro = entrada2.nextDouble();

		if (codigoLibro != null && !codigoLibro.isEmpty()) {
			objLocalInventario = devolverEntidadInvetario(codigoLibro);

			if (objLocalInventario == null) {
				boolean isValid = ingresarEntidadInventario(
						new Inventario(numeroLibro, cantidadLibro, codigoLibro, autor, precioLibro));

				if (isValid)
					System.out.println("INFORMACION GUARDADA CON EXITO");
				else
					System.out.println("ERROR AL INGRESAR LA INFORMACION");
			}

			else
				System.out.println("INFORMACION YA SE ENCUENTRA REGISTRADA");
		}
	}

	private static void actualizarDato() {
		String codigoLibro = null;
		String autor = null;
		int cantidadLibro;
		int numeroLibro;
		double precioLibro;
		Inventario objLocalInventario;
		Scanner entrada2 = new Scanner(System.in);
		System.out.println("INGRESE EL CODIGO DEL LIBRO : ");
		codigoLibro = entrada2.nextLine();
		System.out.println("INGRESE EL NOMBRE DEL AUTOR DEL LIBRO : ");
		autor = entrada2.nextLine();
		System.out.println("INGRESE LA CANTIDAD DE LIBRO : ");
		cantidadLibro = entrada2.nextInt();
		System.out.println("INGRESE EL NUMERO DEL LIBRO : ");
		numeroLibro = entrada2.nextInt();
		System.out.println("INGRESE EL PRECIO DEL LIBRO : ");
		precioLibro = entrada2.nextDouble();

		if (codigoLibro != null && !codigoLibro.isEmpty()) {
			objLocalInventario = devolverEntidadInvetario(codigoLibro);
			if (objLocalInventario != null) {
				boolean isValid = actualizarEntidadInventario(
						new Inventario(numeroLibro, cantidadLibro, codigoLibro, autor, precioLibro));

				if (isValid)
					System.out.println("INFORMACION ACTUALIZADA CON EXITO");
				else
					System.out.println("ERROR AL ACTULIZAR LA INFORMACION");
			}

			else
				System.out.println("NO EXISTE INFORMACION");
		}
	}

	private static List<Inventario> retornoLosTresPerciosAltosInventario() {
		List<Inventario> objInvetario = lstInventario.stream()
				.sorted(Comparator.comparing(Inventario::getPrecio).reversed()).collect(Collectors.toList());

		return objInvetario;

	}

	private static boolean actualizarEntidadInventario(Inventario ObjectoActualizoEntidadInventario) {

		if (lstInventario != null && !lstInventario.isEmpty()) {
			for (Inventario objInvetario : lstInventario) {
				if (objInvetario.codigo.equalsIgnoreCase(ObjectoActualizoEntidadInventario.getCodigo())) {
					objInvetario.setAutor(ObjectoActualizoEntidadInventario.getAutor());
					objInvetario.setCantidadLibro(ObjectoActualizoEntidadInventario.getCantidadLibro());
					objInvetario.setNumerosLibro(ObjectoActualizoEntidadInventario.getNumerosLibro());
					return true;
				}

			}
		}

		return false;

	}

	private static boolean ingresarEntidadInventario(Inventario ObjectoActualizoEntidadInventario) {

		if (lstInventario != null && !lstInventario.isEmpty()) {
			lstInventario.add(ObjectoActualizoEntidadInventario);
			return true;

		}

		return false;

	}

	private static Inventario devolverEntidadInvetario(String Codigo) {

		if (lstInventario != null && !lstInventario.isEmpty()) {
			for (Inventario objInvetario : lstInventario) {
				if (objInvetario.codigo.equalsIgnoreCase(Codigo)) {
					return objInvetario;
				}

			}
		}

		return null;

	}

}
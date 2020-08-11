package Inventario;

import java.util.Scanner;

public class Inventario {

	public Inventario(int numerosLibro, int cantidadLibro, String codigo, String autor, double precio) {
		super();
		this.numerosLibro = numerosLibro;
		this.cantidadLibro = cantidadLibro;
		this.codigo = codigo;
		this.autor = autor;
		this.precio = precio;
		
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getNumerosLibro() {
		return numerosLibro;
	}

	public void setNumerosLibro(int numerosLibro) {
		this.numerosLibro = numerosLibro;
	}

	public int getCantidadLibro() {
		return cantidadLibro;
	}

	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Inventario() {
		super();
	
	}

	public int numerosLibro;
	public int cantidadLibro;
	public double precio;
	public String codigo;
	public String autor;

	
}
package Inventario;

import java.util.Scanner;

public class Inventario {

	/**
	 * @param numerosLibro
	 * @param cantidadLibro
	 * @param codigo
	 * @param autor
	 * @param precio
	 */
	public Inventario(int numerosLibro, int cantidadLibro, String codigo, String autor, double precio) {
		super();
		this.numerosLibro = numerosLibro;
		this.cantidadLibro = cantidadLibro;
		this.codigo = codigo;
		this.autor = autor;
		this.precio = precio;
		
	}
	
	
	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}


	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	/**
	 * @return the numerosLibro
	 */
	public int getNumerosLibro() {
		return numerosLibro;
	}

	/**
	 * @param numerosLibro the numerosLibro to set
	 */
	public void setNumerosLibro(int numerosLibro) {
		this.numerosLibro = numerosLibro;
	}

	/**
	 * @return the cantidadLibro
	 */
	public int getCantidadLibro() {
		return cantidadLibro;
	}

	/**
	 * @param cantidadLibro the cantidadLibro to set
	 */
	public void setCantidadLibro(int cantidadLibro) {
		this.cantidadLibro = cantidadLibro;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * 
	 */
	public Inventario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int numerosLibro;
	public int cantidadLibro;
	public double precio;
	public String codigo;
	public String autor;

	
}
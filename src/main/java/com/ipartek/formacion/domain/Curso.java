package com.ipartek.formacion.domain;

import javax.validation.constraints.Size;

/**
 * Pojo Curso
 * 
 * @author Nagore Libano
 *
 */
public class Curso {

	private static final int NOMBRE_SIZE_MIN = 3;
	private static final int NOMBRE_SIZE_MAX = 255;
	private static final int CODIGO_SIZE_MIN = 1;
	private static final int CODIGO_SIZE_MAX = 50;

	private long id;

	@Size(min = NOMBRE_SIZE_MIN, max = NOMBRE_SIZE_MAX, message = "El nombre debe tener al menos 3 letras")
	private String nombre;

	@Size(min = CODIGO_SIZE_MIN, max = CODIGO_SIZE_MAX, message = "El código no puede ser nulo")
	private String codigo;

	/**
	 * Constructor por defecto inicializado.
	 */
	public Curso() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = null;
	}

	/**
	 * Obtiene el valor de la propiedad id
	 * 
	 * @return id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Define el valor de la propiedad id
	 * 
	 * @param id
	 *            id del Curso
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Obtiene el valor de la propiedad nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Define el valor de la propiedad nombre
	 * 
	 * @param nombre
	 *            nombre del Curso
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el valor de la propiedad codigo
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Define el valor de la propiedad codigo
	 * 
	 * @param codigo
	 *            codigo del Curso
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override()
	public String toString() {
		return "Curso [id=" + this.id + ", nombre=" + this.nombre + ", codigo=" + this.codigo + "]";
	}

}

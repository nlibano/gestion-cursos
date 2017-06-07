package com.ipartek.formacion.domain;

public class Curso {

	private long id;

	private String nombre;

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
	 * Getter del atributo id
	 * 
	 * @return id
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Setter del atributo id
	 * 
	 * @param id
	 *            id del Curso
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter del atributo nombre
	 * 
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter del atributo nombre
	 * 
	 * @param nombre
	 *            nombre del Curso
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del atributo codigo
	 * 
	 * @return codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * Setter del atributo codigo
	 * 
	 * @param codigo
	 *            codigo del Curso
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Curso [id=" + this.id + ", nombre=" + this.nombre + ", codigo=" + this.codigo + "]";
	}

}

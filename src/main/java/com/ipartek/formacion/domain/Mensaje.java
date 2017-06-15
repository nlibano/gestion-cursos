package com.ipartek.formacion.domain;

/**
 * Gestion de mensajes para el usuario.<br>
 * Basado en el componente Alerts de Bootstrap3.<br>
 * 
 * @see: http://getbootstrap.com/components/#alerts
 * @author ur00
 *
 */
public class Mensaje {

	public static final String CLASE_SUCCESS = "alert-success";
	public static final String CLASE_INFO = "alert-info";
	public static final String CLASE_WARNING = "alert-warning";
	public static final String CLASE_DANGER = "alert-danger";

	private String descripcion;
	private String clase;

	/**
	 * Constructor vacio
	 */
	public Mensaje() {
		super();
		this.clase = CLASE_DANGER;
		this.descripcion = "Error!!! Upsss algo esta fallando";
	}

	/**
	 * Constructor con parametros
	 * 
	 * @param descripcion
	 *            descripcion del mensaje
	 * @param clase
	 *            tipo de mensaje
	 */
	public Mensaje(String descripcion, String clase) {
		super();
		this.descripcion = descripcion;
		this.clase = clase;
	}

	/**
	 * Getter del atributo descripcion
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * Setter del atributo descripcion
	 * 
	 * @param descripcion
	 *            descripcion del mensaje
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter del atributo clase
	 * 
	 * @return clase
	 */
	public String getClase() {
		return this.clase;
	}

	/**
	 * Setter del atributo clase
	 * 
	 * @param clase
	 *            clase del mensaje
	 */
	public void setClase(String clase) {
		this.clase = clase;
	}

	@Override()
	public String toString() {
		return "Mensaje [descripcion=" + this.descripcion + ", clase=" + this.clase + "]";
	}

}

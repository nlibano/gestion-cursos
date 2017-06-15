package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.domain.Curso;

/**
 * Interfaz del Servicio Curso
 * 
 * @author Nagore Libano
 *
 */
public interface ServiceCurso {

	/**
	 * Lista todos los cursos limitado a 500 o los cursos correspondientes al
	 * filtro.
	 * 
	 * @param filter
	 *            Si es null, listaremos todos los cursos limitado a los 1000.
	 *            <br>
	 *            Si no es null, listaremos los cursos que contengan el nombre
	 *            que se indica en el parametro filter
	 * @return List<Curso>
	 */
	List<Curso> listar(String filter);

	/**
	 * Lista los ultimos 10 cursos
	 * 
	 * @return List<Curso>
	 */
	List<Curso> listarUltimos();

	/**
	 * Busca un curso por su id
	 * 
	 * @param id
	 *            id del curso
	 * @return Curso
	 */
	Curso buscarPorID(long id);

	/**
	 * Crea un nuevo curso
	 * 
	 * @param c
	 *            Curso
	 * @return true si el resultado a sido satisfactorio y se ha creado el
	 *         curso, false si no se ha podido crear.
	 */
	boolean crear(Curso c);

	/**
	 * Desde un archivo 'csv' migra a la BBDD los nuevos cursos que se quieran
	 * añadir.
	 * 
	 * @param c
	 *            Curso
	 * @return true si el resultado a sido satisfactorio, false si no se ha
	 *         podido crear.
	 */
	boolean migrar(ArrayList<Curso> c);

	/**
	 * Modifica un curso
	 * 
	 * @param c
	 *            Curso
	 * @return true si el resultado a sido satisfactorio y se ha modificado el
	 *         curso, false si no se ha podido modificar.
	 */
	boolean modificar(Curso c);

	/**
	 * Elimina un curso
	 * 
	 * @param id
	 *            id del Curso
	 * @return true si el resultado a sido satisfactorio y se ha eliminado el
	 *         curso, false si no se ha podido eliminar.
	 */
	boolean eliminar(long id);

}

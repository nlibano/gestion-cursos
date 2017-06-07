package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Curso;

public interface ServiceCurso {

	/**
	 * Lista todos los cursos limitado a 1000
	 * 
	 * @return List<Curso>
	 */
	List<Curso> listar();

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

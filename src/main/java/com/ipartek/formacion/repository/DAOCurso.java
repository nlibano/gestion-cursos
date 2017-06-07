package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

public interface DAOCurso {

	void setDatasource(DataSource ds);

	/**
	 * Lista todos los cursos limitado a 1000
	 * 
	 * @return List<Curso>
	 */
	List<Curso> getALL();

	/**
	 * Lista los 10 ultimos cursos
	 * 
	 * @return List<Curso>
	 */
	List<Curso> getTenLast();

	/**
	 * Busca un curso por su id
	 * 
	 * @param id
	 *            id del curso
	 * @return Curso
	 */
	Curso getById(long id);

	/**
	 * Crea un nuevo curso
	 * 
	 * @param c
	 *            Curso
	 * @return true si el resultado a sido satisfactorio y se ha creado el
	 *         curso, false si no se ha podido crear.
	 */
	boolean insert(Curso c);

	/**
	 * Modifica un curso
	 * 
	 * @param c
	 *            Curso
	 * @return true si el resultado a sido satisfactorio y se ha modificado el
	 *         curso, false si no se ha podido modificar.
	 */
	boolean update(Curso c);

	/**
	 * Elimina un curso
	 * 
	 * @param id
	 *            id del Curso
	 * @return true si el resultado a sido satisfactorio y se ha eliminado el
	 *         curso, false si no se ha podido eliminar.
	 */
	boolean delete(long id);

}

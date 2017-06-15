package com.ipartek.formacion.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

/**
 * Interfaz del DAO Curso
 * 
 * @author Nagore Libano
 *
 */
public interface DAOCurso {

	/**
	 * Define los parametros de la BBDD
	 * 
	 * @param ds
	 *            DataSource
	 */
	void setDatasource(DataSource ds);

	/**
	 * Lista todos los cursos limitado a 500
	 * 
	 * @param filtro
	 *            nombre o codigo a buscar en la BBDD
	 * @return List<Curso>
	 */
	List<Curso> getALL(String filtro);

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
	 * Desde un archivo 'csv' migra a la BBDD los nuevos cursos que se quieran
	 * añadir.
	 * 
	 * @param c
	 *            Curso
	 * @return true si el resultado a sido satisfactorio, false si no se ha
	 *         podido crear.
	 */
	boolean migrate(ArrayList<Curso> c);

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

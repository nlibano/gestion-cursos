package com.ipartek.formacion.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test para el pojo Curso
 * 
 * @author Nagore Libano
 *
 */
public class CursoTest {

	static final long ID = 2;
	static final String NOMBRE = "Excell 2010";
	static final String CODIGO = "AA105";

	private static Curso curso = null;

	/**
	 * Creamos un nuevo curso antes de ejeccutar los Test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@Before()
	public void setUp() throws Exception {
		curso = new Curso();
	}

	/**
	 * Pasamos a null el atributo receta despues de ejecutar todos los Test
	 * 
	 * @throws Exception
	 *             lanza excepcion en caso de error
	 */
	@After()
	public void tearDown() throws Exception {
		curso = null;
	}

	/**
	 * Comprobamos los constructores del pojo Curso
	 */
	@Test()
	public void testConstructor() {
		assertEquals(-1, curso.getId());
		assertEquals("", curso.getNombre());
		assertNull(curso.getCodigo());
	}

	/**
	 * Comprobamos los getters y setter del pojo Curso
	 */
	@Test()
	public void testSetterGetter() {

		curso.setId(ID);
		assertEquals(ID, curso.getId());

		curso.setNombre(NOMBRE);
		assertEquals(NOMBRE, curso.getNombre());

		curso.setCodigo(CODIGO);
		assertEquals(CODIGO, curso.getCodigo());

	}

}

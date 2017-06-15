package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.DAOCurso;

/**
 * Implementacion del servicio Curso
 * 
 * @author Nagore Libano
 *
 */
@Service(value = "serviceCurso")
public class ServiceCursoImpl implements ServiceCurso {

	private final Log LOG = LogFactory.getLog(getClass());

	@Autowired()
	private DAOCurso daoCurso;

	@Override()
	public List<Curso> listar(String filtro) {
		this.LOG.trace("listar cursos");
		return this.daoCurso.getALL(filtro);
	}

	@Override()
	public List<Curso> listarUltimos() {
		this.LOG.trace("listar ultimos 10 cursos");
		return this.daoCurso.getTenLast();
	}

	@Override()
	public Curso buscarPorID(long id) {
		this.LOG.trace("Buscar un curso por su ID: " + id);
		return this.daoCurso.getById(id);
	}

	@Override()
	public boolean crear(Curso c) {
		this.LOG.trace("Crear un nuevo curso: " + c);
		return this.daoCurso.insert(c);
	}

	@Override()
	public boolean migrar(ArrayList<Curso> c) {
		this.LOG.trace("Migra a la BBD los nuevos cursos: " + c);
		return this.daoCurso.migrate(c);
	}

	@Override()
	public boolean modificar(Curso c) {
		this.LOG.trace("Modificar un curso: " + c);
		return this.daoCurso.update(c);
	}

	@Override()
	public boolean eliminar(long id) {
		this.LOG.trace("Eliminar un curso por su ID: " + id);
		return this.daoCurso.delete(id);
	}

}

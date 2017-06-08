package com.ipartek.formacion.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.DAOCurso;

@Service("serviceCurso")
public class ServiceCursoImpl implements ServiceCurso {

	private final Log LOG = LogFactory.getLog(getClass());

	@Autowired()
	private DAOCurso daoCurso;

	@Override()
	public List<Curso> listar(String filtro) {
		LOG.trace("listar cursos");
		return daoCurso.getALL(filtro);
	}

	@Override()
	public List<Curso> listarUltimos() {
		LOG.trace("listar ultimos 10 cursos");
		return daoCurso.getTenLast();
	}

	@Override()
	public Curso buscarPorID(long id) {
		LOG.trace("Buscar un curso por su ID: " + id);
		return daoCurso.getById(id);
	}

	@Override()
	public boolean crear(Curso c) {
		LOG.trace("Crear un nuevo curso: " + c);
		return daoCurso.insert(c);
	}

	@Override()
	public boolean modificar(Curso c) {
		LOG.trace("Modificar un curso: " + c);
		return daoCurso.update(c);
	}

	@Override()
	public boolean eliminar(long id) {
		LOG.trace("Eliminar un curso por su ID: " + id);
		return daoCurso.delete(id);
	}

}

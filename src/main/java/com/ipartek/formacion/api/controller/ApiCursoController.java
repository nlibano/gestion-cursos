package com.ipartek.formacion.api.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.service.ServiceCurso;

/**
 * Controlador API para buscar Cursos mediante un filtro
 *
 * @author Nagore Libano
 *
 */
@Controller()
@RequestMapping(value = "/api/curso")
public class ApiCursoController {

	private static final Logger LOG = LoggerFactory.getLogger(ApiCursoController.class);

	@Autowired()
	private ServiceCurso serviceCurso;

	/**
	 * Listamos los cursos que contenga lo el filtro.
	 * 
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "cursos" ArrayList<Curso>
	 * @return la vista "admin/index"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ArrayList<Curso>> listar(
			@RequestParam(value = "filter", required = false) String filter) {

		LOG.info("recuperando los cursos que contengan: " + filter);

		ResponseEntity<ArrayList<Curso>> response = new ResponseEntity<ArrayList<Curso>>(HttpStatus.NO_CONTENT);

		try {

			ArrayList<Curso> cursos = (ArrayList<Curso>) this.serviceCurso.listar(filter);

			if (!cursos.isEmpty()) {

				response = new ResponseEntity<ArrayList<Curso>>((ArrayList<Curso>) this.serviceCurso.listar(filter),
						HttpStatus.OK);

			}

		} catch (Exception e) {

			LOG.error("Excepcion sin controlar", e);
			response = new ResponseEntity<ArrayList<Curso>>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return response;
	}

}
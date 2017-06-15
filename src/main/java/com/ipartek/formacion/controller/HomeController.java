package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceCurso;

/**
 * Controlador HOME. Handles requests for the application home page.
 * 
 * @author Nagore Libano
 */
@Controller()
public class HomeController {

	@Autowired()
	private ServiceCurso serviceCurso;

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	private static final String VIEW_HOME = "home";
	private static final String VIEW_DETALLE_CURSO = "user/detalle-curso";

	/**
	 * Pagina inicial a mostrar al usuario. Se le envia una lista de los 10
	 * ultimos cursos creados.
	 * 
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "cursos" ArrayList<Curso>
	 * @return la vista "home"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		LOG.info("Home. Mostrando al usuario los ultimos 10 cursos");

		model.addAttribute("cursos", this.serviceCurso.listarUltimos());

		return VIEW_HOME;
	}

	/**
	 * Muestra el detalle del curso que el usuario quiere buscar.
	 * 
	 * @param id
	 *            identificador del Curso
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "curso" Curso
	 * @return la vista "detalle-curso"
	 */
	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(@PathVariable() int id, Model model) {

		LOG.info("recuperando los datos de un curso");

		model.addAttribute("curso", this.serviceCurso.buscarPorID(id));

		return VIEW_DETALLE_CURSO;
	}
}

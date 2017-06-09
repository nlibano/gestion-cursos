package com.ipartek.formacion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.service.ServiceCurso;

/**
 * Handles requests for the application home page.
 */
@Controller()
public class HomeController {

	@Autowired()
	private ServiceCurso serviceCurso;

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	private static final String VIEW_HOME = "home";

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		LOG.info("Home. Mostrando al usuario los ultimos 10 cursos");

		model.addAttribute("cursos", serviceCurso.listarUltimos());

		return VIEW_HOME;
	}
}

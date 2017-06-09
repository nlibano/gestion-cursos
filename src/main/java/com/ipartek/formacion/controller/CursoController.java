package com.ipartek.formacion.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.service.ServiceCurso;

/**
 * Controlador para gestionar los Cursos
 *
 * @author Nagore Libano
 *
 */
@Controller()
@RequestMapping(value = "/admin/curso")
public class CursoController {

	private static final Logger LOG = LoggerFactory.getLogger(CursoController.class);
	private static final String VIEW_ADMIN_INDEX = "admin/index";
	private static final String VIEW_ADMIN_FORM = "admin/form-curso";

	@Autowired()
	private ServiceCurso serviceCurso;

	/**
	 * Listamos los ultimos 1000 cursos.
	 * 
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "cursos" ArrayList<Curso>
	 * @return la vista "admin/index"
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Model model) {

		LOG.info("recuperando todos los cursos");

		model.addAttribute("cursos", this.serviceCurso.listar(null));

		return VIEW_ADMIN_INDEX;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String irFormularioNuevo(Model model) {

		model.addAttribute("curso", new Curso());

		return VIEW_ADMIN_FORM;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(@PathVariable int id, Model model) {

		LOG.info("recuperando los datos de un curso");

		model.addAttribute("curso", this.serviceCurso.buscarPorID(id));

		return VIEW_ADMIN_FORM;
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid Curso curso, BindingResult bindingResult, Model model) {

		LOG.info("recibimos datos del formulario " + curso);
		String msg = null;

		// validamos los datos del formulario
		if (!bindingResult.hasErrors()) {

			if (curso.getId() == -1) {

				serviceCurso.crear(curso);
				msg = "El curso se ha creado correctamente";

			} else {

				serviceCurso.modificar(curso);
				msg = "El curso se ha modificado correctamente";

			}

		} else {

			LOG.info("formulario con datos no validos");

		}

		model.addAttribute("cursos", serviceCurso.listar(null));
		model.addAttribute("msg", msg);

		return VIEW_ADMIN_INDEX;
	}

	/**
	 * Elimina un curso
	 * 
	 * @param id
	 *            identificador del Curso
	 * @param model
	 *            <ol>
	 *            <li>msg: Mensaje para el usuario</li>
	 *            </ol>
	 * @return Si se elimina curso llamamos a la accion "listar".<br>
	 *         Si no se puede eliminar llamamos a la accion
	 *         "irFormularioEditar".
	 * 
	 * 
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String eliminar(@PathVariable int id, Model model) {

		LOG.info("eliminar un curso con id: " + id);
		String view = "redirect: ../";
		String msg = "Curso no eliminado";

		if (serviceCurso.eliminar(id)) {
			msg = "Curso Eliminado con exito";
			view = VIEW_ADMIN_INDEX;

		} else {

			view = "redirect: ../edit/" + id;
		}

		model.addAttribute("cursos", serviceCurso.listar(null));
		model.addAttribute("msg", msg);
		return view;
	}
}

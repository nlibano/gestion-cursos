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
import com.ipartek.formacion.domain.Mensaje;
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
	private static final String MODAL_CURSOS = "cursos";
	private static final String MODAL_MENSAJE = "msg";

	private Mensaje msg;

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

		model.addAttribute(MODAL_CURSOS, this.serviceCurso.listar(null));

		return VIEW_ADMIN_INDEX;
	}

	/**
	 * Vamos al formulario para crear un nuevo curso
	 * 
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "curso" Curso Inicializado
	 * @return la vista "admin/form-curso"
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String irFormularioNuevo(Model model) {

		model.addAttribute("curso", new Curso());

		return VIEW_ADMIN_FORM;
	}

	/**
	 * Vamos al formulario para editar un curso concreto.
	 * 
	 * @param id
	 *            identificador del Curso
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "curso" Curso
	 * @return la vista "admin/form-curso"
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String formularioEditar(@PathVariable() int id, Model model) {

		LOG.info("recuperando los datos de un curso");

		model.addAttribute("curso", this.serviceCurso.buscarPorID(id));

		return VIEW_ADMIN_FORM;
	}

	/**
	 * Creamos o Modificamos un curso en la BBDD
	 * 
	 * @param curso
	 *            Pojo Curso con los datos enviado a traves de un formulario
	 * @param bindingResult
	 *            Validacion del Pojo
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "cursos" ArrayList<Curso> "msg" Mensaje para el usuario
	 * @return la vista "admin/index"
	 */
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid() Curso curso, BindingResult bindingResult, Model model) {

		LOG.info("recibimos datos del formulario " + curso);
		this.msg = new Mensaje();
		String view;

		// validamos los datos del formulario
		if (!bindingResult.hasErrors()) {

			if (curso.getId() == -1) {

				this.serviceCurso.crear(curso);
				this.msg.setDescripcion("El curso se ha creado correctamente");
				this.msg.setClase(Mensaje.CLASE_SUCCESS);

			} else {

				this.serviceCurso.modificar(curso);
				this.msg.setDescripcion("El curso se ha modificado correctamente");
				this.msg.setClase(Mensaje.CLASE_SUCCESS);
			}

			view = VIEW_ADMIN_INDEX;

		} else {

			LOG.info("formulario con datos no validos");
			this.msg.setDescripcion("Formulario con datos no validos");
			this.msg.setClase(Mensaje.CLASE_DANGER);

			view = VIEW_ADMIN_FORM;
		}

		model.addAttribute(MODAL_CURSOS, this.serviceCurso.listar(null));
		model.addAttribute(MODAL_MENSAJE, this.msg);

		return view;
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
	public String eliminar(@PathVariable() int id, Model model) {

		LOG.info("eliminar un curso con id: " + id);
		this.msg = new Mensaje();

		String view = "redirect: ../";
		this.msg.setDescripcion("Curso no eliminado");
		this.msg.setClase(Mensaje.CLASE_DANGER);

		if (this.serviceCurso.eliminar(id)) {
			this.msg.setDescripcion("Curso Eliminado con exito");
			this.msg.setClase(Mensaje.CLASE_SUCCESS);

			view = VIEW_ADMIN_INDEX;

		} else {

			view = "redirect: ../edit/" + id;
		}

		model.addAttribute(MODAL_CURSOS, this.serviceCurso.listar(null));
		model.addAttribute(MODAL_MENSAJE, this.msg);
		return view;
	}
}

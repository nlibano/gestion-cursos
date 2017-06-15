package com.ipartek.formacion.controller;

import java.io.FileReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.domain.Mensaje;
import com.ipartek.formacion.service.ServiceCurso;
import com.opencsv.CSVReader;

/**
 * Controlador del administrador
 *
 * @author Nagore Libano
 *
 */
@Controller()
@RequestMapping(value = "/admin")
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	private static final String VIEW_ADMIN_INDEX = "admin/index";
	private static final char SPLIT_CSV = ';';
	private static final int NOMBRE_COLUMN = 1;
	private static final int CODIGO_COLUMN = 8;

	private static final String CSV_FILE = "C:\\cursos.csv";

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
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String listar(Model model) {

		LOG.info("recuperando todos los cursos");

		model.addAttribute("cursos", this.serviceCurso.listar(null));

		return VIEW_ADMIN_INDEX;
	}

	/**
	 * Migracion de datos (cursos nuevos) a la BBDD.
	 * 
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "cursos" ArrayList<Curso> "msg" Mensaje para el usuario
	 * @return la vista "admin/index"
	 */
	@RequestMapping(value = "/migrar", method = RequestMethod.GET)
	public String migrarCursos(Model model) {

		LOG.info("migrando a la base de datos los cursos desde un archivo csv");

		this.msg = new Mensaje();

		this.msg.setDescripcion(
				"No se ha podido realizar la migración de los cursos.<br><br>El fichero debe estar guardada en C:\\ y debe llamarse cursos.csv");

		CSVReader reader;
		String[] line;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Curso curso;

		try {

			reader = new CSVReader(new FileReader(CSV_FILE), SPLIT_CSV);

			while ((line = reader.readNext()) != null) {

				if ((!"NomCurso".equalsIgnoreCase(line[NOMBRE_COLUMN]))
						&& (!"CodCurso".equalsIgnoreCase(line[CODIGO_COLUMN]))) {
					curso = new Curso();
					curso.setNombre(line[NOMBRE_COLUMN]);
					curso.setCodigo(line[CODIGO_COLUMN]);

					cursos.add(curso);
				}
			}

			// Insertar en la BBDD.
			if (this.serviceCurso.migrar(cursos)) {

				this.msg.setDescripcion("Los cursos se han insertado correctamente");
				this.msg.setClase(Mensaje.CLASE_SUCCESS);
			}

		} catch (Exception e) {

			LOG.error("Se ha producido un error", e);

		}

		model.addAttribute("cursos", this.serviceCurso.listar(null));
		model.addAttribute("msg", this.msg);

		return VIEW_ADMIN_INDEX;
	}

}
package com.ipartek.formacion.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ipartek.formacion.domain.Curso;

/**
 * Controlador para subir archivos csv al servidor
 * 
 * @author Nagore Libano
 *
 */
@Controller()
@RequestMapping(value = "/admin")
public class UploadFileController /* implements HandlerExceptionResolver */ {

	private static final Logger LOG = LoggerFactory.getLogger(UploadFileController.class);

	private static final String MIME_TYPE_CSV = "text/csv";
	private static final String APP_CSV_RESOURCES = "uploads\\";

	private String mensaje = "Error subiendo archivo";

	/**
	 * Controlador para la subida de archivos formato 'csv', tamaño maximo 1Mb
	 * 
	 * @param file
	 *            Archivo a subir
	 * @param ruta
	 *            ruta de redireccionamiento
	 * @param curso
	 *            Curso
	 * @param bindingResult
	 *            Validar Curso
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista:
	 *            "mensaje" Mensaje para el usuario
	 * @return form.jsp
	 * @throws SizeLimitExceededException
	 *             exepcion de limite de fichero
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFileHandler(@RequestParam(value = "fichero") MultipartFile file,
			@RequestParam(value = "ruta") String ruta, @Valid() Curso curso, BindingResult bindingResult, Model model)
			throws SizeLimitExceededException {
		try {

			if (!file.isEmpty()) {

				this.validateCurso(file);
				this.saveCurso(file, model);

			} else {
				LOG.warn("Fichero vacio");
				this.mensaje = "fichero vacio";
			}

		} catch (Exception e) {
			LOG.error("Excepcion: " + e, e);
		}

		model.addAttribute("mensaje", this.mensaje);

		return "redirect:" + ruta;
	}

	/**
	 * Validar el archivo que sea de tipo de MIME: text/csv
	 * 
	 * @param file
	 *            Archivo a subir
	 */
	private void validateCurso(MultipartFile file) {

		final String contentType = file.getContentType();
		if (!MIME_TYPE_CSV.equals(contentType)) {
			throw new UnsupportedOperationException(contentType + " no soportado");
		}

	}

	/**
	 * Guardar en el servidor el archivo csv.
	 * 
	 * @param file
	 *            Archivo a subir
	 * @param model
	 *            modelo que se usa para el paso de atributos a la vista: "msg"
	 *            Mensaje para el usuario
	 * @throws IOException
	 *             Excepcion
	 */
	private void saveCurso(MultipartFile file, Model model) throws IOException {

		String rootPath = System.getProperty("catalina.home") + "\\webapps\\";
		File f = new File(rootPath + APP_CSV_RESOURCES + file.getOriginalFilename());
		FileUtils.writeByteArrayToFile(f, file.getBytes());
		this.mensaje = "imagen subida { formato: " + file.getContentType() + " , tamaño: " + file.getSize() + " Kb }";
		model.addAttribute("msg", "Archivo " + file.getOriginalFilename() + " subido correctamente");
		LOG.info("Fichero subido " + f.getAbsoluteFile());
	}

}
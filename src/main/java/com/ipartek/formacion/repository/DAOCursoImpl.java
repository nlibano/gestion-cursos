package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.mapper.CursoMapper;

@Repository("daoCurso")
public class DAOCursoImpl implements DAOCurso {

	private final Log LOG = LogFactory.getLog(getClass());
	private static final String ERROR_INESPERADO = "Excepcion inesperada";

	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired()
	@Override()
	public void setDatasource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);

	}

	// Sentencias SQL
	private static final String SQL_GET_ALL = "SELECT `id`, `nombre`, `codigo` FROM `curso` ORDER BY `id` DESC LIMIT 1000;";
	private static final String SQL_GET_ALL_FILTER = "SELECT `id`, `nombre`, `codigo` FROM `curso` WHERE `nombre` LIKE '%' ? '%' ORDER BY `nombre` ASC;";
	private static final String SQL_GET_LAST_TEN = "SELECT `id`, `nombre`, `codigo` FROM `curso` ORDER BY `id` DESC LIMIT 10;";
	private static final String SQL_GET_BY_ID = "SELECT `id`, `nombre`, `codigo` FROM `curso` WHERE `id` = ?;";
	private static final String SQL_INSERT = "INSERT INTO `curso` (`nombre`, `codigo`) VALUES (?, ?);";
	private static final String SQL_UPDATE = "UPDATE `curso` SET `nombre`= ? , `codigo`= ? WHERE `id`= ? ;";
	private static final String SQL_DELETE = "DELETE FROM `curso` WHERE `id` = ?;";

	@Override()
	public List<Curso> getALL(String filtro) {

		ArrayList<Curso> lista = new ArrayList<Curso>();

		try {

			if (filtro == null) {

				this.LOG.trace("Listar todos los cursos");
				lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL, new CursoMapper());

			} else {

				this.LOG.trace("Filtrar todos los cursos que contengan la palabra: " + filtro);
				lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_ALL_FILTER, new CursoMapper());

			}

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("No existen cursos todavia", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return lista;
	}

	@Override()
	public List<Curso> getTenLast() {

		this.LOG.trace("Listar los ultimos 10 cursos");

		ArrayList<Curso> lista = new ArrayList<Curso>();

		try {

			lista = (ArrayList<Curso>) this.jdbcTemplate.query(SQL_GET_LAST_TEN, new CursoMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("No existen cursos todavia", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return lista;
	}

	@Override()
	public Curso getById(long id) {

		this.LOG.trace("Buscar curso por su ID: " + id);

		Curso c = new Curso();

		try {

			c = this.jdbcTemplate.queryForObject(SQL_GET_BY_ID, new Object[] { id }, new CursoMapper());

		} catch (EmptyResultDataAccessException e) {

			this.LOG.warn("No existen cursos todavia", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return c;
	}

	@Override()
	public boolean insert(final Curso c) {

		this.LOG.trace("insertar nuevo curso " + c);
		boolean resul = false;

		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();

			int affectedeRows = this.jdbcTemplate.update(new PreparedStatementCreator() {

				@Override()
				public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
					PreparedStatement ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
					ps.setString(1, c.getNombre());
					ps.setString(2, c.getCodigo());

					return ps;
				}
			}, keyHolder);

			if (affectedeRows == 1) {
				c.setId(keyHolder.getKey().longValue());
				resul = true;
			}
		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return resul;
	}

	@Override()
	public boolean update(Curso c) {

		this.LOG.trace("update curso: " + c);
		boolean resul = false;

		try {

			Object[] argumentos = { c.getNombre(), c.getCodigo(), c.getId() };
			int affectedRows = this.jdbcTemplate.update(SQL_UPDATE, argumentos);

			if (affectedRows == 1) {
				resul = true;
			}

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return resul;
	}

	@Override()
	public boolean delete(long id) {

		this.LOG.trace("eliminar " + id);
		boolean resul = false;

		try {

			int affectedRows = this.jdbcTemplate.update(SQL_DELETE, id);

			if (affectedRows == 1) {
				resul = true;
			}
		} catch (DataIntegrityViolationException e) {

			this.LOG.warn("No se puede eliminar", e);

		} catch (Exception e) {

			this.LOG.error(ERROR_INESPERADO, e);

		}

		return resul;
	}

}

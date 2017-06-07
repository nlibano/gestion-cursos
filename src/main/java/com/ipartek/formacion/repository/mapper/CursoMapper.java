package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Curso;

public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet rs, int numRow) throws SQLException {

		Curso c = new Curso();

		c.setId(rs.getLong("id"));
		c.setNombre(rs.getString("NomCurso"));
		c.setCodigo(rs.getString("CodCurso"));

		return c;
	}

}

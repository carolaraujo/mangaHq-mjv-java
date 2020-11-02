package br.com.mjv.mangahq.usuario.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjv.mangahq.enums.TipoUsuario;
import br.com.mjv.mangahq.usuario.model.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setId_usuario(rs.getInt("id_usuario"));
		usuario.setLogin(rs.getString("login"));
		usuario.setNome(rs.getString("nome"));
		usuario.setTipoUsuario(TipoUsuario.valueOf(rs.getString("tipoUsuario")));
		usuario.setDataCriacao(rs.getDate("dataCriacao"));
		
		return usuario;
	}

}

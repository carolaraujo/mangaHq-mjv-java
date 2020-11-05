package br.com.mjv.mangahq.usuario.model;

import java.util.Date;

import br.com.mjv.mangahq.enums.TipoUsuario;

/**
 * Classe representando a tabela TB_USUARIO
 * @author renan
 */
public class Usuario {

	private Integer id_usuario;
	private String nome;
	private String login;
	private TipoUsuario tipoUsuario;
	private Date dataCriacao;
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getTipoUsuario() {
		return tipoUsuario.name();
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}

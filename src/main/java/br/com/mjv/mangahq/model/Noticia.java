package br.com.mjv.mangahq.model;

import java.util.Date;

/**
 * Classe representando a tabela TB_NOTICIAS
 * @author kaique
 *
 */

public class Noticia {
	
	private Long id;
	private String titulo;
	private String textoConteudo;
	private String urlImagem;
	private Date dataPublicacao;
	private String autor;
	private Long acessos;
	
	public Long getAcessos() {
		return acessos;
	}
	public void setAcessos(Long acessos) {
		this.acessos = acessos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTextoConteudo() {
		return textoConteudo;
	}
	public void setTextoConteudo(String textoConteudo) {
		this.textoConteudo = textoConteudo;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}

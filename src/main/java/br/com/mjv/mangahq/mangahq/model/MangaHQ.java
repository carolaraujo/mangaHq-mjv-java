package br.com.mjv.mangahq.mangahq.model;

import java.util.Date;

/**
 * Classe representando a tabela TB_MANGAS_HQS
 * @author renan
 *
 */

public class MangaHQ {

	private Integer id_mangahq;
	private String titulo;
	private String autor;
	private String urlCapa;
	private Date dataAdicao;
	private String categoria;
	private Integer volumes;
	private String resumo;
	
	public Integer getId_mangahq() {
		return id_mangahq;
	}
	public void setId_mangahq(Integer id_mangahq) {
		this.id_mangahq = id_mangahq;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getUrlCapa() {
		return urlCapa;
	}
	public void setUrlCapa(String urlCapa) {
		this.urlCapa = urlCapa;
	}
	public Date getDataAdicao() {
		return dataAdicao;
	}
	public void setDataAdicao(Date dataAdicao) {
		this.dataAdicao = dataAdicao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Integer getVolumes() {
		return volumes;
	}
	public void setVolumes(Integer volumes) {
		this.volumes = volumes;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}	
}

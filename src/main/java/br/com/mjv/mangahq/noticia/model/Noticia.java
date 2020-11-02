package br.com.mjv.mangahq.noticia.model;

import java.util.Date;

import br.com.mjv.mangahq.enums.Categoria;

/**
 * Classe representando a tabela TB_NOTICIAS
 * @author kaique
 *
 */
public class Noticia {
	

	
	private Long id_noticia;
	private String titulo;
	private String textoConteudo;
	private String urlImagem;
	private Date dataPublicacao;
	private String autor;
	private Long acessos;
	private Categoria categoria;
	
	public Long getAcessos() {
		return acessos;
	}
	public void setAcessos(Long acessos) {
		this.acessos = acessos;
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Long getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(Long id_noticia) {
		this.id_noticia = id_noticia;
	}
	
	@Override
	public String toString() {
		return "Noticia [id_noticia=" + id_noticia + ", titulo=" + titulo + ", textoConteudo=" + textoConteudo
				+ ", urlImagem=" + urlImagem + ", dataPublicacao=" + dataPublicacao + ", autor=" + autor + ", acessos="
				+ acessos + ", categoria=" + categoria + "]";
	}
}

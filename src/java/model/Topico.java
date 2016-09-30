/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Topico {

	private int id_topico;
	private String titulo;
	private String conteudo;
	private String login;
	
	public Topico(){}
	
	public Topico(String titulo, String conteudo, String login) {
		super();
		this.id_topico = 0;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.login = login;
	}

	public Topico(int id_topico, String titulo, String conteudo, String login) {
		super();
		this.id_topico = id_topico;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.login = login;
	}

	public int getId_topico() {
		return id_topico;
	}

	public void setId_topico(int id_topico) {
		this.id_topico = id_topico;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	

	
}


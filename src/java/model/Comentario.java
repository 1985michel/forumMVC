
package model;


public class Comentario {

	public int id_comentario;
	public String comentario;
	public int id_topico;
	public String login;
	
	private Comentario(){}

	public Comentario(String comentario, int id_topico, String login) {
		super();
		this.id_comentario = 0;
		this.comentario = comentario;
		this.id_topico = id_topico;
		this.login = login;
	}
	
	public Comentario(int id_comentario, String comentario, int id_topico, String login) {
		super();
		this.id_comentario = id_comentario;
		this.comentario = comentario;
		this.id_topico = id_topico;
		this.login = login;
	}

	public int getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(int id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getId_topico() {
		return id_topico;
	}

	public void setId_topico(int id_topico) {
		this.id_topico = id_topico;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	
}

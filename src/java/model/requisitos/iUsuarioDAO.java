package model.requisitos;

import java.util.List;

import model.Usuario;

public interface iUsuarioDAO {

	// insere um novo usu�rio no banco de dados
	public void inserir(Usuario u);

	// recupera o usu�rio pelo seu login
	public Usuario recuperar(String login);

	// adiciona os pontos para o usu�rio no banco
	public void adicionarPontos(String login, int pontos);

	// retorna a lista de usu�rios ordenada por pontos (maior primeiro)
	public List<Usuario> ranking();

}
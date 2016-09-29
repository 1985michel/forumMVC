
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.requisitos.iUsuarioDAO;

public class UsuarioDAO implements iUsuarioDAO {

	private CRUD crud;

	public UsuarioDAO(CRUD crud) {
		this.crud = crud;
	}

	@Override
	public void inserir(Usuario u){

		try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
				crud.getDbUser().getSenha())) {
			String query = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, u.getLogin());
			stm.setString(2, u.getEmail());
			stm.setString(3, u.getNome());
			stm.setString(4, u.getSenha());
			stm.setInt(5, u.getPontos());
			stm.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro no CRUD" + ex);
                        
		}
		System.out.println("Usuario Criado com Sucesso!");
	}

	@Override
	public Usuario recuperar(String login) {
		try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
				crud.getDbUser().getSenha())) {
			String query = "SELECT * FROM usuario WHERE login = ?;";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				return new Usuario(rs.getString("login"), rs.getString("email"), rs.getString("nome"),
						rs.getString("senha"), rs.getInt("pontos"));
			}
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro no CRUD" + ex);
                        return null;
		}
		return null;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
				crud.getDbUser().getSenha())) {
			String query = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?;";
			PreparedStatement stm = con.prepareStatement(query);
			stm.setString(2, login);
			stm.setInt(1, pontos);
			stm.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro no CRUD" + ex);
		}
		System.out.println("Pontua��o registrada com Sucesso!");

	}

	@Override
	public List<Usuario> ranking() {
		List<Usuario> ranking = new ArrayList<>();
		try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
				crud.getDbUser().getSenha())) {
			String query = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement stm = con.prepareStatement(query);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ranking.add(new Usuario(rs.getString("login"), rs.getString("email"), rs.getString("nome"),
						rs.getString("senha"), rs.getInt("pontos")));
			}

		} catch (SQLException ex) {
			System.out.println("Ocorreu um erro no CRUD" + ex);
		}

		return ranking;
	}

}


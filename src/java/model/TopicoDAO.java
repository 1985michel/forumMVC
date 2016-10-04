package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TopicoDAO {

    private CRUD crud;

    public TopicoDAO() {
        crud = new CRUD(new DbUser("postgres", "livre01"));
    }

    public TopicoDAO(CRUD crud) {
        super();
        this.crud = crud;
    }

    public void inserir(Topico t) {
        try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
                crud.getDbUser().getSenha())) {
            String query = "INSERT INTO topico(titulo, conteudo, login) VALUES (?, ?, ?);";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1, t.getTitulo());
            stm.setString(2, t.getConteudo());
            stm.setString(3, t.getLogin());
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro no CRUD" + ex);
        }
        new Pontuadora().pontuaCriacaoDeTopico(t.getLogin());
    }

    public List<Topico> getTodosTopicos() {
        List<Topico> lista = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
                crud.getDbUser().getSenha())) {
            String query = "SELECT * FROM topico ORDER BY id_topico DESC";
            PreparedStatement stm = con.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                lista.add(new Topico(rs.getInt("id_topico"), rs.getString("titulo"), rs.getString("conteudo"), rs.getString("login")));
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro no CRUD" + ex);
        }

        return lista;
    }

    public Topico recuperar(int id) {
        try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
                crud.getDbUser().getSenha())) {
            String query = "SELECT * FROM topico WHERE id_topico = ?;";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Topico(rs.getInt("id_topico"), rs.getString("titulo"), rs.getString("conteudo"),rs.getString("login"));
            }
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro no CRUD" + ex);
            return null;
        }
        return null;
    }

}

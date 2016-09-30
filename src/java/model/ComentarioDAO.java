/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {

    private CRUD crud;

    public ComentarioDAO() {
        crud = new CRUD(new DbUser("postgres", "livre01"));
    }

    public void comentar(Comentario c) {

        try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
                crud.getDbUser().getSenha())) {
            String query = "INSERT INTO comentario(id_topico, login, comentario) VALUES (?, ?, ?);";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, c.getId_topico());
            stm.setString(2, c.getLogin());
            stm.setString(3, c.getComentario());
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro no CRUD" + ex);
        }
    }

    public List<Comentario> getTodosComentariosDeUmTopico(int id_topico) {
        List<Comentario> lista = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(crud.address, crud.getDbUser().getLogin(),
                crud.getDbUser().getSenha())) {
            String query = "SELECT * FROM comentario WHERE id_topico = ? ORDER BY id_comentario";
            PreparedStatement stm = con.prepareStatement(query);
            stm.setInt(1, id_topico);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                lista.add(new Comentario(rs.getInt("id_comentario"), rs.getString("comentario"), rs.getInt("id_topico"), rs.getString("login")));
            }

        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro no CRUD" + ex);
        }

        return lista;
    }

}

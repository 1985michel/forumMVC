/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author michel
 */
public class Logadora {



    public static boolean autenticar(String login, String senha) {

        try {
            CRUD crud = new CRUD(new DbUser("postgres", "livre01"));
            Usuario user = new UsuarioDAO(crud).recuperar(login);
            if (user != null && user.getSenha().equals(senha)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;

        }
    }
}

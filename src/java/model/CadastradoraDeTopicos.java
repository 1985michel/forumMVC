/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.CadastradoraDeUsuarios.isLoginDisponivel;

/**
 *
 * @author michel
 */
public class CadastradoraDeTopicos {

    public static void cadastrarTopico(String login, String titulo, String conteudo) throws Exception {

        try {
            // CRUD crud = new CRUD(new DbUser("postgres", "livre01"));
            new TopicoDAO().inserir(new Topico(login, titulo, conteudo));

           // new TopicoDAO(crud).inserir(new Topico(login, titulo, conteudo));

        } catch (Exception e) {
            throw new Exception("Erro. Tópico não cadastrado.");

        }
    }

}

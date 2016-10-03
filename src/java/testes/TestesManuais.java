/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CadastradoraDeTopicos;
import model.*;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author michel
 */
public class TestesManuais {

    public static void main(String... args) {

        List<Comentario> lista = new ComentarioDAO().getTodosComentariosDeUmTopico(19);

        for (Comentario c : lista) {
            System.out.println(c.getComentario());
        }

    }
}

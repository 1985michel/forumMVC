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

/**
 *
 * @author michel
 */
public class TestesManuais {

    public static void main(String... args) {

        Topico t = new TopicoDAO().recuperar(9);
        System.out.println(t.getTitulo());
        System.out.println(t.getLogin());
        System.out.println(t.getConteudo());
        System.out.println(t.getId_topico());

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.CadastradoraDeTopicos;

/**
 *
 * @author michel
 */
public class TestesManuais {
    
    public static void main(String... args){
        
        
        try {
            CadastradoraDeTopicos.cadastrarTopico("MICHEL", "titulo", "MICHEL");
        } catch (Exception ex) {
            Logger.getLogger(TestesManuais.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

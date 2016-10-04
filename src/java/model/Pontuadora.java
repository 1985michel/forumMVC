/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.List;

/**
 * O objetivo dessa classe é calcular os pontos de cada usuário
 * Temos 3 tabelas: usuario, topico e comentario
 * devemos criar um hashMap com o login como key (string) e a quantidade de pontos como value ( integer)
 * daí vamos percorrer a tabela tópico gerando a pontuação
 * tambem percorreremos a tebela comentario gerando a pontuação
 * 
 * @author michel
 */
public class Pontuadora {
    
    public static final int PONTO_POR_TOPICO_CRIADO = 10;
    public static final int PONTO_POR_COMENTARIO =3;
    
    public void pontuaCriacaoDeTopico(String login){
                      new UsuarioDAO().adicionarPontos(login, PONTO_POR_TOPICO_CRIADO);
    }
    
    public void pontuaComentario(String login){
                      new UsuarioDAO().adicionarPontos(login,PONTO_POR_COMENTARIO);
    }
    
    
}

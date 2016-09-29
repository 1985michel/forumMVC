
package model;

/**
 *
 * @author michel
 */
public class Cadastradora {

  
    public static void cadastrar(String login,String nome,String email, String senha) throws Exception {

        if(!isLoginDisponivel(login)){
            throw new Exception("Erro. Este LOGIN já está em uso. Tente outro login.");
        }
            
        
        try {
             CRUD crud = new CRUD(new DbUser("postgres", "livre01"));
             new UsuarioDAO(crud).inserir(new Usuario(login, email, nome, senha, 0));        
            
        } catch (Exception e) {
            throw new Exception("Erro. Usuário não cadastrado.");
            
        }
    }
    
    public static boolean isLoginDisponivel(String login){
        try {
            CRUD crud = crud = new CRUD(new DbUser("postgres", "livre01"));
            Usuario user = new UsuarioDAO(crud).recuperar(login);
            if (user == null ) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;

        }
    }
}


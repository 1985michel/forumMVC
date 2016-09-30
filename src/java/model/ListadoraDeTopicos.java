
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michel
 */
public class ListadoraDeTopicos {
    
    public static List<Topico> getTodosTopicos(){
        
        List<Topico> lista = new ArrayList<>();
        try {
             lista = new TopicoDAO().getTodosTopicos();
            return lista;
        } catch (Exception e) {
            lista.add(new Topico("não foi possível obter as informações",
                    "não foi possível obter as informações", "não foi possível obter as informações"));
            return lista;
        }
    }
    
    
    
}

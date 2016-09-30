package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TopicoDAO {

    private CRUD crud;

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
    }

    public void editarTopico(Topico topico) {
    }

    public void excluirTopico(int id_topico) {
    }

    public void excluirTodosTopicosDeUmUsuario(String usuario) {
    }

    public List<Topico> getTodosTopicos() {
        return null;
    }

}

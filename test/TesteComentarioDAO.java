
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import model.CRUD;
import model.Comentario;
import model.ComentarioDAO;
import model.DbUser;
import model.Topico;
import model.TopicoDAO;
import model.UsuarioDAO;
import model.Usuario;
import org.dbunit.dataset.DataSetException;
import org.junit.After;
import org.junit.AfterClass;

/**
 *
 * @author michel
 */
public class TesteComentarioDAO {

    JdbcDatabaseTester jdt;
    CRUD crud;

    @Before
    public void setUp() throws Exception {
        //crud = new CRUD(new DbUser("michel", "12345"));
        //jdt = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());

        crud = new CRUD(new DbUser("postgres", "livre01"));
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/inicioComentario.xml"));
        jdt.onSetup();
    }

    @Test
    public void testeGetTodosComentarios() throws Exception {
        List<Comentario> lista = new ComentarioDAO().getTodosComentariosDeUmTopico(0);
        assertEquals(2, lista.size());
    }

    @Test
    public void testeInsereNovoComentario() throws SQLException, Exception {
                
        //<comentario id_comentario="2" comentario="Terceiro comentario" id_topico="0" login="MARIA"/> 
        Comentario comentario = new Comentario(2, "Terceiro comentario", 0, "MARIA");
        new ComentarioDAO().comentar(comentario);
        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("Comentario");

        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = (loader.load("/verificaComentario.xml"));
        ITable expectedTable = expectedDataSet.getTable("Comentario");

        String[] colIgnorada = {"id_comentario"};

        Assertion.assertEqualsIgnoreCols(expectedTable, currentTable, colIgnorada);

    }
    
    @After
    public void cleanUp() throws Exception {
        //crud = new CRUD(new DbUser("michel", "12345"));
        //jdt = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());

        crud = new CRUD(new DbUser("postgres", "livre01"));
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/inicioComentario.xml"));
        jdt.onSetup();
    }

}

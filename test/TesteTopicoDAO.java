
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
import model.DbUser;
import model.Topico;
import model.TopicoDAO;
import model.UsuarioDAO;
import model.Usuario;
import org.junit.After;

/**
 *
 * @author michel
 */
public class TesteTopicoDAO {
    
    JdbcDatabaseTester jdt;
	CRUD crud;

	
	@Before
	public void setUp() throws Exception{
		//crud = new CRUD(new DbUser("michel", "12345"));
		//jdt = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
		
		
		crud = new CRUD(new DbUser("postgres", "livre01"));
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicioTopico.xml"));
		jdt.onSetup();
	}
        
        @Test
	public void testeGetTodosTopicos() {
		List<Topico> lista = new TopicoDAO().getTodosTopicos();
		assertEquals(2, lista.size());
                //primeiro
                assertEquals(0,lista.get(1).getId_topico());
		assertEquals("JOAO",lista.get(1).getLogin());
                assertEquals("First Topico",lista.get(1).getTitulo());
                assertEquals("Primeiro topico para testes",lista.get(1).getConteudo());
                
                
                //segundo
		assertEquals(1,lista.get(0).getId_topico());
		assertEquals("MARIA",lista.get(0).getLogin());
                assertEquals("Second Topico",lista.get(0).getTitulo());
                assertEquals("Segundo topico para testes",lista.get(0).getConteudo());
	}
        
        @Test
	public void testeInsereNovoTopico() throws SQLException, Exception {
		Topico topico = new Topico(2,"Terceiro Topico", "Terceiro topico para testes", "JOAO");
		new TopicoDAO().inserir(topico);
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("Topico");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = (loader.load("/verificaTopico.xml"));
		ITable expectedTable = expectedDataSet.getTable("Topico");
		
		Assertion.assertEquals(expectedTable, currentTable);

	}
        
        @After
        public void cleanUp() throws Exception{
		//crud = new CRUD(new DbUser("michel", "12345"));
		//jdt = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
		
		
		crud = new CRUD(new DbUser("postgres", "livre01"));
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/fimTopico.xml"));
		jdt.onSetup();
	}
    
}

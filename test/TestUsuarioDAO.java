
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
import model.UsuarioDAO;
import model.Usuario;

public class TestUsuarioDAO {
	
	JdbcDatabaseTester jdt;
	CRUD crud;

	
	@Before
	public void setUp() throws Exception{
		//crud = new CRUD(new DbUser("michel", "12345"));
		//jdt = new JdbcDatabaseTester("org.hsqldb.jdbcDriver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
		
		
		crud = new CRUD(new DbUser("postgres", "livre01"));
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", crud.address, crud.getDbUser().getLogin(), crud.getDbUser().getSenha());
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}

        
	@Test
	public void testeRanking() {
		List<Usuario> lista = new UsuarioDAO(crud).ranking();
		assertEquals(2, lista.size());
		assertEquals("JOAO",lista.get(1).getLogin());
		assertEquals("MARIA",lista.get(0).getLogin());
	}
	
	@Test
	public void testeInsereNovo() throws SQLException, Exception {
		Usuario user = new Usuario("MICHEL", "MICHEL@EMAIL.COM", "MICHEL FERNANDES", "MF123", 10);
		new UsuarioDAO(crud).inserir(user);
		IDataSet currentDataSet = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("Usuario");
		
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataSet = (loader.load("/verifica.xml"));
		ITable expectedTable = expectedDataSet.getTable("Usuario");
		
		Assertion.assertEquals(expectedTable, currentTable);

	}
	
	@Test
	public void testRecuperaPeloLogin() throws SQLException, Exception {
		Usuario user = new UsuarioDAO(crud).recuperar("JOAO");
		assertEquals(user.getEmail(),"JOAO@EMAIL.COM");
		assertEquals(user.getNome(),"JOAO DA SILVA");
		assertEquals(user.getPontos(),10);
		assertEquals(user.getSenha(),"12345");
	}
	
        
	@Test
	public void testAdicionarPontos() throws SQLException, Exception {
		Usuario user = new UsuarioDAO(crud).recuperar("JOAO");
		new UsuarioDAO(crud).adicionarPontos(user.getLogin(), 30);
		
		Usuario recuperado = new UsuarioDAO(crud).recuperar("JOAO");
		assertEquals(recuperado.getPontos(),40);
		
	}
        

}


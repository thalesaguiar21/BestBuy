/**
 * 
 */
package testesjunit;

import static org.junit.Assert.*;

import org.junit.Test;
import Geral.Minerador;
import Geral.Picareta;


/**
 * @author Geovanni, Thales e Rafael
 *
 */
public class MineradorTest {
	static Picareta ex;
	static Minerador minerador;
	
	public static void setUpBeforeClass() throws Exception {
		minerador = new Minerador();
	}
	
	//teste1
	/**
	 * @throws java.lang.Exception
	 */
	public static void setUp_null() throws Exception {
		ex = null;
	}
	/**
	/**
	 * @throws java.lang.Exception
	 */
	//teste1
	public void teste1_null() throws Exception {
		assertEquals(false, minerador.minerar(ex));}

	
	@Test
	public void testMinerar() throws Exception {
		setUpBeforeClass();
		// teste picareta null
			setUp_null();
			teste1_null();
		
		
		// a corretude dos links depende do baseUrl da picareta que testaremos em cada uma (uma vez que sabemos ser possivel fazer uma picareta para outro site)
	}

}
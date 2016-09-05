/**
 * 
 */
package testesjunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Geral.Picareta;
import Geral.PicaretaDeNiveis;

/**
 * @author Geovanni, Thales e Rafael
 *
 */
public class PicaretaDeNiveisTest {

	Picareta picdn;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		picdn = new PicaretaDeNiveis();
	}

	/**
	 * Test method for {@link Geral.PicaretaDeBFamilia#crawl(java.lang.String)}.
	 */
	@Test
	public void test_baseUrl() {
		assertEquals(true, picdn.getBaseUrl().contains("portaldatransparencia.gov.br"));
	}
	
	/**
	 * Test method for {@link Geral.PicaretaDeNiveis#PicaretaDeNiveis()}.
	 * @throws Exception 
	 */
	@Test
	public void testPicaretaDeNiveis() throws Exception {
		setUp();
		test_baseUrl();
	}

}

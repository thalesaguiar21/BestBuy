/**
 * 
 */
package testesjunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import framework.webcrawler.Picareta;
import webcrawler.PicaretaDeNiveis;

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
	 * Test method for {@link webcrawler.PicaretaDeBFamilia#crawl(java.lang.String)}.
	 */
	@Test
	public void test_baseUrl() {
		assertEquals(true, picdn.getBaseUrl().contains("portaldatransparencia.gov.br"));
	}
	
	/**
	 * Test method for {@link webcrawler.PicaretaDeNiveis#PicaretaDeNiveis()}.
	 * @throws Exception 
	 */
	@Test
	public void testPicaretaDeNiveis() throws Exception {
		setUp();
		test_baseUrl();
	}

}

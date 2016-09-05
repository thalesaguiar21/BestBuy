/**
 * 
 */
package testesjunit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Geral.Picareta;
import Geral.PicaretaDeBFamilia;

/**
 * @author Geovanni, Thales e Rafael
 *
 */
public class PicaretaDeBFamiliaTest {

	Picareta picbf;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		picbf = new PicaretaDeBFamilia();
	}

	/**
	 * Test method for {@link Geral.PicaretaDeBFamilia#crawl(java.lang.String)}.
	 */
	@Test
	public void test_baseUrl() {
		assertEquals(true, picbf.getBaseUrl().contains("portaldatransparencia.gov.br"));
	}
	/**
	 * Test method for {@link Geral.PicaretaDeBFamilia#PicaretaDeBFamilia()}.
	 * @throws Exception 
	 */
	@Test
	public void testPicaretaDeBFamilia() throws Exception {
		setUp();
		test_baseUrl();
	}

}
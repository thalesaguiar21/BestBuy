package testesjunit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MineradorTest.class, PicaretaDeBFamiliaTest.class, PicaretaDeNiveisTest.class })
public class AllTests {

}

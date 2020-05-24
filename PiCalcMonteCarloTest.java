import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PiCalcMonteCarloTest {

	@Test
	void testpicalc() throws InterruptedException {
		double deltapi = 0.05;
		double pi = 3.1415926;
		int numberthread = 8;
		PiCalcMonteCarlo picalc = new PiCalcMonteCarlo();
		double calcpi = picalc.picalculate(numberthread);		
		assertEquals(pi, calcpi, deltapi);
	}

}

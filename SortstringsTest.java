import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortstringsTest {

	String[] inarr = new String[] {"123456","123","1234567","12345678","1234"};
	String[] lessarr = new String[] {"123","1234"};
	String[] morearr = new String[] {"123456","1234567","12345678"};
	Sortstrings sortstrings = new Sortstrings();

	@Test
	void testlessaverage() {
		String []  outarr =	sortstrings.lengthlessaverage(inarr);
		Assertions.assertEquals(lessarr.length, outarr.length);	
	}
	
	@Test
	void testmoreaverage() {
		String []  outarr =	sortstrings.lengthmoreaverage(inarr);
		Assertions.assertEquals(morearr.length, outarr.length);	
	}
	
	@Test
	void testcalcaverage() {
		double  outarr =	sortstrings.calcaverage(inarr);
		Assertions.assertEquals(5.6, outarr);	
	}

}

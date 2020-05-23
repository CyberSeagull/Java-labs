import org.junit.Assert;

import org.junit.jupiter.api.Test;

class VehicleTest {

	@Test
	  public void testallseatsaretakenException() throws allseatsaretakenException {
		Taxi<Person> taxi = new Taxi<Person>(1,1);
		Person person1 = new Person(1);
		Person person2 = new Person(2);
		taxi.boarding(person1);
		try {		
			taxi.boarding(person2);
   	    Assert.fail("expected = allseatsaretakenException");
		} catch (allseatsaretakenException thrown) {
			Assert.assertEquals("All seats are already taken.", thrown.getMessage());	
		}
	    
	}

}

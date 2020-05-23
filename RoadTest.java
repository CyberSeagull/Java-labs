import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoadTest {

	Road road = new Road();
	Bus<Person> bus = new Bus<Person>(1,40);
	Car<Person> car = new Car<Person>(2,8);
	Taxi<Person> taxi = new Taxi<Person>(3,2);
	Policecar<Policeman> policecar = new Policecar<Policeman>(4,4);
	Firetruck<Fireman> firetruck = new Firetruck<Fireman>(5,8);		

	Person person = new Person(1);
	Person person2 = new Person(2);
	Fireman fireman = new Fireman(3);
	Fireman fireman2 = new Fireman(4);
	Policeman policeman = new Policeman(5);
	Policeman policeman2 = new Policeman(6);
	Person person3 = new Person(3);
	

	@Test	
	public void testallseatsaretakenException() throws allseatsaretakenException {
		taxi.boarding(person);
		taxi.boarding(fireman);
		try {		
			taxi.boarding(policeman);
			Assert.fail("expected = allseatsaretakenException");
		} catch (allseatsaretakenException thrown) {
				Assert.assertEquals("All seats are already taken.", thrown.getMessage());	
			}
		}
	
	@Test	
	public void testnopassengerException() throws nopassengerException {
		taxi.boarding(person);
		try {		
			taxi.disembarkation(person2);
			Assert.fail("expected = nopassengerException");
		} catch (nopassengerException thrown) {
				Assert.assertEquals("The passenger is not in the vehicle.", thrown.getMessage());	
			}
		}
	
	@Test	
	public void testgetCountOfHumans() {

		bus.boarding(person);
		bus.boarding(policeman);
		bus.boarding(fireman);
		car.boarding(person2);
		taxi.boarding(person3);
		policecar.boarding(policeman2);
		firetruck.boarding(fireman2);

		road.addCarToRoad(bus);
		road.addCarToRoad(car);
		road.addCarToRoad(taxi);
		road.addCarToRoad(firetruck);
		road.addCarToRoad(policecar);

		Assertions.assertEquals(7, road.getCountOfHumans());			

		bus.disembarkation(policeman);
		taxi.disembarkation(person3);
		Assertions.assertEquals(5, road.getCountOfHumans());			
		
	}



}

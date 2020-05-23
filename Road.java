import java.util.ArrayList;
import java.util.List;

public class Road
{
public List<Vehicle<?>> carsInRoads = new ArrayList<>();
	
	public int getCountOfHumans(){
		int counth=0;
		for (Vehicle<?> vehicle : carsInRoads) 
			counth+=vehicle.getcounthumans();
		return counth; 
	}
	public void addCarToRoad(Vehicle<?>  car ){
		if (!carsInRoads.contains(car))   
		carsInRoads.add(car);
		 }
}

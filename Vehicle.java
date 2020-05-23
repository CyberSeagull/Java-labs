import java.util.ArrayList;
import java.util.List;


class allseatsaretakenException extends RuntimeException{		
	allseatsaretakenException(){}			
	allseatsaretakenException(String msg){			
		super(msg); 		
	}	
}
	
class nopassengerException extends RuntimeException{
	nopassengerException(){}
	nopassengerException(String msg){
		super(msg);   		
	}
}
public class Vehicle  <P extends Person>{		
	int idVehicle;           
	int maxseats=0;

	public List<P> humans = new ArrayList<>();	
	public Vehicle (int idVehicle, int maxseats) {				
		this.idVehicle = idVehicle;	    
		this.maxseats = maxseats;		    
	}			
	public int getmaxseats ()
	{
		return maxseats;	
	};
	
	public int getcounthumans () 
	{ 		
		return humans.size();		
	};
	public void boarding (P person) 
	{ 		
		if (humans.size()>=maxseats) {
			throw new allseatsaretakenException("All seats are already taken.");
		}				
		if (!humans.contains(person))   
		humans.add(person);
	};
	
	public void disembarkation (P person) 
	{ 	
		if (humans.contains(person))   
			humans.remove(person);
		else  			
			throw new nopassengerException("The passenger is not in the vehicle.");
	};	
}	

class Bus <P extends Person> extends Vehicle<P> {		
	public Bus (int idVehicle, int maxseats) {				
		super(idVehicle, maxseats);		    
	}			
}	

class Car <P extends Person> extends Vehicle<P>{		
	public Car (int idVehicle, int maxseats) {				
		super(idVehicle, maxseats);		    
	}			
}	

class Taxi <P extends Person> extends Car<P> {		
	public Taxi (int idVehicle, int maxseats) {				
		super(idVehicle, maxseats);		    
	}			
}	

class Policecar <P extends Policeman> extends Car<P> {		
	public Policecar (int idVehicle, int maxseats) {				
		super(idVehicle, maxseats);		    
	}			
}	

class Firetruck <P extends Fireman> extends Car<P> {		
	public Firetruck (int idVehicle, int maxseats) {				
		super(idVehicle, maxseats);		    
	}			
}	

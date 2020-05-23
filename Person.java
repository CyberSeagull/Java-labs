
public class Person 
{
	int id;         
	public Person (int id) {				
		this.id = id;	    
	}
}

class Fireman extends Person{
	public Fireman (int id) {				
		super(id);		    
	}
}

class Policeman extends Person{
	public Policeman (int id) {				
		super(id);		    
	}
}

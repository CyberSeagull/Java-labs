import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;

public class Fileencryption 
{
	char keysymbol;
	int maxchar = 128;
		public Fileencryption (char keysymbol) {
		this.keysymbol = keysymbol;
	    }

	public void setkeysymbol (char keysymbol)
	{
		this.keysymbol = keysymbol;
	}

	public char getkeysymbol()
	{
		return this.keysymbol;
	}
	public void codeinoutfile(String fileinput, String fileoutput) throws Exception {			   
		FileReader reader = new FileReader(fileinput);
		FilterReader fr = new FilterReader(reader) {};
		FileWriter writer = new FileWriter(fileoutput);
		EncodeDecodeFW fw = new EncodeDecodeFW(writer);
			      
		int c = keysymbol;
		int i;
		while((i=fr.read())!=-1)				   				  
			fw.write(i, c, true);			      			
		fr.close();			   
		fw.close();			      
	   }
	
	public void decodeinoutfile(String fileinput, String fileoutput) throws Exception {			   
		FileReader reader = (new FileReader(fileinput));
	    FilterReader fr = new FilterReader(reader) {};
	    FileWriter writer = new FileWriter(fileoutput);
		EncodeDecodeFW fw = new EncodeDecodeFW(writer);
			      			   
		int c = keysymbol;
		int i;
	    while((i=fr.read())!=-1)		
	    {				   
	    	fw.write(i, c, false);			      		   
	    }			      			   
	    fr.close();			   
	    fw.close();			      
	   }
}

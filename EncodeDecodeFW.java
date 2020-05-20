import java.io.FileWriter;
import java.io.FilterWriter;
public class EncodeDecodeFW extends FilterWriter{
	
	public EncodeDecodeFW (FileWriter writer) {
		super(writer);
    }
	public void write(int readc, int keysymbol, boolean yescode) throws Exception 
	{				
		int maxchar = 128; 			
		if (keysymbol>maxchar) 				
			return;			
		if (yescode) { 				
			readc+=keysymbol;				
			if (readc>= maxchar) 					
				readc-= maxchar;							
		}			
		else { 				
			if (readc<keysymbol)					
				readc+=maxchar;				
			readc-=keysymbol;
		      }						 			
		super.write(readc);			 
	}
}

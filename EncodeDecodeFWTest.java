import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;

class EncodeDecodeFWTest {

	@Test
	void test() throws Exception {
	    String codefile = "codefilech.txt";
	    String decodefile = "decodefilech.txt";
	    char chtest;
	    char chin ='C';
	    char chcode ='d';	    
	    char encode ='!';
		   
	    FileWriter fwcode = new FileWriter(codefile);
		EncodeDecodeFW myfwcode = new EncodeDecodeFW(fwcode);
		FileReader frcode = new FileReader(codefile);
		FilterReader frrcode = new FilterReader(frcode) {};
	
		myfwcode.write((int) chin, (int) encode, true);  
		myfwcode.close();
		int i=frrcode.read();
		if (i!=-1) {
			   chtest= (char) i;
				assertEquals(chcode, chtest);
		};
		frrcode.close();
   		
	    FileWriter fwdecode = new FileWriter(decodefile);
		EncodeDecodeFW encodedecodefw = new EncodeDecodeFW(fwdecode);
		FileReader frdecode = new FileReader(decodefile);
		FilterReader frrdecode = new FilterReader(frdecode) {};

		encodedecodefw.write((int) chcode, (int) encode, false);  
		encodedecodefw.close();
		i=frrdecode.read();
		if (i!=-1) {
			   chtest= (char) i;
				assertEquals(chin, chtest);
		};
		frrdecode.close();		   
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

class FileencryptionTest {
	String inputfile = "inputfile.txt";
    String codefile = "codefile.txt";
    String decodefile = "decodefile.txt";
    String strtest;
    String strin ="CLASS FILEENCRYPTIONTEST";
    String strcode   ="dmbttAgjmffodszqujpouftu";
	
    char encode ='!';
    Fileencryption codedecode = new Fileencryption(encode);
			
	
	@Test
	void testcodeinoutfile() throws Exception {
        BufferedWriter fwin = new BufferedWriter(new FileWriter(inputfile));        
		fwin.write(strin);
		fwin.close();
		
		codedecode.codeinoutfile(inputfile, codefile);
		
        BufferedReader frcode = new BufferedReader(new FileReader(codefile));		
		strtest=frcode.readLine();
		frcode.close();

		assertEquals(strcode, strtest);
	}
		 	
    @Test
	void testencodeinoutfile() throws Exception {
        BufferedWriter fwcode = new BufferedWriter(new FileWriter(codefile));		
		fwcode.write(strcode);
		fwcode.close();

		codedecode.decodeinoutfile(codefile, decodefile);

		BufferedReader frdecode = new BufferedReader(new FileReader(decodefile));
		strtest=frdecode.readLine();
		frdecode.close();
		
		assertEquals(strin, strtest);
	}
	
	@Test
	void testclass() throws Exception {        
	    BufferedWriter fwin = new BufferedWriter(new FileWriter(inputfile));	    
		fwin.write(strin);
		fwin.close();

		codedecode.codeinoutfile(inputfile, codefile);

		BufferedReader frcode = new BufferedReader(new FileReader(codefile));
		strtest=frcode.readLine();
		frcode.close();

		assertEquals(strcode, strtest);
		
		codedecode.decodeinoutfile(codefile, decodefile);

		BufferedReader frdecode = new BufferedReader(new FileReader(decodefile));
		strtest=frdecode.readLine();
		frdecode.close();

		assertEquals(strin, strtest);
	}

}

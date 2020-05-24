
public class Mainlab7 {

	public static void main(String[] args) throws InterruptedException {
		int numberthread = 8;
		PiCalcMonteCarlo picalc = new PiCalcMonteCarlo();
		picalc.picalculate(numberthread);

 	    System.out.println(" PI is "+picalc.picalculate(numberthread));
 	    System.out.println(" THREADS "+numberthread);
 	    System.out.println(" ITERATIONS "+picalc.getiterations());
 	    System.out.println(" TIME "+ picalc.gettimework() + " ms");

	}

}

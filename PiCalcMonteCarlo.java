class Pirunnable implements Runnable { 
    private final long iterations;
    public double pointincircle = 0;
    public Pirunnable(long iterations) {
        this.iterations = iterations;        
    } 
    public double getpointincircle() {
    	return pointincircle;
    }
    @Override
    public void run() {
		double x;
		double y;
		for (long j = 0; j < iterations; j++)
		{
			x = Math.random();
			y = Math.random();
			if	((x*x+y*y)<=1) 
				pointincircle++;
		}
    }
}
    
public class PiCalcMonteCarlo {
	   private long iterations = 1000000L;    
	    private long timework = 0L;
	    private long start = 0L;
	    public long gettimework(){
	    	return timework;
	    }
	        public long getiterations(){
	        	return iterations;
	    }
		public double picalculate(int nthreads) throws InterruptedException {
			start = System.currentTimeMillis();
			Pirunnable[] pirunnables = new Pirunnable[nthreads];
			Thread[] pithreads = new Thread[nthreads];
			for (int i = 0; i < nthreads; i++) {
				pirunnables[i] = new Pirunnable(iterations);
				pithreads[i] = new Thread(pirunnables[i]);
				pithreads[i].start();	
			}
			double result = 0.0;
		    for (Thread th : pithreads) 	    		    	
		     	if (th.isAlive()) 
		    		th.join();
			    
		    if (iterations>0)	    
		    	for (Pirunnable pi : pirunnables) 		    		   	    			    		    	
		    		result += 4*pi.pointincircle/(nthreads*iterations);	    

		    timework = System.currentTimeMillis()-start;
		    return result;		    	
		}
}


public class Sortstrings 
{
	public double calcaverage(String [] inarr)
	  {
		int n=inarr.length;
		if (n<1) return 0; 
	    double sum = 0;
	    for (int i=0; i<n; i++)
	      sum+=inarr[i].length();
	    return sum/n;
	  }

	public String [] lengthlessaverage(String [] inarr)
	  {
		int n=inarr.length;
		int numberless=0;
		int kless=0;
	    double average = calcaverage(inarr);
	    for (int i=0; i<n;i++)	      	    	
	    	if (inarr[i].length()<average)
	    	  numberless++;
	    String[] outarr = new String[numberless];
	    for (int i=0; i<n;i++)
		      if (inarr[i].length()<average)
		    	  outarr[kless++]=inarr[i];
	    return outarr;
	  }

	public String [] lengthmoreaverage(String [] inarr)
	  {
		int n=inarr.length;
		int numbermore=0;
		int kmore=0;
	    double average = calcaverage(inarr);
	    for (int i=0; i<n;i++)	      	    	
	    	if (inarr[i].length()>average)
	    	  numbermore++;
	    String[] outarr = new String[numbermore];
	    for (int i=0; i<n;i++)
		      if (inarr[i].length()>average)
		    	  outarr[kmore++]=inarr[i];
	    return outarr;
	  }
}

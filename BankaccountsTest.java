import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankaccountsTest 
{
	public static int rnd(int max) 
	{
		return (int) (Math.random() * ++max);
	}
	@Test
	void test() throws InterruptedException 
	{
		int numberaccount = 2000;
		int numbertransfer = 5000;
		double accountamount = 700;
		Bankaccounts bank = new Bankaccounts();
		for (int i = 0; i < numberaccount; i++) 
		{
			bank.createaccount(i, accountamount);
		}
		double balance = bank.qetbalance();
		Thread[] transfers = new Thread[numbertransfer];
        int n=0;
        while (n<numbertransfer)
        {
			int from = rnd(numberaccount-1);
			int to = rnd(numberaccount-1);
			double amount = rnd(100);
			if (from!=to) 
			{			
				Runnable raccount = new Runnable () 
				{
					@Override 
					public void run() 
					{						
						bank.transfer(bank.accounts.get(from), bank.accounts.get(to), amount);
					}
				};
				transfers[n] = new Thread(raccount);		
				transfers[n].start();
				n++;
			} 
        }		
        for (Thread tr : transfers) 	    		    	
	     	if (tr.isAlive()) 
	    		tr.join();
		assertEquals(balance, bank.qetbalance());	
	} 		
}

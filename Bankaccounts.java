import java.util.ArrayList;
import java.util.List;

class Account 
{
	private int id;         
	private double  accountamount=0; 

	public Account (int id, double accountamount) 
	{		
		this.id = id;	    
		this.accountamount=accountamount;
	}
	
	public int getid() 
	{			
		return this.id;
	}
	
	public double  getaccountamount() 
	{			
		return accountamount;
	}
	
	public void withdraw(double amount) 
	{
		accountamount-=amount;
	}
	
	public void deposit(double amount)
	{
		accountamount+=amount;
	}	
}

public class Bankaccounts 
{
	public List<Account> accounts = new ArrayList<>();
	
	public synchronized void transfer(Account from, Account to, double amount)
	{				
		if (from.getid()==to.getid()) return;
		if (from.getid()<to.getid()) 
		{
			synchronized(from) 
			{												
				synchronized(to) 
				{								
					if (from.getaccountamount()>=amount) 
					{							        	
						from.withdraw(amount);				        	
						to.deposit(amount);								
					}				
				}										
			}
		}
		else 
		{
			synchronized(to) 
			{												
				synchronized(from) 
				{								
					if (from.getaccountamount()>=amount) 
					{							        	
						from.withdraw(amount);				        	
						to.deposit(amount);								
					}				
				}										
			}
		} 
	}
	
	private boolean notaccount(int id)
	{ 
		for (Account acñ : accounts) 
			if (acñ.getid()==id)
				return false;  
		return true;
	}				

	public void createaccount(int id, double accountamount)
	{
		if (notaccount(id)) 
		{
			Account account = new Account(id, accountamount);  
			accounts.add(account);			
		}
	 }
	
	public double qetbalance()
	{ 
		int allmoney=0;
		for (Account acñ : accounts) 
			allmoney+=acñ.getaccountamount();
		return allmoney;  
	}				

}

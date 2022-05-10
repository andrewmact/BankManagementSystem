package accounts;

import java.time.LocalDateTime;

public interface Transactionable {
	
//Inheritable methods\\	
	void withDrawl(int amount, String account);
	void deposite(int amount, String account);
	void transferTo(int amount, String account);
	boolean validTransaction(int amount);
	
//Interface methods\\
	static void logTransaction(int amount, String account, String transaction)
	{
		LocalDateTime activityDate = LocalDateTime.now();
		
	}
	

}

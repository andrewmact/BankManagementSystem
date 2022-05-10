package accounts;

public abstract class BankAccount {

	abstract double getBalance();
	abstract boolean validateTransaction(int amount);
	
}

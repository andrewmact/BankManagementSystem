package accounts;


public class SavingAccount extends BankAccount{
	private int minBalance;
	protected int balance;
	/**
	 * Method sets the minimal balance that needs to be held in the account
	 * @param amount: the amount of money that must be saved in the account
	 */
	void setMinBalance(int amount) {
		minBalance = amount;
	}
	/**
	 * @return the minimal balance required in the savings account
	 */
	int getMinBalance() {
		return minBalance;
	}
	/**
	 * @return the accounts balance
	 */
	@Override
	double getBalance() {
		return balance;
	}
	/**
	 * Method verifies if a transaction on the savings account is appropriate
	 * @param amount: the amount of money attempted to be transacted
	 * @return @return true if the balance  minus the amount deplites or equals the minimal balance limit, false if not
	 */
	@Override
	boolean validateTransaction(int amount) {
		int difference = balance - amount;
		
		if(difference <= minBalance) {
		return false;
		}
		return true;
	}

}

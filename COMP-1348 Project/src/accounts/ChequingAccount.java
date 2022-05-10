package accounts;


public class ChequingAccount extends BankAccount{
	private int overDraft;
	protected int balance;
	/**
	 * Method set the over draft amount for the chequing account
	 * @param amount: the amount of money to not overdraft
	 */
	void setOverDraft(int amount) {
		overDraft = amount;
	}
	/**
	 * Method
	 * @return over draft limit
	 */
	int getOverDraft() {
		return overDraft;
	}
	
	/**
	 * @return the accounts balance
	 */
	@Override
	double getBalance() {
		return balance;
	}
	/**
	 * Method verifies is a transaction does not exceed the overdraft limit
	 * @param amount: the amount of money attempted to be transacted
	 * @return true if the amount exceeds or equals the overdraft limit, false if not
	 */
	@Override
	boolean validateTransaction(int amount) {
		if(amount >= overDraft) {
		return false;
		}
		return true;
	}

}

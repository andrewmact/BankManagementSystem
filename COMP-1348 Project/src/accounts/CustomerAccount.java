package accounts;


public class CustomerAccount extends Customer implements Transactionable{
	
	private SavingAccount savings;
	private ChequingAccount chequing;
	public CreditCard creditCard;
	public Customer profile = new Customer();
	
	public CustomerAccount() {};
	public CustomerAccount(int accountNo, String name, String password){
		super(name, password, accountNo);
		
	}
	/**
	 * Method used to check if a customers account is the customers account requested
	 * @param ac: customer account object
	 * @param id: customer account account number
	 * @param pword: customer accounts password
	 * @return: return true if the account is a match to the requested account
	 */
public boolean checkCustomerAccount(CustomerAccount ac, int id, String pword) {
		if((ac.accountNo == id) && (ac.password.equals(pword))) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * Transactions
	 * 
	 */

	/**
	 * Method withdraws money out of a bank account
	 * @param amount: the amount of money to withdraw
	 * @param account: the bank account to withdrawl money out of
	 */
	@Override
	public void withDrawl(int amount, String account) {
		if(account == "chequing") {
			if(chequing.validateTransaction(amount)) {
				chequing.balance -= amount;
			}
		}
		else if(account == "savings") {
			if(savings.validateTransaction(amount)) {
				savings.balance -= amount;
			}
		}
		
	}
	/**
	 * Method deposties money into a bank account
	 * @param amount: the amount of money to deposite
	 * @param account: the bank account to deposite money into
	 */
	@Override
	public void deposite(int amount, String account) {
		if(account == "chequing") {
			chequing.balance += amount;
		}
		else if(account == "savings") {
				savings.balance += amount;
		}
	}
	/**
	 * Method to transfer money from one bank account into another bank account
	 * @param amount: the amount of money to transfer
	 * @param account: the bank account to transfer the money into
	 */
	@Override
	public void transferTo(int amount, String account) {
		if(account == "chequing") {
			withDrawl(amount, "savings");
			deposite(amount, "chequing");
		}
		else if(account == "savings"){
				withDrawl(amount, "chequing");
				deposite(amount, "savings");
		}
		
	}
	@Override
	public boolean validTransaction(int amount) {
		
		return false;
	}

	/**
	 * 
	 * Credit Card Inner Class
	 *
	 */

	public class CreditCard{
		protected int limit;
		protected int balance;
		/**
		 * Method sets the credit cards limit
		 * @param limit: the max amount of money spendable
		 */
		void setLimit(int limit) {
			this.limit = limit;
		}
		/**
		 * 
		 * @return: credit card limit
		 */
		int getLimit() {
			return limit;
		}
		/**
		 * 
		 * @return: balance owed to the bank
		 */
		int getBalance() {
			return balance;
		}
		/**
		 * Method to spend money on credit card
		 *@param amount: the amount of money to add onto the users credit card balance 
		 */
	public void useCreditCard(int amount) {
		if((balance + amount) > limit) {
			System.out.println("Declined\nOver limit: "+limit);
		} else {
		balance += amount;
		}
	}
	/**
	 * Method to pay off credit card balance from a bank account
	 * @param amount: the amount of money you are using to pay off the credit card balance
	 */
	public void payBalance(int amount) {
		withDrawl(amount, "Chequing");
		balance -= amount;
	}
	
	}
	
	/**
	 * 
	 * Get Bank Accounts
	 * 
	 */
	public ChequingAccount getChequing() {
		return chequing;
	}
	public SavingAccount getSavings() {
		return savings;
	}
	/**
	 * 
	 * Creating Accounts
	 * 
	 */
	/**
	 * Create Savings object and set a minimume balance for the account
	 * @param minBalance
	 */
	public void createSavingsAccount(int minBalance) {
		savings = new SavingAccount();
		savings.setMinBalance(minBalance);
	}
	/**
	 * Create a chequing object and set a overDraft limit on the account
	 * @param overDraft
	 */
	public void createChequingAccount(int overDraft) {
		chequing = new ChequingAccount();
		chequing.setOverDraft(overDraft);
	}
	/**
	 * Create a credit card object and set a spending limit for the card
	 * @param limit
	 */
	public void createCreditCard(int limit) {
		creditCard = new CreditCard();
		creditCard.setLimit(limit);
	}
	/**
	 * List the bank accounts and their balances
	 * List the total balance for all bank accounts
	 */
	public void checkAccounts() {
		int savingsBalance = savings.balance;
		int chequingBalance = chequing.balance;
		int totalBalance = savingsBalance+chequingBalance;
		
		System.out.println("Savings Account Balance: "+savingsBalance);
		System.out.println("Chequing Account Balance: "+chequingBalance);
		System.out.println("Total Balance: "+totalBalance);
		
	}
	
}

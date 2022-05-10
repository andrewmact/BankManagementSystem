package accounts;


public class Customer {
	
	protected String name;
	protected String password;
	protected int accountNo;
	
	Customer(){}
	Customer(String name, String password, int accountNo){
		this.name = name;
		this.password = password;
		this.accountNo = accountNo;
	}
	
	// Setters \\
	/**
	 * Method sets customers name
	 * @param name: name of customer
	 */
	void setName(String name){
		this.name = name;
	}
	/**
	 * Method sets customers password
	 * @param password: password of customers account
	 */
	void setPassword(String password) {
		this.password = password;
	}
	// Getters \\
	/**
	 * Method
	 * @return customers name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Method
	 * @return customers account number
	 */
	public int getAccountNumber() {
		return accountNo;
	}
	/**
	 * Method
	 * @return customers password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method is to change users password
	 * @param: currentPassword: the customers entered password
	 * @param: newPassword: the password the customer would like
	 * @return: true if customers entered password matchs their current password, false if not
	 */
	public boolean changePassword(String currentPassword, String newPassword) {
		if(password == currentPassword) {
			password = newPassword;
			return true;
		}
		return false;
	}
	
}

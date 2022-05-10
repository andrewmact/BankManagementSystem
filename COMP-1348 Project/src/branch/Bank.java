package branch;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import accounts.Customer;
import accounts.CustomerAccount;

public class Bank {
	
	HashMap<Integer, CustomerAccount> accounts = new HashMap<Integer, CustomerAccount>();
	
	static String c = "chequing";
	static String s = "savings";
	
	public static void main(String[] args) {
		
		Bank branch1 = new Bank();
		branch1.createBankAccount(129034, "Andrew MacTavish", "123Pw0rd");
		branch1.createBankAccount(439283, "Dan z", "newPas5");
		branch1.createBankAccount(1212903, "Phileh", "SecertAccount");
		CustomerAccount user = branch1.accessBankAccount(129034, "123Pw0rd");
		System.out.println(user.getName());
		
					
	}
	/**
	 * 
	 * @param id, will change to be created by hashcode
	 * @param customer, the customers name
	 * @param password, the customers password
	 */
	void createBankAccount(int id, String customer, String password) {
		CustomerAccount ac1 = new CustomerAccount(id, customer, password);
		storeBankAccount(ac1);
	}
	/**
	 * Method currently to serialize a customer account into a file
	 * @param ba, the bankaccount that will be stored in a file
	 */
	void storeBankAccount(CustomerAccount customerAccount) {
		Integer accountID = customerAccount.getAccountNumber();
		accounts.put(accountID, customerAccount);
	}
	/**
	 * 
	 * @param accountNo, the customer accounts account number
	 * @param pword, The customer accounts password
	 * @return: returns the customer account requested if their is a match
	 */
 	CustomerAccount accessBankAccount(int accountNo, String pword) {
 		CustomerAccount account;
 		if(accounts.containsKey(accountNo)) {
 			account = findAccount(accountNo);
 			if(account.getPassword() == pword) {
 				return account;
 			}
 		}
 		else {
 			System.out.println("Account Number does not exist");
 		}
 		
 		return null;
	}
 	CustomerAccount findAccount(int number) {
 		for(Integer key: accounts.keySet()) {
			if(key == number) {
				return accounts.get(key);
				}
			System.out.println(key);
 			}
		return null;
 		}
 	
	}



class AccountLog {
	int accountNo;
	String password;

	
	AccountLog(){
		
	}
	String generateAccountNo() {
		Random rnd = new Random();
	    int number = rnd.nextInt(999999);
	    
	    String accountNo = String.format("%07d", number);
		return accountNo;
	}
	boolean checkAccount(int tempNo) {
		
		return false;
	}
	boolean checkBankAccount(CustomerAccount ca, int id, String pword) {
		
		
		return false;
	}
  }

	
	
	
	
	
	
	
	

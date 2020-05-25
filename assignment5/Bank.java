

/*---------------------------------------
 Genuine author: <avi ferdman>, I.D.: <316420132>
 Date: 24-12-2018 
---------------------------------------*/

/**
 * This class represents a bank,
 * it has two data structures to save the bank accounts and supports operations like add an account, delete, deposit, and withdraw.
 *
 * @author <avi ferdman>
 */

public class Bank {

	private BankAccountsBinarySearchTree namesTree;
	private BankAccountsBinarySearchTree accountNumbersTree;
	
	public Bank() {
		namesTree = new BankAccountsBinarySearchTree(new AccountComparatorByName());
		accountNumbersTree = new BankAccountsBinarySearchTree(new AccountComparatorByNumber());
	}
	
	/**
     * This method search for a bank account by it's name
     *
     * @param String as the name of the account
     * @return the BankAccount if exist, otherwise return null
     * 
     */

	public BankAccount lookUp(String name){
		// create an Entry with the given name, a "dummy" accountNumber (1) and zero balance
		// This "dummy" accountNumber will be ignored when executing getData
		BankAccount lookFor = new BankAccount(name, 1, 0);
		return (BankAccount)namesTree.findData(lookFor);
	}
	
	/**
     * This method search for a bank account by it's number
     *
     * @param int as the number of the account
     * @return the BankAccount if exist, otherwise return null
     * 
     */

	public BankAccount lookUp(int accountNumber){
		// create an Entry with a "dummy" name, zero balance and the given accountNumber
		// This "dummy" name will be ignored when executing getData
		BankAccount lookFor = new BankAccount("dummy", accountNumber,0);
		return (BankAccount)accountNumbersTree.findData(lookFor);
	}
	/**
     * This method balance both of the data structures 
     *
     * 
     */

	public void balance(){
		namesTree.balance();
		accountNumbersTree.balance();
	}
	
	public Object exportNames() {
		return this.namesTree;
	}
	public Object exportAccountNumbers() {
		return this.accountNumbersTree;
	}
	
	// END OF Given code -----------------------------------
	/**
     * This method add a bank account to the data structures
     *
     * @param BankAccount in order to add it to the data structures
     * @return true if the bank account was added otherwise return false
     * 
     */

	//Complete the following method
	public boolean add(BankAccount newAccount) {
		//if the account does'nt exists in both of the trees insert it to both of them and return true
		if(!namesTree.contains(newAccount)&!accountNumbersTree.contains(newAccount)){
			namesTree.insert(newAccount);
			accountNumbersTree.insert(newAccount);
			//balance the trees after the changes
			balance();
			return true;
		}
		//else return false
		return false;
	
	}
	/**
     * This method delete a bank account from the data structures
     *
     * @param String as the name of the account in order to delete it from the data structures
     * @return true if the bank account was deleted otherwise return false
     * 
     */


	//Complete the following method
	public boolean delete(String name){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(name);
		// complete this:
		if(toRemove!=null) {
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			//balance the trees after the changes
			balance();
			return true;
		}
		return false;	
	}
	/**
     * This method delete a bank account from the data structures
     *
     * @param int as the number of the account in order to delete it from the data structures
     * @return true if the bank account was deleted otherwise return false
     * 
     */

	
	//Complete the following method
	public boolean delete(int accountNumber){
		// this first line is given in the assignment file
		BankAccount toRemove = lookUp(accountNumber);
		// complete this:
		//if this bank account does exist remove it from both trees and return true
		if(toRemove!=null) {
			namesTree.remove(toRemove);
			accountNumbersTree.remove(toRemove);
			//balance the trees after the changes
			balance();
			return true;
		}
		//else return false
		return false;	
	}
	/**
     * This method deposit money to a specific account
     *
     * @param int as the amount of money to deposit and int as the account number
     * @return true if the operation done successfully otherwise return false
     * 
     */


	//Complete the following method
	public boolean depositMoney(int amount, int accountNumber){
		BankAccount account = lookUp(accountNumber);
		return account.depositMoney(amount);
	}
	/**
     * This method withdraw money from a specific account
     *
     * @param int as the amount of money to withdraw and int as the account number
     * @return true if the operation done successfully otherwise return false
     * 
     */


	//Complete the following method
	public boolean withdrawMoney(int amount, int accountNumber){
		BankAccount account = lookUp(accountNumber);
		return account.withdrawMoney(amount);
	}
	


}

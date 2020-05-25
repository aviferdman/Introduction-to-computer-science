import java.util.Iterator;
import java.util.NoSuchElementException;


public class FilteredBankAccountsIterator implements Iterator<BankAccount> {

    private BankAccountsBinarySearchTree bankAccountsTree;
    private BankAccount current;
	List <BankAccount> bankAccounts;

    //Complete the following method
    public FilteredBankAccountsIterator(BankAccountsBinarySearchTree bankAccountsTree) {
    	this.bankAccountsTree = bankAccountsTree;
    	current = bankAccountsTree.root.data;
    	bankAccounts = new LinkedList();
    	//Initialize an iterator goes over the tree
    	BinaryTreeInOrderIterator <BankAccount> iter = new BinaryTreeInOrderIterator(bankAccountsTree.root);
    	//check if there is bank account with a balance over than 100 
    	while(iter.hasNext()) {
    		current=iter.next();
    		if(current.getBalance()>100) {
    			//if such a bank account exist, add it to the end of the list
    			bankAccounts.add(current);
    		}
    	}
    }
    //Complete the following method
    @Override
    public boolean hasNext() {
    	//check if the list of the bank accounts is empty 
    	return bankAccounts.isEmpty();
    }

    //Complete the following method
    @Override
    public BankAccount next() {
    	//check if the list of the bank accounts is empty 
        if(!hasNext())
        	throw new NoSuchElementException();
        //if the list is not empty remove the first link and return it 
        else {
        	current = bankAccounts.get(0);
        	bankAccounts.remove(0);
        	return current;
        }
    }

    //Do not change this method.
    public void remove() {
        return;
    }
}

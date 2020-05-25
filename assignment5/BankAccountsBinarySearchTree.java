/*---------------------------------------
 Genuine author: <avi ferdman>, I.D.: <316420132>
 Date: 24-12-2018 
---------------------------------------*/
import java.util.Comparator;
import java.util.Iterator;

public class BankAccountsBinarySearchTree extends BinarySearchTree<BankAccount>{

	public BankAccountsBinarySearchTree(Comparator<BankAccount> myComparator) {
		super(myComparator);
	}
	
	//Complete the following method
	public void balance(){
		//create an iterator by order, new list and new  Bank Accounts Binary Search Tree
		BinaryTreeInOrderIterator <BankAccount> iter = new BinaryTreeInOrderIterator(this.root);
		List <BankAccount> list = new LinkedList();
		BankAccountsBinarySearchTree tree = new BankAccountsBinarySearchTree (comparator);
		//measure what is the size of the tree and place the Bank Accounts in the list
		int size = 0;
		while(iter.hasNext()) {
			list.add((iter.next()));
			size = size + 1;
		}
		//send the new tree and all the initial parameters to a recursive function that balance the new tree
		buildBalancedTree(tree,list,0,size-1);
		//copy the new tree to the original tree
		this.root=tree.root;
	}
	
	//Complete the following method
	private void buildBalancedTree(BankAccountsBinarySearchTree tree, List<BankAccount> list, int low, int high){
		//insert the middle value in the list to the tree
		BankAccount root = (list.get((low+high)/2));
		tree.insert(root);
		//cut the tree to half and make the recursive first to the left part then to the right part
		if(high>=low)
			buildBalancedTree(tree,list,low,((high+low)/2)-1);
		if(low<=high)
			buildBalancedTree(tree,list,((high+low)/2)+1,high);
		}
	
	public Iterator<BankAccount> iterator(){
		return new FilteredBankAccountsIterator(this);
	}
	
}

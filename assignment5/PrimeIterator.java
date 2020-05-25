/*---------------------------------------
 Genuine author: <name>, I.D.: <id number>
 Date: xx-xx-2018 
---------------------------------------*/
import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer> {

    private List<Integer> primes;
   
	//Complete the following method
    public PrimeIterator(){
    	//Initialize primes as LinkedList
    	primes = new LinkedList();
    }

	//Complete the following method
    public boolean hasNext(){
        //there is always a prime number
    	return true;
    }

	//Complete the following method
    public Integer next(){
    	//if the LinkedList is empty then the first prime number is 2
    	if(primes.isEmpty())
    		primes.add(2);
    	else {
    		//set the next potential prime number as the biggest prime number found by now, plus 1
    		Integer next = primes.get(0)+1;
    		//set an iterator goes over all the primes found by now
    		Iterator<Integer> iter = primes.iterator();
    		//check if 'next' divides by every prime number in the list
    		while(iter.hasNext()) {
    			if(next%iter.next()==0) {
    				next=next+1;
    				iter = primes.iterator();
    			}		
    		}
    		//when it found a prime number add it to the first place in the list
    		primes.add(0,next);
    	}
    	return primes.get(0);
    }
	
	//DO NOT REMOVE OR CHANGE THIS MEHTOD – IT IS REQUIRED 
	public void remove() {
		return;
	}


}

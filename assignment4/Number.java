import java.util.Iterator;

public class Number implements Comparable<Number> {
    private static final int BASE = 2;
    private static final Number ZERO = new Number();
    private static final Number ONE = new Number(1);
    private List<Bit> list;
	
    /**
     * Constructs a new Number defaulted to the value zero.
     */
    public Number(){
        list = new LinkedList<Bit>();
        list.add(new Bit(false));
    }

    /**
     * Constructs a new Number from an int.
     * @param number an int representing a decimal number
     */
    public Number(int number){  // assignment #1
    	//if its a negative number throw exception
        if(number < 0)
        	throw new IllegalArgumentException();
        list = new LinkedList<Bit>();
        if(number==0)
        	list.add(new Bit(false));
        else {
        	while (number!=0) {
        		//create a new bit and add it to the end of the list
        		list.add(new Bit(number%BASE==1));
        		number=number/BASE;
        	}
        }
    }

    /**
     * Constructs a new Number from a String.
     * @param s a String (possibly) representing a decimal number.
     */
    public Number(String s){    // assignment #2
    	
        this(stringToInt(s));
    }
    
    private static int stringToInt (String s) {
    	//convert string to integer and if its illegal throw exception
    	//if its an empty string or string longer than one char and starts with zero throw exception
        if(s==null||(s.length()==0||(s.charAt(0)==0&s.length()>1)))
        	throw new IllegalArgumentException();
        int pow=1;
        int convertedNumber=0;
        while(s.length()>=1) {
        	//if the char is illegal throw exception
        	if(s.charAt(s.length()-1)>'9'||s.charAt(s.length()-1)<'0')
        		throw new IllegalArgumentException();
        		//add to the number the next char increase the power and remove the last char from the string
        	convertedNumber=convertedNumber+charToInt(s.charAt(s.length()-1))*pow;
        	pow=pow*10;
        	s=s.substring(0,s.length()-1);
        }
        return convertedNumber;
    }
    
    private static int charToInt (char c) {
    	//convert char to integer
    	String s = "0123456789";
    	return s.indexOf(c);
    }

    /**
     * Constructs a new Number which is a deep copy of the provided Number.
     * @param number a Number to be copied
     */
    public Number(Number number){ // assignment #3
    	//if the input is illegal throw exception
        if(!(number instanceof Number))
        	throw new IllegalArgumentException();
        //copy the number's list to the new number list
        list = number.list;
        
    }

    /**
     * Checks if this Number is zero.
     * @return true if and only if this object representing the number zero.
     */
    public boolean isZero(){ // assignment #4
    	//if the input is illegal
    	if(list==null)
    		throw new IllegalArgumentException();
        return (list.get(0)!=null&&(list.get(0).isZero()&list.size()==1));
    }
    /**
     * Returns an iterator over the Bit objects in the representation of this number,
     * which iterates over the Bit objects from LSB (first) to MSB (last).
     * @return a LSB-first iterator over the Bit objects in the representation of this number.
     */
    public Iterator<Bit> bitIterator(){ // assignment #5
        return list.iterator();
    }
    /**
     * Adds 1 to the number
     */
    public void increment(){ // assignment #6
    	//if the input is illegal
    	if(list==null)
    		throw new IllegalArgumentException();
    	//create a new list to represent the new number
    	List<Bit> newList = new LinkedList<Bit>();
    	int carry = 1;
    	for(int i=0;i<list.size();i=i+1) {
    		//if the carry is one change the value of the bit
    		if(carry==1) {
    			if(list.get(i).getValue()) {
    				newList.add(new Bit(false));
    			}
    			if(!list.get(i).getValue()) {
    				newList.add(new Bit(true));
    				carry=0;
    			}
    		}
    		//if the carry is zero do not change the value of the bit
    		else
    			newList.add(new Bit(list.get(i).getValue()));
    	}
    	//if the carry is still one add one more bit with the value of one
    	if(carry==1)
    		newList.add(new Bit(true));
    	//change the old number list to the new number list
    	this.list=newList;
    }
    /**
     * Checks if a provided String represent a legal decimal number.
     * @param s a String that possibly represents a decimal number, whose legality to be checked.
     * @return true if and only if the provided String is a legal decimal number
     */
    public static boolean isLegal(String s){ // assignment #7
    	//if the input is illegal
        boolean isLegal = true;
        if(s==null||(s.length()==0||(s.charAt(0)=='0'&s.length()>1)))
        	return false;
        while(s.length()>0) {
        	if(s.charAt(0)>'9'|s.charAt(0)<'0')
        		isLegal=false;
        	s=s.substring(1);
        }
        return isLegal;
    }


    /**
     * Compares the specified object with this Number for equality.
     * Returns true if and only if the specified object is also a
     * Number (object) which represents the same number.
     * @param obj he object to be compared for equality with this Number
     * @return true if and only if the specified object is equal to this object
     */
    public boolean equals(Object obj){ // assignment #8
    	//if the object isn't instance of Number return false
        if(!(obj instanceof Number))
        	return false;
      //if their lists in different sizes
        if(list.size()!=((Number)obj).list.size())
        	return false;
      //if their lists contains different bits
        for(int i=0;i<list.size();i=i+1) {
        	if(!((Number)obj).list.get(i).equals(list.get(i)))
        		return false;
        }
        return true;
    }


    /**
     * Returns a string representation of this Number
     * as a binary number.
     * @return a string representation of this Number
     */
    public String toString(){ // assignment #9
    	String toString="";
        for(int i=list.size()-1;i>=0;i=i-1)
        	toString=toString+(list.get(i).toInt());
        return toString;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is less than or equal to the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is less than
     * or equal to the second parameter, as numbers.
     */
    public static boolean lessEq(Number num1, Number num2){ // assignment #10
    	//if the input is illegal
    	if(!(num1 instanceof Number & num2 instanceof Number))
    		throw new IllegalArgumentException();
    	//the boolean value initialize to true so if the numbers equals it won't change and return true
    	boolean lessEq=true;
    	Iterator<Bit> iter1 = num1.bitIterator();
    	Iterator<Bit> iter2 = num2.bitIterator();
    	//if num1 is empty then for sure the second number is bigger or equal
    	if(!iter1.hasNext())
    		return true;
    	//if num1 is not empty and the second is empty then for sure the first number is bigger
    	if(!iter2.hasNext())
    		return false;
    	//check from the beginning of the first number
    	while(iter1.hasNext()) {
        	Bit bit1 = iter1.next();
        	Bit bit2 = iter2.next();
        	//decide by the last Bit checked if the second number is bigger
        	if(bit1.lessThan(bit2))
        		lessEq=true;
        	//decide by the last Bit checked if the first number is bigger
        	if(bit2.lessThan(bit1))
        		lessEq=false;
    		//if the list of the first number longer than the second list than the first number is bigger
    		if(iter1.hasNext()&!iter2.hasNext())
    			return false;
    		//if the list of the second number longer than the first list than the second number is bigger
    		if(!iter1.hasNext()&iter2.hasNext())
    			return true;
    	}
    	return lessEq;
    }


    /**
     * Compares the two provided numbers, and returns true if
     * the first parameter is strictly less than the second
     * parameter, as numbers.
     * @param num1 the first number to compare
     * @param num2 the second number to compare
     * @return true if and only if the first number is strictly
     * less than the second parameter, as numbers.
     */
    public static boolean lessThan(Number num1, Number num2){ // assignment #11
    	//return the boolean value when num1 is less than or equal to num2 and they are'nt equals
    	//double && is needed because "lessEq" function would throw an illegal argument exception if at least one of the parameters is'nt instance of Number 
    	return (lessEq(num1,num2))&&!(num1.equals(num2));
    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Number o){ // assignment #12
        boolean lessEq = lessEq(this,o);
        boolean lessThan = lessThan(this,o);
        //if o is bigger than this Number
        if(lessThan)
        	return -1;
      //if o is equal to this Number
        if(lessEq)
        	return 0;
        //if this Number is bigger than o
        else
        	return 1;
    }


    /**
     * Adds the specified Number objects, and returns their sum.
     * @param num1 the first addend
     * @param num2 the second addend
     * @return the sum of the specified Number objects.
     */
    public static Number add(Number num1, Number num2){ // assignment #13
    	//if the input is illegal
    	if(!(num1 instanceof Number & num2 instanceof Number))
    		throw new IllegalArgumentException();
    	//make num1 the bigger number of the two
    	if(num1.compareTo(num2)<0) {
    		Number temp=num1;
    		num1=num2;
    		num2=temp;
    	}
    	Bit bit2,bit1;
    	Number output = new Number ();
    	output.list.remove(new Bit (false));
    	Bit cIn =new Bit (false);
    	Iterator<Bit> iter1 = num1.bitIterator();
    	Iterator<Bit> iter2 = num2.bitIterator();
    	while(iter1.hasNext()) {
    		bit1 = iter1.next();
    		if(iter2.hasNext()) 
    			bit2 = iter2.next();
    		else 
    			bit2 = new Bit (false);
    		//three of them are true
    		if(Bit.fullAdderSum(bit1,bit2,cIn).getValue()&Bit.fullAdderCarry(bit1,bit2,cIn).getValue()) {
    			output.list.add(new Bit (true));
    			cIn = new Bit(true);
    		}
    		//exactly two of them are true
    		else if(!Bit.fullAdderSum(bit1,bit2,cIn).getValue()&Bit.fullAdderCarry(bit1,bit2,cIn).getValue()) {
    					output.list.add(new Bit (false));
    					cIn = new Bit (true);
    		}
    			//exactly one of them is true
    			 else if(Bit.fullAdderSum(bit1,bit2,cIn).getValue()&!Bit.fullAdderCarry(bit1,bit2,cIn).getValue()) {
    				 	output.list.add(new Bit (true));
    	    			cIn = new Bit (false);
    			}
    				//three of them are false
    			 	else if(!Bit.fullAdderSum(bit1,bit2,cIn).getValue()&!Bit.fullAdderCarry(bit1,bit2,cIn).getValue()) {
    			 		output.list.add(new Bit (false));
    	    			cIn = new Bit (false);
    			 	}
    	}
    	if(cIn.getValue())
    		output.list.add(new Bit (true));
    	return output;
    }

    /**
     * Multiply the specified Number objects, and returns their product.
     * @param num1 the first factor
     * @param num2 the second factor
     * @return the product of the specified Number objects.
     */
    public static Number multiply(Number num1, Number num2){ // assignment #14
    	if(!(num1 instanceof Number & num2 instanceof Number))
    		//if the input is illegal
    		throw new IllegalArgumentException();
    	//copy the two Numbers in order not to change the original values
    	Number num3 = new Number (num1);
    	Number num4 = new Number (num2);
    	//Initialize the output
    	Number multiply =new Number(0);
    	multiply.list.remove(new Bit(false));
    	//compare the and make num3 the bigger number of the two
    	if(num3.compareTo(num4)<0) {
    		Number temp = new Number(num3);
    		num3 = new Number (num4);
    		num4 = new Number (temp);
    	}
    	Iterator<Bit> iter2 =  num4.bitIterator();
    	//multiply the last digit of num4 with num3
    	while(iter2.hasNext()) {
    		Number oneBit =new Number(((Bit)iter2.next()).toInt());
    		multiply=add(multiply,multiplyOneBit(num3,oneBit));
    		num3=add(num3,num3);
    	}
    	return multiply;
    }
    private static Number multiplyOneBit(Number num1, Number oneBit) {
    	//multiply Number with a single Bit
    	Number output= new Number (0);
    	if(oneBit.list.get(0).isOne())
    		output=num1;
    	return output;
    }
}

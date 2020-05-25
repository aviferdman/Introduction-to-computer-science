//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Bit {
	private boolean value;

    public Bit(boolean value) {
		this.value=value;
	}

    public String toString() {
		String s;
		if(value)
			s="1";
		else
			s="0";
		return s;
    }

    public boolean isOne() {
    	boolean isOne = true;
    	if(value==false)
    		isOne=false;
    	return isOne;
    }

    public boolean lessThan(Bit digit) {
    	//the only case for true is when digit is 1 and Bit is 0
    	boolean lessThan=false;
		if(value==false&digit.isOne())
			lessThan=true;
		return lessThan;
	}

    public boolean lessEq(Bit digit) {
		boolean lessEq=true;
		//the only case for false is when digit is 0 and Bit is 1
		if(!digit.isOne()&value)
			lessEq=false; 
		return lessEq;
	}

   public static Bit fullAdderSum(Bit A, Bit B, Bit Cin) {
	   boolean sum = false;
	   //cases for true:
	   //three of them is true
	   if(A.isOne()&B.isOne()&Cin.isOne())
		   sum = true;
	 //exactly one of them is true
	   if(A.isOne()&!B.isOne()&!Cin.isOne())
		   sum = true;
	   if(!A.isOne()&B.isOne()&!Cin.isOne())
		   sum = true;
	   if(!A.isOne()&!B.isOne()&Cin.isOne())
		   sum =true;
	   Bit output = new Bit(sum);
	   return output;
   }
   public static Bit fullAdderCarry(Bit A, Bit B, Bit Cin) {
	   boolean sum = false; 
	   //cases for true:
	   //three of them is true
	   if(A.isOne()&B.isOne()&Cin.isOne())
		   sum = true;
	 //exactly two of them is true
	   if(A.isOne()&B.isOne()&!Cin.isOne())
		   sum = true;
	   if(!A.isOne()&B.isOne()&Cin.isOne())
		   sum = true;
	   if(A.isOne()&!B.isOne()&Cin.isOne())
		   sum =true;
	   Bit output = new Bit(sum);
	   return output;
   }
	
}

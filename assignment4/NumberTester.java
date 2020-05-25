import java.util.Iterator;

public class NumberTester
{
    public static void main(String[] args)
    {
        System.out.println("testNumber() = " + testNumber());
        System.out.println("testIsZero() = " + testIsZero());
        System.out.println("testBitIterator() = " + testBitIterator());
        System.out.println("testIncrement() = " + testIncrement());
        System.out.println("testIsLegal() = " + testIsLegal());
        System.out.println("testEquals() = " + testEquals());
        System.out.println("testToString() = " + testToString());
        System.out.println("testLessEq() = " + testLessEq());
        System.out.println("testLessThan() = " + testLessThan());
        System.out.println("testCompareTo() = " + testCompareTo());
        System.out.println("testAdd() = " + testAdd());
        System.out.println("testMultiply() = " + testMultiply());
    }


    public static boolean testNumber(){
        boolean testNumber = false;
        Number num1 = new Number (Integer.MAX_VALUE);
        Number num2 = new Number ("1024");
        Number num3 = new Number (num1);
        Number num4 = new Number();
        Number num5 = new Number ("0");
        testNumber = num1.equals(num3);//Integer.MAX_VALUE=Integer.MAX_VALUE
        testNumber = testNumber & num2.toString().equals("10000000000"); //1024 = 10000000000 in binary presentation
        testNumber = testNumber & num4.toString().equals(num5.toString());//0=0
        testNumber = testNumber & !num1.toString().equals(num5.toString());//!Integer.MAX_VALUE=0
        return testNumber;
    }


    public static boolean testIsZero(){
    	boolean isZero = false;
        Number num1 = new Number (Integer.MAX_VALUE);
        Number num2 = new Number ("0");
        Number num3 = new Number (0);
        Number num4 = new Number ("900");
        isZero = !num1.isZero()
        		&num2.isZero()
        		&num3.isZero()
        		&!num4.isZero();//num1!=0 , num2=0 , num3=0 , num4!=0 
        return isZero;
    }

    public static boolean testBitIterator(){
    	boolean testIterator=false;
    	String s="";
    	Number num1 = new Number ("16"); //check if the iterator goes over every link in the bits list of the number 16
    	Iterator<Bit> iter1 = num1.bitIterator();
    	while(iter1.hasNext()) {
    		s =iter1.next().toString()+s;
    	}
    	testIterator=s.equals(num1.toString());
    	s="";
    	num1 = new Number (Integer.MAX_VALUE); //check if the iterator goes over every link in the bits list of biggest integer number
    	iter1 = num1.bitIterator();
    	while(iter1.hasNext()) {
    		s =iter1.next().toString()+s;
    	}
    	testIterator=testIterator&s.equals(num1.toString());
    	s="";
    	num1 = new Number (0); //check if the iterator goes over every link in the bits list of the number 0
    	iter1 = num1.bitIterator();
    	while(iter1.hasNext()) {
    		s =iter1.next().toString()+s;
    	}
    	testIterator=testIterator&s.equals(num1.toString());
    	s="";
    	num1 = new Number (123456789); //check if the iterator goes over every link in the bits list of the number 123456789
    	iter1 = num1.bitIterator();
    	while(iter1.hasNext()) {
    		s =iter1.next().toString()+s;
    	}
    	testIterator=testIterator&s.equals(num1.toString());
    	
    	
    	return testIterator;	
    }


    public static boolean testIncrement(){
    	 boolean testIncrement = false;
         Number num1 = new Number (Integer.MAX_VALUE);
         Number num2 = new Number (Integer.MAX_VALUE-1);
         num2.increment();//increase num2 by 2
         num2.increment();
         num1.increment();//increase num2 by 1
         Number num3 = new Number (717);
         num3.increment();//increase num3 by 1
         Number num4 = new Number (5);
         Number num5 = new Number (6);
         num4.increment();//increase num4 by 1
         testIncrement = num1.equals(num2)
        		 	     &num3.toString().equals("1011001110")// 718 = 1011001110 in binary presentation
        		 	     &num4.equals(num5); 
         return testIncrement;
    }


    public static boolean testIsLegal(){
    	 boolean isLegal=false;
    	 String s = "!$#@#%@";//illegal string
    	 isLegal = !Number.isLegal(s);
    	 s="093176";//illegal string (because the first char is '0')
    	 isLegal = isLegal & !Number.isLegal(s);
    	 s="213876128";//legal string
    	 isLegal = isLegal & Number.isLegal(s);
    	 s="";//illegal string
    	 isLegal = isLegal & !Number.isLegal(s);
    	 s=null;//illegal string
    	 isLegal = isLegal & !Number.isLegal(s);
         return isLegal;
    }


    public static boolean testEquals(){
    	boolean equals=false;
    	Number num1 = new Number (Integer.MAX_VALUE);
        Number num2 = new Number (num1);
        equals = num1.equals(num2);//equals
        num1 = new Number ("1024");
        num2 = new Number (1024);
        equals = equals & num1.equals(num2);//equals
        num1 = new Number ("202442739");
        num2 = new Number (102442739);
        equals = equals & !num1.equals(num2);//not equals
        num1 = new Number ();
        num2 = new Number ("0");
        equals = equals & num1.equals(num2);//equals
        return equals;
    }

    public static boolean testToString(){
        boolean toStringTest=false;
        Number num1 = new Number (Integer.MAX_VALUE);
        num1.increment();//increase num1 by 1
        Number num2 = new Number ("100");
        Number num3 = new Number (0);
        toStringTest = num1.toString().equals("10000000000000000000000000000000");//2^32 (the biggest integer number+1)
        toStringTest =  toStringTest & num2.toString().equals("1100100");//100 in binary presentation is 1100100
        toStringTest =  toStringTest & num3.toString().equals("0"); //0 in binary presentation is 0
        return toStringTest;
        
    }


    public static boolean testLessEq(){
    	boolean lessEq=false;
        Number num1 = new Number (Integer.MAX_VALUE);
        num1.increment();
        Number num2 = new Number (Integer.MAX_VALUE);
        Number num3 = new Number (0);
        Number num4 = new Number (5);
        Number num5 = new Number (6);
        Number num6 = new Number (100);
        lessEq = !Number.lessEq(num1, num2) ;//false
        lessEq = lessEq& Number.lessEq(num2, num1) ;//true
        lessEq = lessEq & !Number.lessEq(num2, num3);//false
        lessEq =  lessEq & Number.lessEq(num3, num2);//true
        lessEq =  lessEq & Number.lessEq(num2, num2);//true
        lessEq =  lessEq & !Number.lessEq(num5, num4);//false
        lessEq =  lessEq & Number.lessEq(num4, num5);//true
        lessEq =  lessEq & !Number.lessEq(num6, num5);//false
        lessEq =  lessEq & Number.lessEq(num5, num6);//true
        return lessEq;
    }


    public static boolean testLessThan(){
    	boolean lessThan=false;
        Number num1 = new Number (Integer.MAX_VALUE);
        num1.increment();
        Number num2 = new Number (Integer.MAX_VALUE);
        Number num3 = new Number (0);
        Number num4 = new Number(7);
        Number num5 = new Number(8);
        lessThan = !Number.lessThan(num1, num2) ;//false
        lessThan =  lessThan & !Number.lessThan(num1, num1);//false
        lessThan =  lessThan & !Number.lessThan(num3, num3);//false
        lessThan = lessThan& Number.lessThan(num2, num1) ;//true
        lessThan = lessThan & !Number.lessThan(num2, num3);//false
        lessThan =  lessThan & Number.lessThan(num3, num2);//true
        lessThan =  lessThan & !Number.lessThan(num2, num2);//false
        lessThan =  lessThan & !Number.lessThan(num5, num4);//false
        lessThan = lessThan& Number.lessThan(num4, num5) ;//true
        return lessThan;
    }


    public static boolean testCompareTo(){
    	boolean compare=false;
        Number num1 = new Number (Integer.MAX_VALUE);
        num1.increment();
        Number num2 = new Number (Integer.MAX_VALUE);
        Number num3 = new Number (0);
        Number num4 = new Number ("10");
        compare = num1.compareTo(num2)>0;//num1 bigger than num2
        compare = compare & num1.compareTo(num1)==0;//num1 equals to num1
        compare = compare & num3.compareTo(num2)<0;//num2 bigger than num3
        compare = compare & num4.compareTo(num3)>0;//num4 bigger than num3
        compare = compare & num3.compareTo(num4)<0;//num4 bigger than num3
        compare = compare & num3.compareTo(num3)==0;//num3 equals to num3
        return compare;
    }


    public static boolean testAdd(){
    	boolean add=false;
        Number num1 = new Number (21);
        Number num2 = new Number (5);
        Number num3 = new Number (0);
        Number num4 = new Number ("10");
        Number num5 = new Number (Integer.MAX_VALUE);
        add=Number.add(num2, num2).equals(num4);//5+5=10
        add = add & !Number.add(num4, num4).equals(num1);//10+10!=21
        add = add & Number.add(num3, num4).equals(num4);//10+0=10
        add = add & Number.add(num3, num3).equals(num3);//0+0=0
        add = add & !Number.add(num3, num3).equals(num4);//0+0!=10
        add = add & Number.add(num5, num3).equals(num5);//Integer.MAX_VALUE+0=Integer.MAX_VALUE
        add = add & !Number.add(num5, num2).equals(num5);//Integer.MAX_VALUE+5!=Integer.MAX_VALUE
        return add;
    }

    public static boolean testMultiply(){
    	boolean multiply=false;
        multiply=Number.multiply(new Number(0), new Number(21)).equals(new Number(0));//0*21=0
        multiply = multiply & !Number.multiply(new Number(10), new Number(10)).equals(new Number(20));//10*10!=20
        multiply = multiply & Number.multiply(new Number(10), new Number(2)).equals(new Number(20));//10*2=20
        multiply = multiply & Number.multiply(new Number(Integer.MAX_VALUE), new Number(0)).equals(new Number(0));//n*0=0
        multiply = multiply & Number.multiply(new Number(Integer.MAX_VALUE), new Number(2)).equals(Number.add(new Number(Integer.MAX_VALUE),new Number(Integer.MAX_VALUE)));//n*2=n+n
        multiply = multiply & Number.multiply(new Number(0), new Number(0)).equals(new Number(0));//0*0=0
        multiply = multiply & !Number.multiply(new Number(0), new Number(0)).equals(new Number(22));//0*0!=22
        multiply = multiply & Number.multiply(new Number(22), new Number(15)).equals(new Number(330));//22*15=330
        multiply = multiply & !Number.multiply(new Number(22), new Number(15)).equals(new Number(331));//22*15!=331
        
        return multiply;
    }
}

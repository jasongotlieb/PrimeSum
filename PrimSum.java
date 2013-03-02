/*
 * A simple class that calculates the sum of 
 * all the prime numbers between 1 and a 
 * given integer, N (inclusive)
 */
import java.lang.Math;

public class PrimeSum {

  public static void main(String args[]){
		try{
			int i, n, z; //y, z;
			long y; //the number can get pretty big now!
			n = Integer.parseInt(args[0]);//turns the string passed into an int
			if(n<2) { //anything below 2 is not prime.
				System.out.println("0"); 
			}
			else if(n==2)
			{ //2 is smallest prime
				System.out.println("2");
			}
			else { //otherwise we know the answer contains at least 2 primes
				y = 5; //this number will count up the sum starting with 2+3=5
				for(i=n;i>2;i--){//tests all numbers 2 - N
					z=0;
					if((i%3!=0) && (i%2!=0)){//we don't want to keep testing multiples of 3 or 2
						z = primeTest(i);
						y+=z;
					}
				}//end for loop
				System.out.println(y);//y is at least 5 (2+3)
			}//end else
		}//end try
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	/*
	 * this class tests a given number to see if it is prime
	 * it does this by first finding the square of that number
	 * it also makes sure the number is not a perfect square
	 * ideally, the numbers being passed to this function 
	 * are already decent candidates because they are
	 * odd numbers that aren't divisible by 2 or 3
	 */
	public static int primeTest(int x) 
	{
		int y = x; //25
		double xx; //-
		xx = Math.sqrt(x); //5.0
		if(x%xx!=0){ 
			x = (int)xx; //25
			int count;//this is the number that will be used to divide x to test for prime
			for(count = 2;count<=x;count++) //enters for loop where count is incremented 
			{
				if((y%count) == 0) {//divide by all possible numbers
					return 0; 		//if one goes, we know it's not prime
				}
				//else return y;
			}
			//System.out.println("prime: "+y); //a flag to show the primes found (not including 2 & 3)
			return y; //1 == prime, 0 == !prime
		}
		return 0;
	}
}

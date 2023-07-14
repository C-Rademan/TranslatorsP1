//still need to work out what to do with the number of iterations
import library.*;
public class infamoussieve{
	public static void identifyPrimes(int n, int it){
		int countPrimes = 0;
		//make a set of numbers 2-n (potential primes)
		IntSet uncrossed = new IntSet();
		uncrossed.fill(n+1); //initially have all numbers up to n in the set
		uncrossed.excl(0);
		uncrossed.excl(1);
		int multis; //var for multiples of the prime
		for (int i=2; i<=n;i++){
			//check if the number is in the set 
			if (uncrossed.contains(i)){
				//-- if yes, you've found a prime
				//increment count
				countPrimes++;
				//remove all multiples of that number
				multis=i+i;
				while(multis<=n){
					uncrossed.excl(multis);
					multis=multis+i;
				}//while
			}//if
			else{
				continue;//if it is not in the set, it is not a prime, so continue
			}
		}//for
		uncrossed.write();	
		IO.writeLine("Number of primes found: ");
		int numPrimes = uncrossed.members();
		IO.writeLine(numPrimes);	
	}//makeSet
	
	public static void main (String [] args){
		//display instructions and get inputs from user
		IO.writeLine("Enter the number of iterations:");
		int it = IO.readInt();
		IO.writeLine("Enter the maximum number to check:");
		int n = IO.readInt();
		identifyPrimes(n,it);
	
		
	}//main
	
}//infamoussieve
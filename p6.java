package ICPC;
import java.util.*;


public class p6 {

	
	static boolean[] primes= new boolean[6];
	
	public static void sleve(){
		
		// primes[k] is true is k is prime
		
		for(int k=0;k<primes.length; k++){
			
			primes[k]=true;
		}
		
		for(int k=2; k<primes.length; k++){
			if(primes[k]){
				for(int m=2 *k; m<primes.length;m++){
					primes[m]=false;
				}
				
			}
			
		}
		printPrimes();
	}
	
	
	
	private static void printPrimes() {
		for(int i=0;i<primes.length;i++)
			if(primes[i]) System.out.println(i+" ");
		
		
	}



	static Scanner in = new Scanner(System.in);
	
	
	public static void main(String[] args){
		p6 p= new p6();
		p6.solve();
		int test=9;
		sleve();
		
		
		
		
		
	}


	private static void solve() {
		int n; String s; 
		n=in.nextInt(); 
		for(int k=0; k<n;k++){
			
		}
		
		// TODO Auto-generated method stub
		
	}
}

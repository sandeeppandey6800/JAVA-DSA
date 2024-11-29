//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		
System.out.println("~");
}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        
        long[] fib = new long[n]; // Array to store the first n Fibonacci numbers.

        
        long a = 1;
        long b = 1; 

        
        if (n >= 1) 
        fib[0] = a; //  First Fibonacci number.

       
        if (n >= 2) 
        fib[1] = b;  //  Second Fibonacci number.
        
        for(int i = 2; i < n; i++){
            long c = a+b;
            
            fib[i] = c;    // Store the current Fibonacci number.
            a = b;
            b = c;
        }
        return fib;
        
    }
}
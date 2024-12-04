//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.kokoEat(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kokoEat(int[] arr, int k) {
        
        // code here
 
        //1. Find the max from the array , so that we 
        // can apply binary search
        int i = 1 , j = maxArr( arr ) ;
        int ans = 0 ;
 
        //2. Lets apply binary search 
        while( i <= j ){
 
            int mid = (i+j)/2 ;
 
            int total_hr = fun( arr , k , mid ) ;
 
 
            //a) Mid banana/hr is a valid answer then 
            // search in the left part to decrease the 
            // value of banana/hr
            if( total_hr <= k ){
                ans = mid ;
                j = mid-1 ;
            }
 
            //b) Mid banana/hr is not a valid answer
            // so increase the speed of b/hr by moving 
            // to the right partition
            else{
                i = mid+1 ;
            }
 
        }
 
        // answer found 
        return ans ;
 
    }
    public static int maxArr( int arr[] ){
        int mx = -1 ;
        for( int i = 0 ; i < arr.length ; i++ ){
            if( arr[i] > mx )
                mx = arr[i] ;
        }
 
        return mx ;
    }
    public static int fun( int arr[] , int k , int s ){
 
        int total_hr = 0 ;
 
        for( int i = 0 ; i < arr.length ; i++ ){
            total_hr += (int)Math.ceil( (double)arr[i] / (double)s ) ;
        }
 
        return total_hr ;
 
    }
}
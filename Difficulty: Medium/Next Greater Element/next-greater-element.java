//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().nextLargerElement(arr);

            // Printing the result in the required format
            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int i = 0; i < result.size(); i++) {
                    if (i != 0) System.out.print(" ");
                    System.out.print(result.get(i));
                }
                System.out.println();
                System.out.println("~");
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        int ans[] = new int[n];
        
        Stack<Integer>stack = new Stack<Integer>();
        
        for(int i =0; i<n; i++){
            int curr = arr[i];
            // for which elements curr can be their NG
            while( !stack.isEmpty() && arr[stack.peek()]<curr){
                ans[stack.peek()] = curr;
                stack.pop();
            }
            stack.push(i);
        }
        while( !stack.isEmpty()){
            ans[stack.peek()] = -1;
            stack.pop();
        }
        
        ArrayList<Integer> temp = new ArrayList<Integer>() ;
        for( int i = 0 ; i < n ; i++ )
            temp.add( ans[i] ) ;
        
        return temp;
    }
}
//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Reading total number of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // reading the string
            String st = sc.next();

            // calling ispar method of Paranthesis class
            // and printing "balanced" if it returns true
            // else printing "not balanced"
            if (new Solution().isParenthesisBalanced(st) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        // code here
        
        // push --> opening
        // pop --> closing
        
        // 1. craete a stack 
        
        Stack<Character>stack = new Stack<Character>();
        
        // 2. now iterate over the given string 
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            // check if the current backet is open 
            if( ch == '[' || ch == '{' || ch == '(')
            stack.push(ch);
            else{
                if(stack.isEmpty())
                return false;
                char open = stack.pop();
                
                if(open == '{' && ch == '}'){
                    continue;
                }else if( open == '(' && ch == ')'){
                    continue;
                }else if( open == '[' && ch == ']'){
                    continue;
                }
                else
                return false;
            }
        }
        return stack.isEmpty();
    }
}

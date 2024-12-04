class Solution {
    public int singleNumber(int[] nums) {
 
        int ans = 0 ;
 
        // Count the number of set bits on every bit position [0,31]
        for( int k = 0 ; k < 32 ; k++ ){
 
            // Total set bits at kth position
            int total = 0 ;
            for( int i = 0 ; i < nums.length ; i++ ){
                // Check if kth bit is set in the number or not 
 
                    if( ( nums[i]&(1<<k) ) != 0 ){
                        // kth bit is set 
                        total++ ; 
                    }
 
            }
 
            // Check if count of set bits is multiple of 3 or not
            if( (total%3) != 0 )
                // kth bit is set in the answer 
                ans = ans | (1<<k) ;
 
 
        }
 
        // return the answer 
        return ans ;
 
    }
}
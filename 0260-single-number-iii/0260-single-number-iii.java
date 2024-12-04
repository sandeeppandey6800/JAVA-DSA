class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor = 0 , n = nums.length ;
        
        //1. Find the xor of all the elements 
        for( int i = 0 ; i < n ; i++ ){
            xor = nums[i] ^ xor ;
        }
        
        // position variable 
        int k = 0 ;
        
        //2. Find at least one position which is set in xor 
        for( k = 0 ; k < 32 ; k++ ){
            if( (xor & (1<<k)) !=0 ){
                break ;
            }
        }
        
        int groupA = 0 ;
        int groupB = 0 ;
        
        //3. Now as kth bit is set in xor, 
        // Group A : contains elements whose kth bit is set 
        // Group B : contains elements whose kth bit is unset 
        for( int i = 0 ; i < n ; i++ ){
            
            // Is it in group A ? 
            if( ( nums[i]&(1<<k) ) != 0 ){
                groupA = groupA ^ nums[i] ;
            }
            
            // It is in group B 
            else{
                groupB = groupB ^ nums[i] ;
            }
            
            
        }
        
        int ans[] = {groupA , groupB} ;
        // return the answer 
        return ans ;
        
    }
}
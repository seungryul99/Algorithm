class Solution {
    
    static boolean check(int num){
        
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i=2; i*i <= num; i++){
            if(num % i == 0) return false;
        }
        
        return true;
    }
    
    public int solution(int[] nums) {
        
        // nC3 조합 + 에라토스테네스의 체
        int res = 0;
        int len = nums.length;
        
        for (int i=0; i<len; i++){
            
            for (int j=i+1; j<len; j++){
                
                for (int k=j+1; k<len; k++){
                    
                    if(check(nums[i] + nums[j] + nums[k])) res ++;
                }
                
            }
        }
        
        
        return res;
    }
}
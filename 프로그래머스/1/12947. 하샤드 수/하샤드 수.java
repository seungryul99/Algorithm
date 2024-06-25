class Solution {
    public boolean solution(int x) {
        
        int sum=0;
        int n = x;
        
        // 각 자릿수의 합을 구함
        while(n>0){
            
            sum += n%10;
            n /= 10;
        }
        
        if(x % sum ==0) return true;
        else return false;
        
    }
}
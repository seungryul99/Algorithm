class Solution {
    public int[] solution(int n, int m) {
        
      
        // 재귀로 푸는 법이 기억이 안남
        // 최대범위가 1천만 이라 반복문으로 풀어도 문제는 없을 듯
        
        int g, l;
        int min = (n<m) ? n:m;
        
      
        while(true){
            
            if(n % min == 0 && m % min ==0) {
                g = min;
                break;            
            }
            
            min--;
        }
        
        l = (n/g) * (m/g) * g;
        
        
        return new int[]{g,l};
    }
}
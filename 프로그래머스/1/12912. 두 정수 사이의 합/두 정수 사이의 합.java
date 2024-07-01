class Solution {
    public long solution(int a, int b) {
        
        // 최악의 경우, 2000만 번의 연산이 일어남.  N =2000만 => 0.2초
        // 그냥 전수 탐색으로 풀어도 문제 없을 거 같음.
        // 누적합 사용시 long 2000만개 필요, 메모리 터지지 않을까? 싶은데
        
        long sum = 0;
        
        if (a > b){
            
            for(int i=b;i<=a;i++) sum += i;
        }
        else {
            
            for (int i=a;i<=b;i++) sum += i;
        }
        
        return sum;
        
    }
}
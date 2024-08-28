import java.util.*;

class Solution {
    public int solution(int n) {
        
        // 시간 복잡도 : n이 1억이어도 3씩 나누면서 내려가서 Log 가 될거 같아 고려 X
        // 공간 복잡도 : 마찬가지로 큐에 그렇게 많은 요소가 들어가지 않음
        
        
        // [n을 3진법으로 바꿈 && 3진법으로 바꾼 n을 뒤집음 && 이를 다시 10진법으로 바꿈]
        // 3으로 나눠가면서 나머지를 큐에 담아줌
       
        Queue<Integer> q = new LinkedList<>();
        
        while(true){
            
            if(n<3){
                q.add(n);
                break;
            }
            
            q.add(n%3);
            n/=3;
            
           
        }
        
        
        // FIFO로 뽑으면 뒤집기 끝 
        // 큐의 사이즈를 k 라고 했을 때, 맨 앞부터 3^(k-1)을 곱해준 후 이를 모두 더함

        int answer = 0;
        
        while(!q.isEmpty()){
         
            answer += Math.pow(3,q.size()-1) * q.poll(); 
        }
        
         
        return answer;
    }
}
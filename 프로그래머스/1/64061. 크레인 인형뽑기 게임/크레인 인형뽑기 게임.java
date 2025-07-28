import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
            
        Deque<Integer> stk = new ArrayDeque<>();
        int depth = board.length;
        int res = 0;
        
        for (int cur : moves){
            
            cur--;
            
            for (int i=0; i<depth; i++){
                
                if(board[i][cur] != 0){
                    
                    int item = board[i][cur];
                    
                    if(stk.isEmpty()) stk.push(item);
                    else{
                      if (stk.peek() == item) {
                        
                            stk.pop();
                            res++;
                      }
                      else stk.push(item);
                    } 
                  
                        
                    board[i][cur] = 0;
                    break;
                }
            }    
        }
        
        return res*2;
    }  
}
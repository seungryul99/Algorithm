import java.util.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        
        Stack<Integer> stk = new Stack<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i=0; i< arr.length; i++){
            
            if (stk.isEmpty()) stk.push(arr[i]);
            else{
                
                if (stk.peek() == arr[i]) continue;
                else {
                    res.add(stk.pop());
                    stk.push(arr[i]);   
                }
            }
            
        }
        
        res.add(stk.pop());
        
        return res;
    }
}
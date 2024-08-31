import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            if(stk.isEmpty()){
                
                if(s.charAt(i)==')') return false;
                
                stk.push(s.charAt(i));
            }
            
            else{
                
                if(stk.peek() == '(' && s.charAt(i) == ')') stk.pop();
                else{
                    stk.push(s.charAt(i));
                }
            }
        }
        
        
        if(stk.isEmpty()) return true;
        else return false;
    }
}
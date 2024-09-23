import java.util.*;


class Solution
{
    public int solution(String s)
    {
        
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<s.length();i++){
            
            // 스택에 아무것도 없으면 그냥 넣어버림
            if (stk.isEmpty()) stk.push(s.charAt(i));
            
            else {
                
                if (stk.peek() == s.charAt(i)) stk.pop();
                
                else stk.push(s.charAt(i));
            }
            
        }
        
        if (stk.isEmpty()) return 1;
        else return 0;
    
    }
}
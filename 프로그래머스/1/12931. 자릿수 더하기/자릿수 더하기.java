import java.util.*;

public class Solution {
    public int solution(int n) {
        
        // N의 범위가 작아서 시간 복잡도는 고려하지 않는다.
        // N을 문자열로 바꾼후 각 element들을 더함
        // Integer.toString은 O(log N)
        // 입력에 숫자만 오기 때문에 예외 처리는 없음
    
        
        String s = Integer.toString(n);
        
        int res = 0;
        
        
        // 아스키 코드상 문자 '0'은 48
        for (int i=0;i<s.length();i++) res += (int)s.charAt(i) -48;
        
        return res;
    }
}
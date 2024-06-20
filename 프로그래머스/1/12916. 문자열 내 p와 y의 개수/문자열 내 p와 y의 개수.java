class Solution {
    boolean solution(String s) {
        
        // 문자열의 길이가 50 밖에 안됨
        // 따라서 문자열 전수 탐색하면서 문자열 내 p와 y의 개수를 세자
        
        // 대소문자 구분 없다 해서 String 클래스의 toLowerCase()사용
        // toLowerCase()는 문자열을 전수 탐색 하며 소문자로 변환해서 O(N)
        s = s.toLowerCase();
        
        int p_cnt=0;
        int y_cnt=0;
        
        for(int i=0;i<s.length();i++){
            
            // 문자 하나라서 equals 안씀
            if(s.charAt(i)=='p') p_cnt++;
            else if(s.charAt(i)=='y') y_cnt++;
        }
        
        if(p_cnt == y_cnt) return true;
        else return false;
    }
}
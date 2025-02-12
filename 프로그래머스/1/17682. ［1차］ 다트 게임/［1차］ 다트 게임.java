class Solution {
    public int solution(String dartResult) {
        
        int len = dartResult.length();
        int[] score = new int[3];
        
     
        int idx=0;
        for (int i=0; i<len; i++){
            
            char c = dartResult.charAt(i);
            
            if(c >= '0' && c <= '9'){
                
                if (c=='0') continue;
                else if (c=='1') {
                    score[idx] = 1;
                    if (dartResult.charAt(i+1) == '0') score[idx] *= 10;
                }
                else score[idx] = (int) c - 48;
            }
            
            else if(c == 'S') {
                if(i<len-1 && dartResult.charAt(i+1) != '*' && dartResult.charAt(i+1) != '#') idx++;   
            }
            else if(c == 'D') {
                score[idx] *= score[idx];
                if(i<len-1 && dartResult.charAt(i+1) != '*' && dartResult.charAt(i+1) != '#') idx++;   
            }
            else if(c == 'T') {
                score[idx] *= score[idx] * score[idx];
                if(i<len-1 && dartResult.charAt(i+1) != '*' && dartResult.charAt(i+1) != '#') idx++;   
            }
            else if(c == '*') {
                
                if (idx == 0) score[idx] *= 2;
                else {
                    score[idx] *= 2;
                    score[idx-1] *= 2;
                }
                idx++;
            }
            else if(c == '#') score[idx++] *= -1;
        }
        
        return score[0] + score[1] + score[2];
    }
}
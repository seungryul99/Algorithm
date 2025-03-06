import java.util.*;

class Solution {
    public String solution(int[] in) {
        
        int len = in.length;
        
        String[] numbers = new String[len];
        
        for(int i=0; i<len; i++) numbers[i] = in[i] + "";
        
        Arrays.sort(numbers, new CustomComparator());
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : numbers) sb.append(s);
        
        String res = sb.toString();
        if(res.charAt(0)=='0') return "0";
        
        return res;
    }
    
    static class CustomComparator implements Comparator<String>{
        
        @Override
        public int compare(String s1, String s2){
         
            return -1*(s1+s2).compareTo(s2+s1);
        }
    }
}
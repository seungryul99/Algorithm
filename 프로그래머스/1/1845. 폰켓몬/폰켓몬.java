import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        int res = 0;
        int selectNum = nums.length/2;
        Set<Integer> st = new HashSet<>();
       
        for (int e : nums) st.add(e);
        
        return (st.size() >= selectNum) ? selectNum : st.size();
    }
}
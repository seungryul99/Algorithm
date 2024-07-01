import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
       
        // arr 의 최대 size가 주어지지 않음, 가변길이의 배열을 사용 후 int 로 변환하는듯
        List <Integer> res = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i] % divisor == 0) res.add(Integer.valueOf(arr[i]));
        }
        
        if(res.size()==0) return new int[]{-1};
        
        Collections.sort(res);
        
        int [] sol = new int [res.size()];
        
        for(int i=0;i<res.size();i++) sol[i] = res.get(i);
        
        return sol;
    }
}
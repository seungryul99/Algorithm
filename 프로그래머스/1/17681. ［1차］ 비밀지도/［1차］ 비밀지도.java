class Solution {
    public StringBuilder[] solution(int n, int[] arr1, int[] arr2) {
        
        StringBuilder[] res = new StringBuilder[n];
        
        // arr1 처리
        for(int i=0; i<n; i++){
            
            StringBuilder sb = new StringBuilder();
            
            // 10 -> 2
            String byNum = Integer.toBinaryString(arr1[i]);
            
            for(int j=0; n-byNum.length()>j; j++){
                sb.append(" ");
            }
            
            for(int j=0; j<byNum.length(); j++){
                
                if(byNum.charAt(j) == '1') sb.append("#");
                else sb.append(" ");
            }
            
            res[i] = sb;
        }
        
        // arr2 처리
        for(int i=0; i<n; i++){
            
            String byNum = Integer.toBinaryString(arr2[i]);
            int idx = n-byNum.length();
            
            for(int j=0; j<byNum.length(); j++){
                
                if(byNum.charAt(j)=='1' && res[i].charAt(idx)==' ') {
                    res[i].replace(idx, idx +1, "#");
                }
                idx++;
            }
        }
        
        
        return res;   
    }
}
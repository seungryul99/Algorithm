class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] bit = new String[n];
        for (int i=0; i<n; i++) bit[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        
        // for(String s : bit) {
        //     s = s.replace("0", " ");
        //     s = s.replace("1", "#");
        // }
        
        for (int i=0; i<n; i++){
            
            bit[i] = bit[i].replace("0", " ").replace("1", "#");
            bit[i] = prefix(n, bit[i]);
        }
        
        return bit;
    }
    
    public String prefix(int n, String s){
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<n - s.length(); i++) sb.append(" ");
        
        return sb.toString() + s;
    }
}
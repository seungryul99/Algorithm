class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] bit = new String[n];
        for (int i=0; i<n; i++) bit[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        
        for (int i=0; i<n; i++){
            
            bit[i] = String.format("%"+n+"s", bit[i].replace("0", " ").replace("1", "#"));
        }
        
        return bit;
    }
}
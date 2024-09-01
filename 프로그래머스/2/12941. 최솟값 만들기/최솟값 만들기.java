import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {

        int res = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i=0; i<A.length; i++) {
            
            res += A[i] * B[A.length-1-i];
        }
        
        return res;
    }
}
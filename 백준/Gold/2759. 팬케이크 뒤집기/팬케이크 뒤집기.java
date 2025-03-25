import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] sorted;
    static int[] pancake;
    static int k;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {

            StringTokenizer stk = new StringTokenizer(br.readLine());

            int pancakeSize = Integer.parseInt(stk.nextToken());
            pancake = new int[pancakeSize];
            sb = new StringBuilder();
            k=0;

            for(int j=0; j< pancakeSize; j++) pancake[j] = Integer.parseInt(stk.nextToken());

            sorted= new int[pancakeSize];
            for(int j=0; j<pancakeSize; j++) sorted[j] = pancake[j];
            Arrays.sort(sorted);
            
            pancakeSort(pancakeSize-1);
            System.out.println(k + " " + sb);
        }
    }

    private static void pancakeSort(int idx) {

        if(idx == 0) return;
        if(Arrays.equals(sorted, pancake)) return;

        int bigIdx = findBig(idx);

        if(bigIdx == 0) {

            flip(idx);
        }
        else {

            flip(bigIdx);
            flip(idx);

        }

        pancakeSort(idx-1);
    }

    private static void flip(int bigIdx) {

        int[] tmp = new int[pancake.length];

        for(int i=0; i< pancake.length; i++) tmp[i] = pancake[i];

        int idx = bigIdx;

        for(int i=0; i<= bigIdx; i++) pancake[i] = tmp[idx--];
        k++;

        sb.append(bigIdx+1).append(" ");
    }

    private static int findBig(int idx) {

        int max = -1;
        int big = -1;

        for(int i=0; i<=idx; i++){
            if(max < pancake[i]) {
                max = pancake[i];
                big = i;
            }

        }

        return big;
    }

}

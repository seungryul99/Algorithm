import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for(int i=0 ;i<n; i++) arr[i] = Integer.parseInt(stk.nextToken());

        int cnt = 0;

        for (int last = n-1; last > 0; last--){

            int max = -1;
            int pos = -1;
            for (int i=0; i<=last; i++){

                if (max < arr[i]){

                    pos = i;
                    max = arr[i];
                }
            }

            if (pos != last) {

                int temp = arr[last];
                arr[last] = arr[pos];
                arr[pos] = temp;
                cnt ++;

                if (cnt == k){

                    for(int x : arr) System.out.print(x + " ");
                }

            }
        }

       if(cnt < k) System.out.println(-1);

    }
}
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

        for (int i =1; i< n; i++){

            int loc = i-1;
            int newItem = arr[i];

            while (0<= loc && newItem < arr[loc]){
                arr[loc+1] = arr[loc];
                loc--; cnt ++;
                if(cnt == k) for(int x : arr) System.out.print(x + " ");
            }
            if(loc + 1 != i){
                arr[loc+1] = newItem;
                cnt++;

                if(cnt == k) for(int x : arr) System.out.print(x + " ");
            }

        }

        if (cnt < k) System.out.println(-1);

    }
}
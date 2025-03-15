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

        for (int i=n-1; i>0 ; i--){

            for (int j=0; j<n-1; j++){

                if(arr[j] > arr[j+1]){

                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;

                    cnt++;

                    if(k==cnt){

                        for(int x : arr) System.out.print(x + " ");
                    }
                }
            }
        }

        if (cnt < k) System.out.println(-1);
    }
}
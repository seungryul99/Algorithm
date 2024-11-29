import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {

    static int n ;
    static int[] arr = new int[100004];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int l=0, r=n-1;
        int sum = arr[l] + arr[r];
        int res1 = arr[l], res2 = arr[r];

        while(r!=l){
            int cur = arr[l]+arr[r];

            if(cur >0){

                if(abs(sum) > cur){
                    res1 = arr[l];
                    res2 = arr[r];
                    sum = cur;
                }
                r--;
            }
            else if (cur < 0){

                if(abs(sum) > abs(cur)){
                    res1 = arr[l];
                    res2 = arr[r];
                    sum = cur;
                }
                l++;
            }
            else {
                System.out.println(arr[l] + " " + arr[r]);
                System.exit(0);
            }
        }
        System.out.println(res1 + " " + res2);
    }
}

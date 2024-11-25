import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());


        long res = 0;
        int[] cnt = new int[100004];
        int s = 0;
        int e = 0;


        while (true){

            if(e==n){
                res += (long) (e - s) *(e-s+1)/2;
                break;
            }

            if(cnt[arr[e]]==0){
                cnt[arr[e]]++;
                e++;
            }
            else {
                res += (e-s);
                cnt[arr[s]]--;
                s++;
            }
        }

        System.out.println(res);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {

        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n+1];
        int[] psum = new int[n+1];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i+1] = x;
            psum[i+1] = psum[i] + x;
        }

        int l=1,r=1;
        int res = 100004;

        while (r < n+1){

            if(l==r){
                if(arr[l] >= s){
                    res = Math.min(res, 1);
                    break;
                }
                else{
                    if(l==n) break;
                    r++;
                }
            }

            if(psum[r]-psum[l-1] >= s){
                res = Math.min(res, r-l+1);
                l++;
            }
            else{
                r++;
            }
        }

        if(res == 100004) System.out.println(0);
        else System.out.println(res);

    }
}
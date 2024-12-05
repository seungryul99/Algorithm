import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static long[] x = new long[10004];
    static long[] y = new long[10004];



    static double solve(){

        long sum = 0;

        for(int i=1;i<=n;i++){

            if(i==n){
                sum += x[i]*y[1];
            }

            else sum += x[i]*y[i+1];
        }

        for(int i=1;i<=n;i++){

            if(i==n){
                sum -= x[1]*y[i];
            }

            else sum -= x[i+1]*y[i];
        }

        return Math.abs((double)sum/2);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        double res = solve();

        System.out.printf("%.1f", res);
    }
}
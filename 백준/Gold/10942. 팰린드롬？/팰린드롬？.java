import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] arr = new int [2004];
    static int[][] task = new int [1000004][2];
    static int[][] dp = new int [2004][2004];

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        n = Integer.parseInt(br.readLine());

        // arr 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());

        // m 입력
        m = Integer.parseInt(br.readLine());

        // case 입력
        for(int i=0; i<m; i++){

            st = new StringTokenizer(br.readLine());
            task[i][0] = Integer.parseInt(st.nextToken())-1;
            task[i][1] = Integer.parseInt(st.nextToken())-1;
        }


        // [로직]
        // size == 1인 팰린드롬
        for (int i=0; i<n; i++) dp[i][i] = 1;

        // size == 2인 팰린드롬
        for (int i=0; i<n-1; i++) if(arr[i] == arr[i+1]) dp[i][i+1] = 1;

        // size >= 3인 팰린드롬
        for(int size=3; size <= n; size++){

            for(int i=0; i<= n-size; i++){

                if(arr[i] == arr[i+size-1] && dp[i+1][i+size-2] == 1) dp[i][i+size-1] = 1;
            }
        }


        // [출력]
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<m; i++) {
           sb.append(dp[task[i][0]][task[i][1]]);
           sb.append("\n");
        }

        System.out.println(sb);
    }
}

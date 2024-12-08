import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int x;

    static int INF = 100000004;
    static int[] dp = new int[1000004];
    static int[] path = new int[1000004];

    static int go(int num){

        // 기저
        if(num == 1) return 1;

        // 메모이제이션
        if(dp[num] != -1) return dp[num];

        // 로직
        int val = INF;
        int sub;
        int trace = 0;

        if(num % 3 == 0) {
            sub = go(num/3);

            if(val > sub) {
                val = sub;
                trace = num/3;
            }
        }
        if(num % 2 == 0) {
            sub = go(num/2);

            if(val > sub) {
                val = sub;
                trace = num/2;
            }
        }

        sub = go(num-1);
        if(val > sub) {
            val = sub;
            trace = num-1;
        }

        path[num] = trace;

        return dp[num] = val + 1;
    }

    public static void printTrace(int num){
        if(num == 1) {
            System.out.print(1);
            return;
        }

        System.out.print(num + " ");
        printTrace(path[num]);
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        x = Integer.parseInt(br.readLine());

        // [로직]

        // dp 초기화
        Arrays.fill(dp,-1);


        // [출력]
        
        // 방문한 노드의 수
        int cnt = go(x);
        
        // 연산횟수 출력
        System.out.println(cnt-1);

        printTrace(x);

    }
}
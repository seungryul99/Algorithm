import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class Main {

    static int[] input = new int[100004];
    static int[][][] dp = new int[100004][5][5];


    // 각 발로 이동하는 경우 cost 계산
    static int cost(int cur, int next){

        // 중앙 -> Any : 2
        if (cur == 0) return 2;
        else{
            // 제자리 이동 : 1
            if(cur == next) return 1;
            else{

                // 2 차이나면 반대편 이동 : 4
                if (abs(cur-next)==2) return 4;
                else return 3;
            }
        }
    }


    static int go (int time, int left, int right) {

        int next = input[time];

        // 기저 사례
        if(next == 0) return 0;

        // 메모이제이션
        if(dp[time][left][right]!=0) return dp[time][left][right];


        // 로직

        // 왼발로 가는 경우, 오른발로 가는 경우
        return dp[time][left][right] = min(
                go(time+1, next, right) + cost(left, next),
                go(time+1, left, next) + cost(right, next)
        );
    }


    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        while (st.hasMoreTokens()) input[idx++] = Integer.parseInt(st.nextToken());


        // 초기화, 비용이 0인 경우 말이 아직 계산 되지 않았기 때문에 필요 X
        System.out.println(go(0,0,0));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.min;

public class Main {

    static String input;
    static char[] arr = new char [2504];
    static int[][] dp = new int [2504][2504];
    static int[] res = new int[2504];

    static int go(int start, int end){

        // 기저 사례
        if (end == input.length()-1) {
            if(dp[start][end]==1) return 1;
            else return 2504;
        }

        // 메모이제이션
        if(res[start] <= 2500) return res[start];


        // 로직
        if(dp[start][end] == 1){

            // start ~ end까지 팰린드롬이라서 개수를 추가하고 넘어가는 경우 or 한번 더 가는 경우
            return res[start] = min(go(end + 1, end + 1) + 1, go(start,end+1));
        }
        else {
            return res[start] = go(start, end+1);
        }
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input String 입력
        input = br.readLine();

        // char 배열 초기화
        for (int i = 0; i < input.length(); i++) arr[i] = input.charAt(i);


        // [로직]
        // size == 1인 팰린드롬

        if(input.length()==1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < input.length(); i++) dp[i][i] = 1;

        // size == 2인 팰린드롬
        for (int i = 0; i < input.length() - 1; i++) if (arr[i] == arr[i + 1]) dp[i][i + 1] = 1;

        // size >= 3인 팰린드롬
        for (int size = 3; size <= input.length(); size++) {

            for (int i = 0; i <= input.length() - size; i++) {

                if (arr[i] == arr[i + size - 1] && dp[i + 1][i + size - 2] == 1) dp[i][i + size - 1] = 1;
            }
        }



        // 모든 구간의 팰린드롬 여부를 구한 뒤 while 문을 돌리면서 팰린드롬 수를 체크해 나가려했는데
        // ABCDEF ... 이런식의 최악의 경우 O(N!) 탐색이 필요한 최악의 로직이 나와 버렸다.
        // 따라서 답의 최소 값을 구하는 dp를 한개 더 만들기로 했다.

        // 초기화
        Arrays.fill(res , 2504);

        System.out.println(go(0,0));
    }
}

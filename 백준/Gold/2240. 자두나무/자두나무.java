import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

// DP=> 완전탐색에서 메모이제이션을 적용
// 따라서 완전탐색으로 먼저 풀어봄, 시간초과 나기 성공함
//public class Main {
//
//    static int t, w;
//    static int[] a = new int[1004];
//
//    public static int go(int time, int pos, int cnt){
//        // 끝까지 탐색 된 경우 끝내고 돌아감
//        if(time == t) return 0;
//        // 더 이상 못 움직임
//        if(cnt == 0) return go(time+1, pos, cnt) + (a[time]==pos?1:0);
//
//        return max(go(time+1,pos,cnt),go(time+1, pos==1 ? 0 : 1, cnt-1))
//                + (a[time]==pos?1:0);
//    }
//
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        t = Integer.parseInt(st.nextToken());
//        w = Integer.parseInt(st.nextToken());
//
//        for (int i=0; i<t; i++) a[i] = Integer.parseInt(br.readLine())-1;
//
//        System.out.println(max(go (0,0,w),go(0,1,w-1)));
//    }
//}

// 이제 DP를 적용해봄
public class Main {

    static int t, w;
    static int[][][] dp = new int[1004][2][31];
    static int[] a = new int[1004];

    public static int go(int time, int pos, int cnt) {
        // 끝까지 탐색 된 경우 끝내고 돌아감
        if (time == t) return 0;
        // 더 이상 못 움직임
        if (cnt == 0) return go(time + 1, pos, cnt) + (a[time] == pos ? 1 : 0);

        // 메모이제이션
        if(dp[time][pos][cnt] != 0) return dp[time][pos][cnt];

        return dp[time][pos][cnt] =
                max(go(time + 1, pos, cnt), go(time + 1, pos == 1 ? 0 : 1, cnt - 1))
                + (a[time] == pos ? 1 : 0);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) a[i] = Integer.parseInt(br.readLine()) - 1;

        System.out.println(max(go(0, 0, w), go(0, 1, w - 1)));
    }
}

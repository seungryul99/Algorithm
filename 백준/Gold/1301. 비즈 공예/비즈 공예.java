import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n ,goal;
    static int[] bead = new int[6];
    static long[][][][][][][]dp = new long[6][6][11][11][11][11][11];

    static long go(int pprev, int prev, int a, int b, int c, int d, int e){

        // 구슬을 모두 만든 경우
        if(a+b+c+d+e == goal) return 1;

        // 메모이제이션
        if(dp[pprev][prev][a][b][c][d][e] != -1) return dp[pprev][prev][a][b][c][d][e];

        // 로직
        long val = 0;

        for(int next = 1; next<=n; next++){

            if(bead[next] == 0) continue;
            if(pprev == prev) continue;
            if(prev == next) continue;
            if(pprev == next) continue;

            int[] arr = new int[6];
            arr[next] ++;

            bead[next]--;
            val += go(prev, next, a+arr[1],b+arr[2],c+arr[3],d+arr[4],e+arr[5]);
            bead[next]++;
        }

        return dp[pprev][prev][a][b][c][d][e] =val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++) {
            bead[i] = Integer.parseInt(br.readLine());
            goal += bead[i];
        }

        // [로직]
        long res = 0;

        for(int i1=0; i1<6; i1++)
            for(int i2=0; i2<6;i2++)
                for(int i3=0; i3<11;i3++)
                    for(int i4=0; i4<11;i4++)
                        for(int i5=0; i5<11;i5++)
                            for(int i6=0; i6<11;i6++)
                                    Arrays.fill(dp[i1][i2][i3][i4][i5][i6],-1);

        for(int first=1;first<=n;first++){
            bead[first]--;
            for(int second = 1; second<=n; second++){
                if(bead[second]==0) continue;
                if(first == second) continue;

                bead[second]--;

                int[] arr = new int[6];
                arr[first]++;
                arr[second]++;

                res += go(first, second, arr[1], arr[2], arr[3], arr[4], arr[5]);
                bead[second]++;
            }
            bead[first]++;
        }

        // [출력]
        System.out.println(res);
    }
}
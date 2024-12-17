import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static double a, b;
    static double[][][] dp = new double[94][20][20];

    static boolean check(int num){

        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;

        for(int i=2; i * i <= num; i++) if(num % i == 0) return false;

        return true;
    }

    static double go(int time, int teamA, int teamB){

        // 기저
        if(time == 90) {

            if(check(teamA) || check(teamB)) return 1;
            else return 0;
        }

        // 메모이제이션
        if(dp[time][teamA][teamB] != -1) return dp[time][teamA][teamB];

        // 로직
        double val=0;

        val += go(time+5,teamA, teamB) * (1-a) * (1-b);
        val += go(time+5,teamA+1, teamB) * a * (1-b);
        val += go(time+5,teamA, teamB+1) * (1-a) * b;
        val += go(time+5,teamA+1, teamB+1) * a * b;

        return dp[time][teamA][teamB] = val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = (double) Integer.parseInt(br.readLine())/100;
        b = (double) Integer.parseInt(br.readLine())/100;

        // [로직]

        for(int i=0;i<94;i++){
            for(int j=0;j<20;j++){
                for (int k=0;k<20;k++) dp[i][j][k] = -1;
            }
        }

        System.out.println(go(0,0,0));
    }
}
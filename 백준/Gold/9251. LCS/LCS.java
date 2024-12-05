import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.*;

public class Main {

    static String s1, s2;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        // [로직]
        dp = new int[s1.length()][s2.length()];

        int idx = s2.indexOf(s1.charAt(0));

        if(idx!=-1){
            for(int i=0;i<s2.length();i++) if(i >= idx) dp[0][i] = 1;
        }

        idx = s1.indexOf(s2.charAt(0));

        if(idx!=-1){
            for(int i=0;i<s1.length();i++) if(i >= idx) dp[i][0] = 1;
        }

        for(int i=1;i<s1.length();i++){
            for(int j=1;j<s2.length();j++){

                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
            }
        }

        int max = 0;
        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s2.length();j++){

                if(max < dp[i][j]) max = dp[i][j];
            }
        }

        System.out.println(max);
    }
}
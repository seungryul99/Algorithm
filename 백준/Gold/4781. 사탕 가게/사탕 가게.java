import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class Main {

    static class Candy{
        int calorie;
        double price;
        public Candy(int calorie, double price){
            this.calorie = calorie;
            this.price = price;
        }
    }

    static int n, c;
    static double m, p;
    static List<Candy> candyList;
    static int[] dp = new int[10004];

    static int go(int money){

        // 기저
        if(money == 0) return 0;

        // 메모이제이션
        if(dp[money] != -1) return dp[money];

        // 로직
        int val = 0;

        for(int i=0;i<candyList.size();i++){

            int next = money-(int)((candyList.get(i).price+0.005)*100);

            if(next< 0) continue;

            val = max(val, go(next) + candyList.get(i).calorie);
        }

        return dp[money] = val;
    }

    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Double.parseDouble(st.nextToken());

            candyList = new ArrayList<>();

            if(n==0 && m==0.00) break;

            Arrays.fill(dp,-1);

            for(int i=0;i<n;i++) {
                st = new StringTokenizer(br.readLine());

                c = Integer.parseInt(st.nextToken());
                p = Double.parseDouble(st.nextToken());

                candyList.add(new Candy(c,p));
            }

            System.out.println(go((int)(100*(m+0.005))));
        }
    }
}
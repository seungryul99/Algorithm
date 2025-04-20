import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    static int[] arr;
    static ArrayList<Integer> subset = new ArrayList<>();
    static int n;

    static int go(int idx, int goal) {

        if(idx==n){

            int sum = subset.stream().reduce(0, Integer::sum);

            if (sum == goal && !subset.isEmpty()) return 1;
            return 0;
        }

        int cur = arr[idx];
        int val = 0;

        // cur을 포함 하는 부분 집합이 존재 하는 경우
        subset.add(cur);
        val += go(idx+1, goal);
        subset.remove(subset.size()-1);

        // cur이 포함 되는 부분 집합이 존재 하지 않는 경우
        val += go(idx+1, goal);

        return val;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        int s = Integer.parseInt(stk.nextToken());

        arr = new int[n];
        stk = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(stk.nextToken());

        System.out.print(go(0,s));
    }

}
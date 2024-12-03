import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.sort;

public class Main {

    static int t;
    static int n, m;
    static int[] a = new int[1004];
    static int[] psum_a = new int[1004];
    static int[] b = new int[1004];
    static int[] psum_b = new int[1004];

    static List<Integer> list_a = new ArrayList<>();
    static List<Integer> list_b = new ArrayList<>();


    public static void main(String[] args) throws IOException {

        // 입력 && 누적합 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            psum_a[i] = psum_a[i-1] + a[i];
        }

        m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            psum_b[i] = psum_b[i-1] + b[i];
        }

        // 모든 구간합 다 구하기
        for(int size=1; size<=n; size++){

            for(int i=size; i<=n; i++) list_a.add(psum_a[i]-psum_a[i-size]);
        }

        for(int size=1; size<=m; size++){

            for(int i=size; i<=m; i++) list_b.add(psum_b[i]-psum_b[i-size]);
        }


        // 예외
        if(list_a.size()==1 && list_b.size()==1) {

            if(list_a.get(0) + list_b.get(0) == t) System.out.println(1);
            else System.out.println(0);
            return;
        }

        // 정렬 후 투 포인터 사용
        sort(list_a);
        sort(list_b, Comparator.reverseOrder());

        long res =0;
        int l = 0, r = 0;

        while (l < list_a.size() && r < list_b.size()) {

            int sum = list_a.get(l) + list_b.get(r);

            if(sum > t) r++;
            else if (sum <t) l++;
            else {
                long cnt_a = 0;
                long cnt_b = 0;
                int cur_a = list_a.get(l);
                int cur_b = list_b.get(r);

                while (l<list_a.size() && list_a.get(l)==cur_a){
                    cnt_a++;
                    l++;
                }

                while (r<list_b.size() && list_b.get(r)==cur_b){
                    cnt_b++;
                    r++;
                }

                res += cnt_a*cnt_b;
            }
        }


        // 출력
        System.out.println(res);
    }
}

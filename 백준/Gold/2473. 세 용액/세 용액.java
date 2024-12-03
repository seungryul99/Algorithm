import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class Main {

    static int n ;
    static List<Integer>[] list = new List[5004];
    static int[] fix = new int[5004];
    static List<Integer> realList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) realList.add(Integer.parseInt(st.nextToken()));

        Collections.sort(realList);

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if (i != j) list[i].add(realList.get(j));
                else fix[i] = realList.get(i);
            }
        }

        long[] res = {100000000004L, 100000000004L, 100000000004L};

        for (int i = 0; i < n; i++) {

            int l = 0, r = n - 2;

            while (l != r) {
                long sum = (long) fix[i] + list[i].get(l) + list[i].get(r);

                if (sum == 0L) {
                    res[0] = fix[i];
                    res[1] = list[i].get(l);
                    res[2] = list[i].get(r);

                    Arrays.sort(res);
                    System.out.println(res[0] + " " + res[1] + " " + res[2]);
                    return;
                } else if (sum > 0L) {

                    if (sum < abs(res[0] + res[1] + res[2])) {
                        res[0] = fix[i];
                        res[1] = list[i].get(l);
                        res[2] = list[i].get(r);
                    }
                    r--;
                } else {
                    if (abs(sum) < abs(res[0] + res[1] + res[2])) {
                        res[0] = fix[i];
                        res[1] = list[i].get(l);
                        res[2] = list[i].get(r);
                    }
                    l++;
                }
            }

        }

        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}

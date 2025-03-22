import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int cnt, k;


    static void swap(int e1, int e2){

        cnt++;

        int tmp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = tmp;

        if(cnt==k) {
            for (int e : arr) System.out.print(e + " ");
        }
    }

    static void quickSort(int str, int end){

        if(str < end) {

            int q = partition(str, end);
            quickSort(str, q-1);
            quickSort(q+1, end);
        }
    }

    static int partition(int str, int end) {

        int x = arr[end];
        int i = str-1;

        for(int j=str; j<= end-1; j++){

            if(arr[j] <= x) swap(++i,j);
        }

        if(i+1 != end) swap(i+1, end);

        return i+1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        arr = new int[n];

        stk = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(stk.nextToken());

        quickSort(0,n-1);

        if(cnt < k) System.out.println(-1);
    }
}
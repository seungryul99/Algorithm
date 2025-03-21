import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int cnt, res, k;


    static void mergeSort(int str, int end){

        if(str < end) {

            int half = (str + end)/2;

            mergeSort(str, half);
            mergeSort(half+1, end);
            merge(str,half,end);
        }
    }

    static void merge(int str, int half, int end){



        int idx1 = str;
        int idx2 = half+1;
        int idx3 = 0;
        int[] tmp = new int[end - str + 1];

        while (true){

            if (idx1 > half) {

                while (idx2 <= end) {

                    tmp[idx3++] = arr[idx2++];
                }
                break;
            }

            if (idx2 > end){

                while (idx1 <= half){

                    tmp[idx3++] = arr[idx1++];
                }
                break;
            }

            if(arr[idx1] < arr[idx2]) tmp[idx3++] = arr[idx1++];
            else tmp[idx3++] = arr[idx2++];
        }

        int idx4 = 0;
        for(int i=str; i<=end; i++) {
            cnt++;
            arr[i] = tmp[idx4++];

            if(cnt == k) res = arr[i];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        arr = new int[n];

        stk = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++) arr[i] = Integer.parseInt(stk.nextToken());

        mergeSort(0,n-1);

        if(cnt < k) System.out.println(-1);
        else System.out.println(res);
    }
}
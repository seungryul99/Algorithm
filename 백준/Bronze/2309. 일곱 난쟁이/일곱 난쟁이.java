import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] heights = new int[9];
    static int sum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++) {
            heights[i] = Integer.parseInt(br.readLine());
            sum += heights[i];
        }

        boolean endFlag = false;
        for(int i=0;i<9;i++){

            if(endFlag) break;

            for(int j=i+1;j<9;j++){

                if(sum - heights[i] - heights[j] == 100){

                    heights[i] = 0;
                    heights[j] = 0;
                    endFlag = true;
                    break;
                }
            }
        }

        Arrays.sort(heights);
        for(int height : heights){

            if(height == 0) continue;
            System.out.println(height);
        }
    }
}
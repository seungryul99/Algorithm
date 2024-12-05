import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class Main {

    static int[][] board = new int[9][9];
    static int zero;
    static List<Pair> blank = new ArrayList<>();

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static void print() {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) System.out.print(board[i][j]);
            System.out.println();
        }
    }

    static boolean lineCheck(int y, int x, int num) {

        for (int i = 0; i < 9; i++) {

            // 가로 체크
            if (board[y][i] == num) return false;

            // 세로 체크
            if (board[i][x] == num) return false;
        }

        return true;
    }

    static boolean areaCheck(int y, int x, int num) {

        int y_start = y / 3 * 3;
        int x_start = x / 3 * 3;

        for (int i = y_start; i < y_start + 3; i++) {
            for (int j = x_start; j < x_start + 3; j++) {

                if (num == board[i][j]) return false;
            }
        }

        return true;
    }

    static void solve(int zeroCnt, int idx) {
        if (zeroCnt == 0) {
            print();
            exit(0);
        }

        int y = blank.get(idx).y;
        int x = blank.get(idx).x;

        for (int num = 1; num <= 9; num++) {

            if (lineCheck(y, x, num) && areaCheck(y, x, num)) {
                board[y][x] = num;
                solve(zeroCnt - 1, idx + 1);
                board[y][x] = 0;
            }
        }
    }


    public static void main(String[] args) throws IOException {

        // [입력]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        for (int i = 0; i < 9; i++) {

            s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - 48;
                if (board[i][j] == 0) {
                    blank.add(new Pair(i, j));
                    zero++;
                }
            }
        }

        // [로직]
        solve(zero, 0);
    }
}
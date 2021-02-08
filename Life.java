import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Life
 */
public class Life {

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);
        // int[][] is = random_state(50, 40);
        // int[][] is = { { 1, 0, 1, 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
        // { 0, 1, 0, 0, 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0,
        // 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0,
        // 0, 0, 0, 0, 0 },
        // { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 } };// Red glider
        // on the square
        // // lattice WITHOUT periodic
        // // boundary conditions
        int m, n;
        m = scanner.nextInt();
        n = scanner.nextInt();
        int[][] is = random_state(m, n);
        do {
            printArray(is);
            is = next_board_state(is);
            // int temp = scanner.nextInt();
            TimeUnit.MILLISECONDS.sleep(100);
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } while (true);
    }

    public static int[][] random_state(int m, int n) {
        int[][] is = new int[m ][n ];
        for (int i =0; i < m ; i++) {
            for (int j =0; j < n ; j++) {
                is[i][j] = new Random(new Random().nextInt()).nextDouble() >= 0.5 ? 0 : 1;// to increasedensity of 1
                                                                                          // increse 0.5
                // System.out.print(is[i][j] + " ");
            }
            // System.out.println();
        }
        return is;
    }

    public static void printArray(int[][] is) {
        for (int i = 0; i < is.length; i++) {
            System.out.print("|");
            for (int j = 0; j < is[i].length; j++) {
                System.out.print(" ");
                System.out.print(is[i][j] == 1 ? "#" : " ");
                System.out.print(" ");
            }
            System.out.println("|");
            System.out.println();
        }
    }

    static int[][] next_board_state(int[][] is) {
        int[][] is2 = new int[is.length][is[0].length];
        for (int i = 0; i < is2.length; i++) {
            for (int j = 0; j < is2[i].length; j++) {
                is2[i][j] = next_cell_state(i, j, is);
            }
        }
        return is2;
    }

    static int next_cell_state(int i, int j, int[][] is) {

        int pop = is[(i - 1 + is.length) % is.length][(j - 1 + is[0].length) % is[0].length]
                + is[(i - 1 + is.length) % is.length][j] + is[(i - 1 + is.length) % is.length][(j + 1) % is[0].length]
                + is[i][(j - 1 + is[0].length) % is[0].length] + is[i][(j + 1) % is[0].length]
                + is[(i + 1) % is.length][(j - 1 + is[0].length) % is[0].length] + is[(i + 1) % is.length][j]
                + is[(i + 1) % is.length][(j + 1) % is[0].length];
        if (pop < 2 && is[i][j] == 1) {
            return 0;
        } else if (pop < 4 && is[i][j] == 1) {
            return 1;
        } else if (pop > 3 && is[i][j] == 1) {
            return 0;
        }
        if (pop == 3 && is[i][j] == 0) {

            return 1;
        } else
            return 0;
    }

}
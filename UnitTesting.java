import java.util.Arrays;

/**
 * UnitTesting
 */
public class UnitTesting {

    public static String unitTest1() {
        // TEST 1: dead cells with no live neighbors
        int[][] currentState = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        int[][] expectedNextState = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        int[][] actualNextState = Life.next_board_state(currentState);
        if (Arrays.deepEquals(expectedNextState, actualNextState)) {
            return "Passed Test 1";
        } else {
            return "Failed Test 1";
        }
    }

    public static String unitTest2() {
        // TEST 2: dead cells with exactly 3 neighbors
        int[][] currentState = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 1, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        int[][] expectedNextState = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 } };
        int[][] actualNextState = Life.next_board_state(currentState);
        if (Arrays.deepEquals(expectedNextState, actualNextState)) {
            return "Passed Test 2";
        } else {
            return "Failed Test 2";
        }

    }

    public static void main(String[] args) {
        // System.out.println(unitTest1());
        System.out.println(unitTest2());
    }
}
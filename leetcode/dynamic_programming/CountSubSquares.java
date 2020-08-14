package leetcode.dynamic_programming;

public class CountSubSquares {

    public int countSquares(int[][] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
        }

        // row to check
        // col to check
        int rtc = matrix.length - 2;
        int ctc = matrix[0].length - 2;
        for (int i = rtc; i >= 0; i--) {
            for (int j = ctc; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                // meaning assigned = stores the length of the side of square
                matrix[i][j] = Math.min(matrix[i + 1][j + 1], Math.min(matrix[i][j + 1], matrix[i + 1][j])) + 1;
                // -1 will tell no. of new squares that coould be formed with this point
                // included
                count += matrix[i][j] - 1;
            }
        }
        return count;
    }

}
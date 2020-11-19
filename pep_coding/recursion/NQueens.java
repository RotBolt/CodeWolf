package pep_coding.recursion;

public class NQueens {

    public static void main(String[] args) {
        boolean[][] board = new boolean[3][3];
        // much much much faster
        // nQeensProActive(board, 0, "", -1);
        // nQueensASS(board, 0, 0, "");
        nKnightsASS(board, 0, 0, "");
    }

    static int count = 0;

    public static void nQueensASS(boolean[][] board, int box, int qpsf, String asf) {

        if (qpsf == board.length) {
            count++;
            System.out.println(asf + " : count " + count);
            return;
        }

        if (box >= board.length * board.length) {
            return;
        }

        nQueensASS(board, box + 1, qpsf, asf);

        int row = box / board.length;
        int col = box % board[0].length;
        if (board[row][col] == false) {
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true;
                nQueensASS(board, box + 1, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + (box) + " ");
                board[row][col] = false;
            }
        }
    }

    public static void nQueensProActive(boolean[][] board, int qpsf, String asf, int lqbp) {
        if (qpsf == board.length) {
            count++;
            System.out.println(asf + " : count " + count);
            return;
        }

        for (int b = lqbp + 1; b < board.length * board.length; b++) {
            int row = b / board.length;
            int col = b % board.length;
            if (board[row][col] == false) {
                if (isQueenSafe(board, row, col)) {
                    board[row][col] = true;
                    nQueensProActive(board, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
                    board[row][col] = false;
                }
            }
        }
    }

    // boardNo = row*board.length+col
    public static void nQueens(boolean[][] board, int qpsf, String asf, int lqbp) {
        if (qpsf == board.length) {
            count++;
            if (isBoardSafe(board)) {
                System.out.println(asf + " : count " + count);
            }
            return;
        }

        for (int b = lqbp + 1; b < board.length * board.length; b++) {
            int row = b / board.length;
            int col = b % board.length;
            if (board[row][col] == false) {
                board[row][col] = true;
                nQueens(board, qpsf + 1, asf + "q" + (qpsf + 1) + "b" + b + " ", b);
                board[row][col] = false;
            }
        }
    }

    private static boolean isBoardSafe(boolean[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == true) {
                    if (isQueenSafe(board, row, col) == false) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isQueenSafe(boolean[][] board, int row, int col) {
        int[][] dirs = { { 0, -1 }, // North -> x,y
                { +1, -1 }, // NE
                { +1, 0 }, // East
                { +1, +1 }, // SE
                { 0, +1 }, // South
                { -1, +1 }, // SW
                { -1, 0 }, // West
                { -1, -1 } // NW
        };

        for (int di = 0; di < dirs.length; di++) {
            for (int dist = 1; true; dist++) {
                int eqrow = row + dist * dirs[di][1];
                int eqcol = col + dist * dirs[di][0];

                if (eqrow < 0 || eqcol < 0 || eqrow >= board.length || eqcol >= board[0].length) {
                    break;
                }

                if (board[eqrow][eqcol] == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void nKnightsASS(boolean[][] board, int box, int kpsf, String asf) {

        if (kpsf == board.length) {
            count++;
            System.out.println(asf + " : count " + count);
            return;
        }

        if (box >= board.length * board.length) {
            return;
        }

        nKnightsASS(board, box + 1, kpsf, asf);

        int row = box / board.length;
        int col = box % board[0].length;
        if (board[row][col] == false) {
            if (isKnightSafe(board, row, col)) {
                board[row][col] = true;
                nKnightsASS(board, box + 1, kpsf + 1, asf + "k" + (kpsf + 1) + "b" + (box) + " ");
                board[row][col] = false;
            }
        }
    }

    private static boolean isKnightSafe(boolean[][] board, int row, int col) {
        int[][] dirs = { { +1, -2 }, // North -> x,y
                { +2, -1 }, // NE
                { +2, +1 }, // East
                { +1, +2 }, // SE
                { -1, +2 }, // South
                { -2, +1 }, // SW
                { -2, -1 }, // West
                { -1, -2 } // NW
        };

        for (int di = 0; di < dirs.length; di++) {
            int ekrow = row + dirs[di][1];
            int ekcol = col + dirs[di][0];

            if (ekrow < 0 || ekcol < 0 || ekrow >= board.length || ekcol >= board[0].length) {
                continue;
            }

            if (board[ekrow][ekcol] == true) {
                return false;
            }
        }
        return true;
    }

}
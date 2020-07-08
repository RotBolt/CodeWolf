package recursion;

public class BoardPath {

    public static void main(String[] args) {
        // printBoardPath(10, 0, "");
        // printBoardPathOneSixOpen(10, 0, "");
        // int[] ladders = new int[16];
        // ladders[2] = 13;
        // ladders[3] = 11;
        // ladders[5] = 7;
        // printBoardPathOneSixOpenLadder(ladders.length - 1, 0, "", ladders);

        int[] snl = new int[21];
        snl[3] = 17;
        snl[7] = 11;
        snl[13] = 5;
        snl[19] = 2;

        int[] moves1 = { 2, 5, 3, 4, 6, 3, 4, 3, 5, 1, 2, 3 };
        int[] moves2 = { 2, 5, 3, 4, 6, 3, 4, 3, 5, 1, 1, 6, 5, 2, 3, 5 };
        printBoardPathOneSixOpenWithSNL(0, 20, snl, moves1, 0);
        printBoardPathOneSixOpenWithSNL(0, 20, snl, moves2, 0);
    }

    static int count = 0;

    public static void printBoardPath(int boardSize, int ssf, String psf) {
        if (ssf == boardSize) {
            count++;
            System.out.println(psf + " : count " + count);
            return;
        }
        // reactive style, negative base case
        if (ssf > boardSize) {
            return;
        }

        // for pro active check before making call
        for (int i = 1; i <= 6; i++) {
            printBoardPath(boardSize, ssf + i, psf + i);
        }
    }

    public static void printBoardPathOneSixOpen(int boardSize, int ssf, String psf) {
        if (ssf == boardSize) {
            count++;
            System.out.println(psf + " : count " + count);
            return;
        }
        // reactive style, negative base case
        if (ssf > boardSize) {
            return;
        }

        // for pro active check before making call
        if (ssf == 0) {
            printBoardPathOneSixOpen(boardSize, ssf + 1, psf + 1);
            printBoardPathOneSixOpen(boardSize, ssf + 1, psf + 6);
        } else {
            for (int i = 1; i <= 6; i++) {
                printBoardPathOneSixOpen(boardSize, ssf + i, psf + i);
            }
        }
    }

    public static void printBoardPathOneSixOpenLadder(int boardSize, int ssf, String psf, int[] ladders) {
        if (ssf == boardSize) {
            count++;
            System.out.println(psf + " : count " + count);
            return;
        }
        // reactive style, negative base case
        if (ssf > boardSize) {
            return;
        }

        // for pro active check before making call
        if (ssf == 0) {
            printBoardPathOneSixOpenLadder(boardSize, ssf + 1, psf + 1, ladders);
            printBoardPathOneSixOpenLadder(boardSize, ssf + 1, psf + 6, ladders);
        } else if (ladders[ssf] != 0) {
            printBoardPathOneSixOpenLadder(boardSize, ladders[ssf], psf + "[" + ssf + "->" + ladders[ssf] + "]",
                    ladders);
        } else {
            for (int i = 1; i <= 6; i++) {
                printBoardPathOneSixOpenLadder(boardSize, ssf + i, psf + i, ladders);
            }
        }
    }

    public static void printBoardPathOneSixOpenWithSNL(int src, int dest, int[] snl, int[] moves, int mvi) {

        if (src == dest) {
            System.out.println("Win");
            return;
        }

        if (mvi == moves.length) {
            System.out.println("Lose : " + src);
            return;
        }

        if (src == 0) {
            if (moves[mvi] == 1 || moves[mvi] == 6) {
                printBoardPathOneSixOpenWithSNL(1, dest, snl, moves, mvi + 1);
            } else {
                printBoardPathOneSixOpenWithSNL(src, dest, snl, moves, mvi + 1);
            }
        } else {
            if (snl[src] != 0) {
                printBoardPathOneSixOpenWithSNL(snl[src], dest, snl, moves, mvi);
            } else {
                if (src + moves[mvi] <= dest) {
                    printBoardPathOneSixOpenWithSNL(src + moves[mvi], dest, snl, moves, mvi + 1);
                } else {
                    printBoardPathOneSixOpenWithSNL(src, dest, snl, moves, mvi + 1);
                }
            }
        }
    }

}
package recursion;

public class MazePath {

    public static void main(String[] args) {
        printMazePathMultiStep(0, 0, 3, 3, "");
    }

    static int count = 0;

    public static void printMazePath(int sr, int sc, int dr, int dc, String psf) {

        if (sc == dc && sr == dr) {
            count++;
            System.out.println(psf + " : count " + count);

            return;
        }

        if (sr > dr || sc > dc) {
            return;
        }

        printMazePath(sr + 1, sc, dr, dc, psf + "H");
        printMazePath(sr, sc + 1, dr, dc, psf + "V");

    }

    public static void printMazePathDiagnol(int sr, int sc, int dr, int dc, String psf) {

        if (sc == dc && sr == dr) {
            count++;
            System.out.println(psf + ": count " + count);
            return;
        }

        if (sr > dr || sc > dc) {
            return;
        }

        printMazePathDiagnol(sr + 1, sc, dr, dc, psf + "H");
        printMazePathDiagnol(sr, sc + 1, dr, dc, psf + "V");
        printMazePathDiagnol(sr + 1, sc + 1, dr, dc, psf + "D");

    }

    public static void printMazePathMultiStep(int sr, int sc, int dr, int dc, String psf) {

        if (sc == dc && sr == dr) {
            count++;
            System.out.println(psf + ": count " + count);
            return;
        }
        // Horizontals
        for (int step = 1; step <= dc - sc; step++) {
            printMazePathMultiStep(sr, sc + step, dr, dc, psf + "V" + step + ", ");
        }

        // Verticals
        for (int step = 1; step <= dr - sr; step++) {
            printMazePathMultiStep(sr + step, sc, dr, dc, psf + "H" + step + ", ");
        }
        // Diagnols
        for (int step = 1; step <= dr - sr && step <= dc - sc; step++) {
            printMazePathMultiStep(sr + step, sc + step, dr, dc, psf + "D" + step + ", ");
        }
    }
}
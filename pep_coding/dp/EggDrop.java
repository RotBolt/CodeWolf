package pep_coding.dp;

/**
 * Given e eggs and f floors, Find minimum no. of trials to find the critical
 * floor (cfF) in a guaranteed way
 * 
 * 
 * 
 * Best of worst for guaranteed way
 */

public class EggDrop {
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 64;
        System.out.println(eggDropMeme(eggs, floors, new int[eggs + 1][floors + 1]));
        System.out.println(eggDropTab(eggs, floors));
    }

    public static int eggDropMeme(int eggs, int floors, int[][] store) {

        // niche se sab floors pe fek ker dekho
        if (eggs == 1) {
            return floors;
        }

        // ek baar toh fekna padega
        if (floors == 1) {
            return 1;
        }

        if (floors == 0) {
            return 0;
        }

        if (store[eggs][floors] != 0) {
            return store[eggs][floors];
        }

        int minTrial = Integer.MAX_VALUE;
        for (int f = 1; f <= floors; f++) {
            int mtEggBreaks = eggDropMeme(eggs - 1, f - 1, store);
            int mtEggSurvives = eggDropMeme(eggs, floors - f, store);

            int maxTrialsWorst = Math.max(mtEggBreaks, mtEggSurvives);
            if (maxTrialsWorst < minTrial) {
                minTrial = maxTrialsWorst;
            }
        }
        store[eggs][floors] = minTrial + 1;
        return minTrial + 1;
    }

    public static int eggDropTab(int eggs, int floors) {
        int[][] trials = new int[eggs + 1][floors + 1];

        for (int e = 1; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                if (e == 1) {
                    trials[e][f] = f;
                } else if (f == 1) {
                    trials[e][f] = 1;
                } else {
                    int minTrial = Integer.MAX_VALUE;
                    for (int k = 1; k <= f; k++) {
                        int mtEggBreaks = trials[e - 1][k - 1];
                        int mtEggSurvives = trials[e][f - k];

                        int maxtTrailsWorst = Math.max(mtEggBreaks, mtEggSurvives);
                        if (maxtTrailsWorst < minTrial) {
                            minTrial = maxtTrailsWorst;
                        }
                    }
                    trials[e][f] = minTrial + 1;
                }
            }
        }
        return trials[eggs][floors];
    }

}
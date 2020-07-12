package dp;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] dims = { 10, 20, 30, 40, 50, 60 };
        System.out.println(mcmMeme(dims, 0, dims.length - 1, new int[dims.length][dims.length]));
        System.out.println(mcmTab(dims));
    }

    public static int mcmMeme(int[] dims, int si, int ei, int[][] store) {

        if (ei - si == 1) {
            return 0;
        }

        if (store[si][ei] != 0) {
            return store[si][ei];
        }

        int minCost = Integer.MAX_VALUE;
        for (int cbp = si + 1; cbp < ei; cbp++) {
            int mcfp = mcmMeme(dims, si, cbp, store); // dims[si] * dims[cbp] in size
            int mcsp = mcmMeme(dims, cbp, ei, store); // dims[cbp] * dims[ei] in size

            int pc = dims[si] * dims[ei] * dims[cbp];

            int totaThisCbp = mcfp + mcsp + pc;
            if (minCost > totaThisCbp) {
                minCost = totaThisCbp;
            }
        }

        store[si][ei] = minCost;
        return minCost;
    }

    public static int mcmTab(int[] dims) {
        int[][] mcm = new int[dims.length][dims.length];

        for (int dia = 1; dia < dims.length; dia++) {
            int si = 0;
            int ei = dia;
            while (ei < dims.length) {
                if (dia == 1) {
                    mcm[si][ei] = 0;
                } else {
                    int minCost = Integer.MAX_VALUE;
                    for (int cbp = si + 1; cbp < ei; cbp++) {
                        int mcfp = mcm[si][cbp];
                        int mcsp = mcm[cbp][ei];

                        int pc = dims[si] * dims[ei] * dims[cbp];
                        int totaThisCbp = mcfp + mcsp + pc;
                        if (minCost > totaThisCbp) {
                            minCost = totaThisCbp;
                        }
                    }
                    mcm[si][ei] = minCost;
                }

                si++;
                ei++;
            }
        }
        return mcm[0][dims.length - 1];
    }

}
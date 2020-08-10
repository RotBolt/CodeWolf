package leetcode.may_challenge.week5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    class Coords {
        int[] point;
        int dist;
    }

    // ascending order
    class CoordComparator implements Comparator<Coords> {

        @Override
        public int compare(Coords o1, Coords o2) {
            if (o1.dist > o2.dist) {
                return 1;
            } else if (o1.dist < o2.dist) {
                return -1;
            } else {
                return 0;
            }
        }

    }

    // O(n+ Klogn). space = O(n)
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Coords> minHeap = new PriorityQueue<>(new CoordComparator());

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int euclidDistance = square(point[0]) + square(point[1]);
            Coords coord = new Coords();
            coord.point = point;
            coord.dist = euclidDistance;
            minHeap.add(coord);
        }

        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            Coords coords = minHeap.poll();
            ans[i] = coords.point;
        }
        return ans;

    }

    private int square(int num) {
        return num * num;
    }

}
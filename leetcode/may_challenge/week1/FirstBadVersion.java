package leetcode.may_challenge.week1;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // dummy one to simulate leetcode api
	private boolean isBadVersion(int mid) {
		return false;
	}


}
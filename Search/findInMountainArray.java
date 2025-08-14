package Search;
public class findInMountainArray {

    /**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = peakIndexMountainArray(mountainArr);

        // Search in the ascending part
        int firstTry = orderAgnosticBS(mountainArr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }

        // Search in the descending part
        return orderAgnosticBS(mountainArr, target, peak + 1, mountainArr.length() - 1);
    }

    // Find peak index in a mountain array
    private int peakIndexMountainArray(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                start = mid + 1; // Move right
            } else {
                end = mid; // Move left
            }
        }
        return start; // Peak index
    }

    // Order-Agnostic Binary Search
    private int orderAgnosticBS(MountainArray mountainArr, int target, int start, int end) {

        boolean isAscending = mountainArr.get(start) < mountainArr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);

            if (midVal == target) {
                return mid;
            }

            if (isAscending) {
                if (midVal < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (midVal > target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}

}
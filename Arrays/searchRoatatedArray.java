public class searchRoatatedArray {

    class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums);
        int start = 0;
        
        if(pivot == -1){
            return binarySearch(nums, target, 0, n-1);
        }

        if(nums[pivot] == target){
            return pivot;
        }

        if(nums[start] > target){
            return binarySearch(nums, target, pivot + 1, n-1);
        }
        else{
             return binarySearch(nums, target, 0, pivot-1);
        }
  
    }

     public int findPivot(int[] nums){
            int start = 0;
            int end = nums.length - 1;

            while(start <= end){

                int mid = start + (end - start) / 2;

                if(mid < end && nums[mid] > nums[mid + 1]){
                    return mid;
                }else if(mid > start && nums[mid] < nums[mid - 1]){
                    return mid -1;
                }else if(nums[start] < nums[mid]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }

            }

            return -1;

        }

         public int binarySearch(int[] nums, int target, int start, int end){

            while(start <= end){

                int mid = start + (end - start) / 2;

                if(nums[mid] == target){
                    return mid;
                }else if(target < nums[mid]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }
            return -1;
        }
}
}
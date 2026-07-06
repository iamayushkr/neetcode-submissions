class Solution {
public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        // Keep going until the scout pointer crosses the high boundary
        while (mid <= high) {
            if (nums[mid] == 0) {
                // Found a 0: send it to the front
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Found a 1: leave it in the middle
                mid++;
            } else {
                // Found a 2: send it to the back
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
                // Notice we DO NOT do mid++ here!
            }
        }
    }
}
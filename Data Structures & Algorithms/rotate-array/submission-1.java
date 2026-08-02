class Solution {
    public void rotate(int[] nums, int k) {
        // Step 0: Handle the edge case if k is larger than the array length
        k = k % nums.length;
        
        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }
    
    // Your awesome helper method!
    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
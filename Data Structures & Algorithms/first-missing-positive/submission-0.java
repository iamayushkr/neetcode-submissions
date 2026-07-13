class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // 1. The Swapping Phase
        for (int i = 0; i < n; i++) {
            // While the number is in our valid range AND not already at its destination
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap the current number to its correct index (nums[i] - 1)
                int correctIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        
        // 2. The Searching Phase
        for (int i = 0; i < n; i++) {
            // The first index where the number is NOT i + 1 is our missing number
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        // 3. The Edge Case
        // If every number from 1 to n was perfectly in place, the next missing is n + 1
        return n + 1;
    }
}
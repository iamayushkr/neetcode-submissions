class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // HashMap to store (Running Total -> Frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Crucial setup: We've seen a running total of 0 exactly 1 time before starting
        map.put(0, 1);
        
        for (int num : nums) {
            // 1. Calculate the new running total
            currentSum += num;
            
            // 2. Check if we can "chop off" a past prefix sum to get our target 'k'
            int pastSumWeNeed = currentSum - k;
            if (map.containsKey(pastSumWeNeed)) {
                // Add the frequency of that past sum to our total count
                count += map.get(pastSumWeNeed);
            }
            
            // 3. Add or update the current sum in the map for future numbers to use
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
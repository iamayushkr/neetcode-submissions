class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        
        int leftMax = height[left];
        int rightMax = height[right];
        
        int totalWater = 0;

        while (left < right) {
            // The water level is bottlenecked by the left side
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } 
            // The water level is bottlenecked by the right side
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }

        return totalWater;
    }
}
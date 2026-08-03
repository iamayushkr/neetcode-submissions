class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            // The width is the distance between the two pointers
            int width = right - left;
            
            // The height is limited by the shorter bar
            int currentArea = Math.min(heights[left], heights[right]) * width;
            
            // Update the maximum area seen so far
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer at the shorter bar inward to seek a taller boundary
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
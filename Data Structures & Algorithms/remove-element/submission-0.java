class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int reader = 0, writer = 0;
        while (reader < len) {
            if(nums[reader]!=val) {
                nums[writer]=nums[reader];
                writer++;
            }
            reader++;
        }
        return writer;
    }
}
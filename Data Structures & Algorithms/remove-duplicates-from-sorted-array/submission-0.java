class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (set.contains(nums[right])) {
                right++;
            } else {
                set.add(nums[right]);
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }
}
class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map <Integer, Integer> ans = new HashMap<>();
        for ( int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            if(ans.containsKey(num)) {
                return true;
            } else {
                ans.put(num,1);
            }
        }
        return false;
    }
}
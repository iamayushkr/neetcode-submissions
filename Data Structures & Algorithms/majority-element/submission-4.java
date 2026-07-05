class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityEle = nums[0];
        int i = 1;
        while (i < nums.length) {
            int currEle = nums[i];
            if (currEle == majorityEle) {
                count++;
            } else {
                if (count==0) {
                majorityEle = currEle;
                } else {
                    count--;
                }
            }
            i++;
        }
        return majorityEle;
    }
}
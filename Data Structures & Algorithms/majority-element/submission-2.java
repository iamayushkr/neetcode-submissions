class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < len ; i++) {
            int currEle = nums[i];
            if(map.containsKey(currEle)) {
                int currEleFreq = map.get(currEle);
                if (currEleFreq >= len/2) {
                    return currEle;
                }
                map.put(currEle, currEleFreq+1);
            } else {
                map.put(currEle, 1);
            }
        }
        return nums[0];
    }
}
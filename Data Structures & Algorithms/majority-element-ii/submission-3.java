class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int candidate1 = 0, count1 = 0;
        int candidate2 = 0, count2 = 0;

        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        int actualCount1 = 0;
        int actualCount2 = 0;

        for (int num : nums) {
            if (num == candidate1) {
                actualCount1++;
            } else if (num == candidate2) {
                actualCount2++;
            }
        }

        int threshold = nums.length / 3;

        if (actualCount1 > threshold) ans.add(candidate1);
        if (actualCount2 > threshold) ans.add(candidate2);

        return ans;
    }
}
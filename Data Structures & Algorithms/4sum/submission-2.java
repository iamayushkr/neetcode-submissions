class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < length - 2 ; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1;
                int right = length - 1;
                while (left<right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                if (sum == target) {
                    answer.add(Arrays.asList(nums[left], nums[right], nums[i], nums[j]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                }
            }
        }
        return answer;
    }
}
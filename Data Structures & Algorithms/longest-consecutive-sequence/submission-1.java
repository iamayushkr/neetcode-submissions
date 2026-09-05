class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }

        int maxSeq = 0;
        for (int num : set) {
            if(!(set.contains(num-1))) {
                int i = 1;
                while(set.contains(num+i)){
                    i++;
                }
                if (i>maxSeq)
                maxSeq=i;
            }
        }
        return maxSeq;
    }
}

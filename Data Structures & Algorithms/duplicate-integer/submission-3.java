class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num -> !seen.add(num));
    }
}
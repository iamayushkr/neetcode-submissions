class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            while (set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
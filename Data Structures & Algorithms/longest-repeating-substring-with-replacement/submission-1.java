class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int start = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int end = 0;
        for ( ; end < s.length(); end++) {
            counts[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, counts[s.charAt(end) - 'A']);
            while ((end - start + 1) - maxFreq > k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
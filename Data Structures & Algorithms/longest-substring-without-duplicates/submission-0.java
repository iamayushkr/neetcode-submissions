class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            
            // We use a 'while' loop instead of 'if' to keep shrinking 
            // the window from the left until the duplicate is completely gone.
            while (set.contains(ch)) {
                set.remove(s.charAt(start));
                start++;
            }
            
            // Now that the duplicate is gone, we can add the new character
            set.add(ch);
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
class Solution {
        public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while(!isAlphaNumeric(s.charAt(left)) && left < right) {
                left++;
            }
            while(!isAlphaNumeric(s.charAt(right)) && left < right) {
                right--;
            }
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}

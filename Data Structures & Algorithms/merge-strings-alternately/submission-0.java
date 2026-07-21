class Solution {
    public String mergeAlternately(String word1, String word2) {
        int pt1 = 0;
        int pt2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        while (pt1 < len1 || pt2 < len2) {
            if (pt1<len1) {
                sb.append(word1.charAt(pt1));
                pt1++;
            }
            if (pt2<len2) {
                sb.append(word2.charAt(pt2));
                pt2++;
            }
        }
        return sb.toString();
    }
}
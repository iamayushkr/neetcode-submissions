class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        if (s.length() == t.length()) {
            for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (m1.containsKey(ch)) {
                m1.put(ch, m1.get(ch)+1);
            } else {
                m1.put(ch, 1);
            }
            }
            for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (m2.containsKey(ch)) {
                m2.put(ch, m2.get(ch)+1);
            } else {
                m2.put(ch, 1);
            }
            }
            return m1.equals(m2);
        }
        else {
            return false;
        }
    }
}

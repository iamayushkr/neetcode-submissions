class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key , k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}

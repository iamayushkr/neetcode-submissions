public class Solution {
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // Append length, then '#', then the actual string
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < s.length()) {
            int j = i;
            // Move j forward until we find the '#' delimiter
            while (s.charAt(j) != '#') {
                j++;
            }
            
            // Extract the length number sitting between i and j
            int length = Integer.parseInt(s.substring(i, j));
            
            // The actual word starts right after the '#' and goes for 'length' characters
            int wordStart = j + 1;
            int wordEnd = wordStart + length;
            
            res.add(s.substring(wordStart, wordEnd));
            
            // Move i forward to the start of the next encoded block
            i = wordEnd;
        }
        
        return res;
    }
}

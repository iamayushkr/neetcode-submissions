class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Build Frequency Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create Bucket Array where index = frequency
        // Array size is nums.length + 1 because frequency can range from 0 to N
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Place keys into their frequency bucket
        for (int key : map.keySet()) {
            int freq = map.get(key);
            buckets[freq].add(key);
        }

        // Step 3: Read buckets backwards (from highest frequency to lowest)
        int[] result = new int[k];
        int index = 0;
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) break;
            }
        }
        return result;
    }
}
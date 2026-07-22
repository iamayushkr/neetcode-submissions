class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1<index2) {
            int sum = numbers[index1]+numbers[index2];
            if (sum==target) {
                break;
            } else if (sum>target) {
                index2--;
            } else if (sum<target) {
                index1++;
            } 
        }
        return new int[]{index1+1, index2+1};
    }
}

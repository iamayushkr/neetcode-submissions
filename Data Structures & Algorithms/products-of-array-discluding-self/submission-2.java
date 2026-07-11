class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];

        output[0] = 1;
        for(int i = 1; i < len ; i++) {
            output[i] = nums[i-1] * output[i-1];
        }

        int rightProd = 1;
        for(int j = len-1; j>=0; j--) {
            output[j] = output[j] * rightProd;
            rightProd = rightProd * nums[j];
        }

        return output;
    }
}
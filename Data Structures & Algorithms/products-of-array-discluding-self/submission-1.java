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

// 1 2 4 6
// 1 1 2 8
// 48 24 6 1
// 48 24 12 8

// 2 3 4 5
// 1 2 6 24
// R = 1 1 2 6 24 R = 1*5
// R = 5 1 2 30 24 R = 5*4
// R = 20 1 40 30 24 R = 20*3
// R = 60 60 40 30 24 R = 60*2
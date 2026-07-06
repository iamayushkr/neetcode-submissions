class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        // Step 1: Build a Max Heap from the array
        // We start from the last non-leaf node (n / 2 - 1) and go up to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // The largest element is currently at the root (index 0).
            // Swap it with the last element of the current heap.
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            // The heap size is reduced by 1. 
            // Call heapify on the root to restore the Max Heap property.
            heapify(nums, i, 0);
        }

        return nums;
    }

    // A helper method to maintain the Max Heap property
    private void heapify(int[] nums, int heapSize, int rootIndex) {
        int largest = rootIndex; // Assume the root is the largest
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        // If the left child exists and is greater than the root
        if (leftChild < heapSize && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        // If the right child exists and is greater than the largest so far
        if (rightChild < heapSize && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        // If the largest is not the root, swap them and recursively heapify the affected subtree
        if (largest != rootIndex) {
            int swap = nums[rootIndex];
            nums[rootIndex] = nums[largest];
            nums[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(nums, heapSize, largest);
        }
    }
}
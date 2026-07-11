class NumMatrix {
    // Our 2D Prefix Sum array
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // We add +1 to dimensions to create a padding of 0s on the top and left
        prefix = new int[rows + 1][cols + 1];

        // Build the prefix sum matrix
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Formula: Current + Top + Left - Overlap
                prefix[r + 1][c + 1] = matrix[r][c] 
                                     + prefix[r][c + 1] 
                                     + prefix[r + 1][c] 
                                     - prefix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Shift our target coordinates by +1 to account for the padding
        int r1 = row1 + 1;
        int c1 = col1 + 1;
        int r2 = row2 + 1;
        int c2 = col2 + 1;

        // Formula: Total - Top - Left + Overlap
        return prefix[r2][c2] 
             - prefix[r1 - 1][c2] 
             - prefix[r2][c1 - 1] 
             + prefix[r1 - 1][c1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
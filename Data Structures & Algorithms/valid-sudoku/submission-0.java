class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Create an array of 9 HashSets for rows, columns, and 3x3 sub-boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        
        // Check every cell in the 9x9 grid
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                
                // If the cell is empty, skip it
                if (val == '.') {
                    continue;
                }
                
                // Math trick to find which of the 9 sub-boxes we are in (0-8)
                int boxIndex = (r / 3) * 3 + (c / 3);
                
                // If the value is already in the row, col, or box HashSet, it's invalid!
                if (rows[r].contains(val) || cols[c].contains(val) || boxes[boxIndex].contains(val)) {
                    return false;
                }
                
                // Otherwise, add the value to the tracking sets
                rows[r].add(val);
                cols[c].add(val);
                boxes[boxIndex].add(val);
            }
        }
        
        // If we checked every cell without finding any duplicates, the board is valid
        return true;
    }
}
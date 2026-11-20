import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                rowMin[r] = Math.min(rowMin[r], matrix[r][c]);
                colMax[c] = Math.max(colMax[c], matrix[r][c]);
            }
        }
        
        // Step 2: Check which elements match both their row min and col max
        List<Integer> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == rowMin[r] && matrix[r][c] == colMax[c]) {
                    result.add(matrix[r][c]);
                }
            }
        }
        
        return result;
    }
}

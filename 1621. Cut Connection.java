public class Solution {
    /**
     * @param matrix: 
     * @param x: 
     * @param y: 
     * @return: return the matrix
     */
    public int[][] removeOne(int[][] matrix, int x, int y) {
        for(int down=x;down<matrix.length;down++){
            matrix[down][y]=0;
        }
        return matrix;
    }
}

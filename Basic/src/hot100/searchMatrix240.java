package hot100;
// 选一个合适的起点
public class searchMatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) //注意剪枝
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0,col = n-1;//[0，n)前闭后开
        while(row<m && col >=0){
            if(matrix[row][col]==target)
                return true;
            else if (matrix[row][col]>target) {
                col--;
            }
            else
                row++;
        }
        return false;
    }
}

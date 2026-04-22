package hot100;
// 拉直变成一维
public class searchMatrix074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m*n;
        while(left < right){
            int mid = left+((right-left)>>1);
            int row = mid/n; //什么是行什么是列
            int col = mid%n;
            if(matrix[row][col]==target)
                return true;
            if(matrix[row][col]>target)
                right = mid;
            else
                left = mid+1;
        }
        return false;
    }
}

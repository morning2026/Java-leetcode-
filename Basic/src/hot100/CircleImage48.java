package hot100;
//再次证明旋转的本质是反转
public class CircleImage48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m/2;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]^=matrix[n-i-1][j];
                matrix[n-i-1][j]^=matrix[i][j];
                matrix[i][j]^=matrix[n-i-1][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                matrix[i][j]^=matrix[j][i];
                matrix[j][i]^=matrix[i][j];
                matrix[i][j]^=matrix[j][i];
            }
        }
    }
}

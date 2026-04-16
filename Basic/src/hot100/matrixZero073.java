package hot100;
//用第0行和第0列做哈希，还可以使用一个变量，但太复杂，空间上没有明显的提升，不学
public class matrixZero073 {
    public void setZeroes(int[][] matrix) {
        int row0=1,col0=1;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    if(i==0) row0 = 0;
                    if(j==0) col0 = 0;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        for(int i=1;i<m;i++){
            if(matrix[i][0]==0)
                for(int j=1;j<n;j++)//具体对应什么
                    matrix[i][j] = 0;
        }
        for(int j=1;j<n;j++){
            if(matrix[0][j]==0)
                for(int i=0;i<m;i++)
                    matrix[i][j] = 0;
        }
        if(col0==0)
            for(int i=0;i<m;i++)
                matrix[i][0] = 0;
        if(row0==0)
            for(int j=0;j<n;j++)
                matrix[0][j] = 0;
    }
    public static void main(String[] args){
        matrixZero073 m =new matrixZero073();
        int [][] matrix = new int[][]{{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
        m.setZeroes(matrix);
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println('\n');
        }
    }
}

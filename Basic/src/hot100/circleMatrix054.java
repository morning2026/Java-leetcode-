package hot100;
import java.util.*;
// 模拟，注意怎么控制旋转。四条边，不需要count
public class circleMatrix054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0,top = 0;
        int bottom = matrix.length-1; //注意还是用闭区间
        int right = matrix[0].length-1;
        int maxx = (bottom+1)*(right+1);
        List ans = new ArrayList();
        while(left<=right || top<=bottom){ //左闭右闭，好好比对,可以有一个等于，都等就是中心
            for(int j=left;j<=right;j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            if(ans.size()>=maxx) break;
            for(int i=top;i<=bottom;i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(ans.size()>=maxx) break;
            for(int j=right;j>=left;j--) {
                ans.add(matrix[bottom][j]);
            }
            bottom--;
            if(ans.size()>=maxx) break;
            for(int i=bottom;i>=top;i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if(ans.size()>=maxx) break;
        }
        return ans;
    }
    public static void main(String[] args){
        circleMatrix054 m = new circleMatrix054();
        System.out.println(m.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toString());
    }
}

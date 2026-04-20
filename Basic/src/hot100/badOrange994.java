package hot100;

import java.util.LinkedList;
import java.util.Queue;

//多源bfs
public class badOrange994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0,count = 0;
        boolean flag;
        Queue<int[]>q = new LinkedList<>();
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){ // i-m j-n
                if(grid[i][j]==2)
                    q.offer(new int[]{i,j});
                if(grid[i][j]==1) // 新鲜橘子是1
                    fresh++;
            }
        while(!q.isEmpty()) {
            flag = false; //有扩散才有时间
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] cur = q.poll(); // 注意怎么取出来
                int x = cur[0];
                int y = cur[1];
                for (int i = 0; i < 4; i++) {//只需要一层
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        // 保证符合要求,注意什么时候去掉新橘子，什么时候加时间
                        grid[nx][ny] = 2;
                        fresh--;
                        q.offer(new int[]{nx, ny});
                        flag = true;
                    }
                }
            }
            if(flag)
                count++;
        }
        return fresh>0?-1:count;
    }
}

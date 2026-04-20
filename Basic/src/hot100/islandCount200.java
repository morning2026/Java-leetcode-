package hot100;
// 经典搜索，多一个数组记录陆地方便剪枝
public class islandCount200 {
    int res;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        res = 0;
        for(int i=0;i<m;i++)
            for (int j=0;j<n;j++)
                if(grid[i][j] == '1'){
                    res++;
                    dfs(grid,i,j);
                }
        return res;
    }
    private void dfs(char[][] grid,int x,int y){
        if(x<0 || x>= grid.length || y<0 || y >= grid[0].length || grid[x][y] == '0') //四面八方
            return;
        grid[x][y] = '0';
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);
        dfs(grid,x+1,y);
        dfs(grid,x,y+1);
    }
}

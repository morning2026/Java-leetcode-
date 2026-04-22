package hot100;
// 注意标记+回溯

public class wordSearch079 {
    int[] dx=new int[]{0,0,1,-1};
    int[] dy=new int[]{1,-1,0,0};
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(board[i][j]== word.charAt(0) && dfs(board,word,i,j,0)) // 有一个就好
                    return true;

            }
        return false;
    }
    private boolean dfs(char[][] board,String word,int x,int y,int len){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length) // 长度是大于等于
            return false;
        if(board[x][y]!= word.charAt(len)){
            return false;
        }
        if(len == word.length()-1) //一样，长度问题
            return true;
        char temp = board[x][y]; // 回溯
        board[x][y] = '#';
        boolean flag = false;
        for(int i=0;i<4;i++)
            flag = flag || dfs(board,word,x+dx[i],y+dy[i],len+1);
        board[x][y] = temp;
        return flag;
    }
}

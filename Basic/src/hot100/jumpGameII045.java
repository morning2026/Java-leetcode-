package hot100;

public class jumpGameII045 {
    public int jump(int[] nums) {
        int curEnd = 0;
        int maxx = 0;
        int cnt = 0;
        for(int i=0;i<nums.length-1;i++){ //终点不用
            maxx = Math.max(maxx,i+nums[i]);//先算，最远位置更新
            if(i==curEnd) {//到达边界了，准备下一次起跳
                cnt++;
                curEnd = maxx;
            }
        }
        return cnt;
    }
}

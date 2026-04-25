package hot100;

public class buyStock121 {
    public int maxProfit(int[] prices) {
        int minn = prices[0],maxx = Integer.MIN_VALUE;
        for(int i=1;i<prices.length;i++){
            minn = Math.min(prices[i], minn);
            maxx = Math.max(maxx,prices[i]-minn);
        }
        return maxx == Integer.MIN_VALUE ?0:maxx;
    }

}

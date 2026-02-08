import java.util.Scanner;
public class daily1653 {
    public int minimumDeletions(String s) {
        int l = s.length(),bcnt=0;
        int[] dp = new int[l+1];
        for (int i = 1; i <= l; i++) {
           if(s.charAt(i-1)=='a'){
               dp[i]=Math.min(dp[i-1]+1,bcnt);
           }
           else{
               dp[i]=dp[i-1];
               bcnt++;
           }
        }
        return dp[l];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        daily1653 d = new daily1653();
        System.out.println(d.minimumDeletions(s));
    }
}
import java.util.Scanner;
public class sqrt {
    /* 解法一 指数拟合
    public int mySqrt(int x) {

         if(x==0){
             return 0;
         }
         int ans=(int)Math.exp(0.5*Math.log(x));
         return (long) (ans+1)*(ans+1)<=x?ans+1:ans;
    }
    */
    /*解法二 二分查找
    public int mySqrt(int x) {
        if(x==0){
            return 0;
        }
        int l=0,r=x,ans=0,mid;
        while (l<=r){
            mid = (l+r)/2;
            if ( (long) mid * mid <= x ){
                ans = mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }*/
    public int mySqrt(int x) {

        if(x==0){
            return 0;
        }
        double C=x,x0=x,xi;
        while(true){
            xi=0.5*(x0+C/x0);
            if (Math.abs(x0-xi)<1e-7){
                break;
            }
            x0=xi;
        }
        return (int)x0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sqrt s = new sqrt();
        System.out.println(s.mySqrt(x));
    }
}

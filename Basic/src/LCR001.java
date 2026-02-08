import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class LCR001 {
    /*解法一 二分查找
    public int divide(int a, int b) {
        if(a==0){
            return 0;
        }
        if(a==Integer.MIN_VALUE){
            if(b==-1){
                return Integer.MAX_VALUE;
            }
            if(b==1){
                return Integer.MIN_VALUE;
            }
        }
        if(b==Integer.MIN_VALUE){
                return a==Integer.MIN_VALUE?1:0;
            }
        boolean flag=true;
        if(a>0){
            a=-a;
            flag=!flag;
        }
        if(b>0){
            b=-b;
            flag=!flag;
        }
        int l=1,r=Integer.MAX_VALUE,ans=0;
        while(l<=r){
            int mid = l+((r-l)>>1);
            boolean check=quickAdd(b,mid,a);
            if(check){
                ans=mid;
                if(mid==Integer.MAX_VALUE){
                    break;
                }
                l=mid+1;
        }
            else{
                r=mid-1;
            }
        }
        return flag?ans:-ans;
    }
    private boolean quickAdd(int y,int z,int x){
        int res = 0, add = y;
        while (z != 0 ) {
            if ((z & 1) !=0) {
                if (res < x-add) {
                    return false;
                }
                res += add;
            }
            if (z != 1) {
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            z >>= 1;
        }
        return true;
    }*/
    public int divide(int a, int b) {
        if (a == 0) {
            return 0;
        }
        if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                return Integer.MAX_VALUE;
            }
            if (b == 1) {
                return Integer.MIN_VALUE;
            }
        }
        if (b == Integer.MIN_VALUE) {
            return a == Integer.MIN_VALUE ? 1 : 0;
        }
        boolean flag = true;
        if (a > 0) {
            a = -a;
            flag = !flag;
        }
        if (b > 0) {
            b = -b;
            flag = !flag;
        }
        List<Integer> candidates = new ArrayList<Integer>();
        candidates.add(b);
        int index = 0,ans=0;
        while(candidates.get(index) >= a -candidates.get(index)){
            candidates.add(candidates.get(index)+candidates.get(index));
            index++;
        }
        for(int i = candidates.size()-1;i>=0;i--){
            if(a <= candidates.get(i)){
                ans+=(1<<i);
                a-=candidates.get(i);
            }
        }
        return flag ? ans : -ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        LCR001 l = new LCR001();
        System.out.println(l.divide(a, b));
    }
}

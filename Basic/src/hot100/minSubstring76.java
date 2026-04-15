package hot100;

public class minSubstring76 {
    public String minWindow(String s, String t) {
        String ans ="";
        if(s == null || t == null || s.length()<t.length()) return ans; //注意null边界条件
        int[] twindow = new int[128];//只保留一个数组就够了
        int count = 0;
        for(int i = 0;i < t.length();i ++){
            if(twindow[t.charAt(i)]==0) //注意索引是什么
                count++;
            twindow[t.charAt(i)]++;
        }
        int left = 0,min = Integer.MAX_VALUE,mleft =0;
        for(int right = 0;right < s.length();right ++){
            char c = s.charAt(right);
            twindow[c]--;
            if(twindow[c] == 0){
                count--;
            }
            while(count == 0){
                if(right - left + 1 < min){ //固定加一，0-0+1=1
                    min = right - left + 1; // 同样固定+1
                    mleft = left;
                }
                c = s.charAt(left);
                if(twindow[c] == 0){ //大于等于就可以，所以放在前面，一降落到不等线就--
                    count++;
                }
                twindow[c]++;
                left++;
            }
        }
        if(min != Integer.MAX_VALUE)
            ans = s.substring(mleft,mleft + min); //substring左开右闭,只截取一次,最终还有一次++
        return ans;
    }
    public static void main(String args[]){
        minSubstring76 m =new minSubstring76();
        System.out.print(m.minWindow("aa","aa"));
    }
}

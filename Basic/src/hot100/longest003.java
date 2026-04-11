package hot100;

public class longest003 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,res = 0;
        int[] lastindex = new int[128];
        for (int i = 0; i < 128; i++) {
            lastindex[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); //char 是数字 ASCII码128
            if(lastindex[c] > left) {// 当前在窗口中
                left = lastindex[c];
            }
            lastindex[c] = i+1 ;//左边界要移到的地方，必须加1
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new longest003().lengthOfLongestSubstring(s));
    }
}

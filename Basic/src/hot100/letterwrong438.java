package hot100;

import java.util.ArrayList;
import java.util.List;

public class letterwrong438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int lp = p.length();
        int ls = s.length();
        if (ls < lp) {
            return res;
        }
        int[] pCount = new int[26]; //Java 里 int 数组 一旦创建，自动全部填 0
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }
        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != 0) {
                match++;
            }
        }
        int left = 0;//最初没有一个匹配的
        for (int right = 0; right < ls; right++) {
            char c = s.charAt(right);
            if (--pCount[c - 'a'] == 0) {
                match--;
            }
            if (right - left + 1 == lp) {
                if (match == 0) {//基础窗口满足了才能判断
                    res.add(left);
                }
                c = s.charAt(left);//注意是进还是出
                if (pCount[c - 'a']++ == 0) {
                    match++;
                }

                left++;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        letterwrong438 obj = new letterwrong438();
        List<Integer> res = obj.findAnagrams("baa", "aa");
        System.out.println(res);

    }
}

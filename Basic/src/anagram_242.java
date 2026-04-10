import java.util.HashMap;
import java.util.Scanner;
public class anagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        //int[] letters = new int[26];
        HashMap<Character, Integer> letters = new HashMap<>();
        for(char c : s.toCharArray()){
            letters.put(c, letters.getOrDefault(c, 0) + 1); //存回新的次数，有c找c无c找0
        }
        for(char c : t.toCharArray()){
            letters.put(c, letters.getOrDefault(c, 0) - 1);
            if (letters.get(c)<0) {
                return false;
            }
        }
        return true; // 不用再遍历了，确认了长度相同，不可能出现唯一>0的
    }
    public static void main(String[] args) {
        anagram_242 a = new anagram_242();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();// trim()去掉头尾空格、换行，回车
        String s = extractstring(line,0);
        String t = extractstring(line,1);
        //System.out.print(s+" "+t);
        System.out.print(a.isAnagram(s,t));
    }

    private static String extractstring(String a,int index) {
        int start = 0; //记录字符串起始位置
        int count = 0; //记录这是第几个引号
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i)=='"'){
                count++;
                if(count == index*2+1){ //左引号
                    start = i;
                }
                else if(count == index*2+2) return a.substring(start+1,i); // 右引号
            }

        }
        return " "; // 遍历完了都没找到，输出空字符串
    }
}

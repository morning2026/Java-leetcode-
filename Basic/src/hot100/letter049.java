package hot100;

import java.util.*;

public class letter049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        HashMap<String, ArrayList> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String arr1 = String.valueOf(arr);
            //System.out.println(s+" "+arr1+"\n");
            ArrayList list = map.getOrDefault(arr1, new ArrayList<>()); // 找不到返回空的
            list.add(s); //增加新内容
            map.put(arr1, list);
        }
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
        List<List<String>> res = new letter049().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        System.out.println(res);
    }
}

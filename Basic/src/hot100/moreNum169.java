package hot100;
// 摩尔投票法 类似括号
public class moreNum169 {
    public int majorityElement(int[] nums) {
        int count=0,candidate=0;
        for(int num:nums){
            if(count==0)
                candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}

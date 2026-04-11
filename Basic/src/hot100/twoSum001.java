package hot100;
import java.util.HashMap;
import java.util.Scanner;
public class twoSum001 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>(); //分别存数值和索引
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target-nums[i])};
            }
            else{
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        twoSum001 s = new twoSum001();
        int[] res= s.twoSum(nums,target);
        System.out.println(res[0]+" "+res[1]);
    }
}

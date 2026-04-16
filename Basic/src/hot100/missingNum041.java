package hot100;

public class missingNum041 {
    public int firstMissingPositive(int[] nums) {
        int n =nums.length,temp;
        for(int i=0;i<n;i++){
            while(nums[i]>0 && nums[i]<=n && nums[i]!=nums[nums[i]-1]){ //可能自己换自己的时候不准用位运算,位运算会改值导致索引错误
                temp =nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;
    }
    public static void main(String args[]){
        missingNum041 m = new missingNum041();
        System.out.println(m.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}

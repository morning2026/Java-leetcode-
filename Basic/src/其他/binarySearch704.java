package 其他;

public class binarySearch704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length, mid; //左闭右开不用-1
        while(left < right){
            mid = left +( (right - left)>>1); // 减法防止溢出，位运算要再套一层
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                left = mid + 1; // 注意左闭右开
            }
            else
                right = mid;
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = new int []{5};
        int target = 5;
        binarySearch704 b = new binarySearch704();
        System.out.println(b.search(nums,target));
    }
}

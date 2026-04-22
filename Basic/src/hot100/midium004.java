package hot100;
//k-k/2,另外求两次也很巧妙，规避了要分类的情况
//进阶做法 划分数组
public class midium004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        int k1 = (n1 + n2 + 1)>>1; // 因为是取下所以从+1开始
        int k2 = (n1 + n2 + 2)>>1;
        return (getKth(nums1,nums2,0,0,k1) + getKth(nums1,nums2,0,0,k2))/ 2.0;
    }
    private int getKth(int[] nums1, int[] nums2,int i,int j,int k){
        if(i>=nums1.length)  // 越界要等
            return nums2[j+k-1];
        if(j>=nums2.length)
            return nums1[i+k-1];
        if(k==1)
            return Math.min(nums1[i],nums2[j]);
        int mid1 = (i+k/2-1)<nums1.length ? nums1[i+k/2-1]:Integer.MAX_VALUE; //取前k/2个，没有就返回最大值
        int mid2 = (j+k/2-1)<nums2.length ? nums2[j+k/2-1]:Integer.MAX_VALUE; // 全部揪出来
        if(mid1 < mid2){
            return getKth(nums1,nums2,i+k/2,j,k-k/2); //不用-1，前闭后闭
        }
        else
            return getKth(nums1,nums2,i,j+k/2,k-k/2);
    }
}

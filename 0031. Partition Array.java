public class Solution {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        int left=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <k){
                swap(nums, left++, i);
            }
        }
        return left;
    }
    
    public void swap(int[] nums,int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if(nums.length<1){return 0;}
        Arrays.sort(nums);
        int result = 0; //ind of last unique number
        for(int i = 0; i <nums.length;i++){
            if(nums[result] != nums[i]){
                nums[++result] = nums[i];
            }
        }
        return ++result;
    }
}

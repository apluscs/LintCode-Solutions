public class Solution {
    /**
     * @param nums: an array
     * @return: the shortest subarray's length
     */
    public int findUnsortedSubarray(int[] nums) {
        int result = nums.length;   //pretend the whole thing needs to be sorted
        int[] sorted = nums.clone();
        Arrays.sort(sorted);    //for reference
        int start = 0;
        while(start < nums.length){  
            if(nums[start] == sorted[start]) result--;
            else  break;    //to ensure that nums[start] is in its rightful place, we need to sort everything to the right of start
            start++;
        }

        for(int end = nums.length-1;end > start; end--){   //only covers what start did not cover
            if(nums[end]==sorted[end]) result--;
            else break; //to ensure that nums[end] is in its rightful place, we need to sort everything to the left of end
        }
        return result;
    }
}

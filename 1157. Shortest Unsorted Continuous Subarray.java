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
            else  break;    //to ensure that nums[start] is in its rightful place, we need to sort everything to the right of 
            //start
            start++;
        }

        for(int end = nums.length-1;end > start; end--){   //only covers what start did not cover
            if(nums[end]==sorted[end]) result--;
            else break; //to ensure that nums[end] is in its rightful place, we need to sort everything to the left of end
        }
        return result;
    }
    
    public int findUnsortedSubarray2(int[] nums) {   //in a perfectly sorted array, start will = 0, end = N-1 by when running 
        //completes. Otherwise, start tracks last "dip" going left to right; end tracks last "climb" going right to left (both 
        //should not exist if array is sorted)
        int N=nums.length;
        int end =-1;    int start=0;    int max=nums[0];    int min=nums[N-1];
        for(int i=0;i<N;i++){
            if(nums[i]<max) end=i;
            else max = nums[i];
        }
        for(int i=N-1;i>=0;i--){
            if(nums[i]>min) start=i;    
            else min=nums[i];
        }
        return end-start+1;
    }
}

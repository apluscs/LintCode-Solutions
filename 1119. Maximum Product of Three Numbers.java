public class Solution {
    /**
     * @param nums: an integer array
     * @return: the maximum product
     */
    public int maximumProduct(int[] nums) {
        int brick = Integer.MIN_VALUE  , stick = Integer.MIN_VALUE, hay = Integer.MIN_VALUE;    //three highest values
        for(int i=0;i<nums.length;i++){ 
            if(nums[i]>=brick){
                hay = stick;    stick=brick;    brick=nums[i];
            }
            else if(nums[i]>=stick){
                hay=stick;  stick=nums[i];
            }
            else if(nums[i]>=hay) hay=nums[i];
        }
        int dumb=Integer.MAX_VALUE, dumber=Integer.MAX_VALUE;    //two lowest values; considers the possibility of two negatives multiplying to a positive; 
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=dumber){
                dumb=dumber;  dumber=nums[i];
            }
            else if(nums[i]<=dumb) dumb=nums[i];
        }
        return Math.max( brick*stick*hay, dumb*dumber*brick);   
    }
}

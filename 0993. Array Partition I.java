public class Solution {
    /**
     * @param nums: an array
     * @return: the sum of min(ai, bi) for all i from 1 to n
     */
    public int arrayPairSum(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        int result=0;
        for(int i=0;i<nums.length;i+=2){    //to maximize the mins of pairs, pair every "small" number with the number immediately greater than it, so that the magnitude of the large numbers are not "wasted" when being paired with unnecessarily small numbers
            result+=nums[i];
        }
        return result;
    }
    
    private void quicksort(int[] nums, int low, int high){  //full quicksort
        if(low >= high) return;
        int pivot = partition(nums, low, high);
        quicksort(nums, pivot + 1, high);
        quicksort(nums, low, pivot-1);
    }
    
    private int partition(int[] nums, int low, int high){
        int pos = low;  int target = nums[high];
        for(int i =low; i<high; i++){
            if(nums[i] <= target){
                swap(nums, i, pos++);
            }
        }
        swap(nums, high, pos); 
        return pos; //everything to the left of pos is less than nums[pos], everything to the right is greater than nums[pos]
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}

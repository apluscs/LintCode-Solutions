public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List < List < Integer >> threeSum(int[] nums) {
        List < List < Integer >> result = new ArrayList < > ();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //each target is unique
            int target = -nums[i];
            twoSum(nums, i + 1, nums.length - 1, target, result); //searches for 2 numbers greater than nums[i] that make a triple
        }
        return result;
    }

    public void twoSum(int[] nums, int start, int end, int target, List < List < Integer >> result) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List < Integer > trip = new ArrayList < > ();
                trip.add(-target);
                trip.add(nums[start]);
                trip.add(nums[end]);
                result.add(trip);
                start++;
                end--; //tries a new pair
                while (start < end && nums[start] == nums[start - 1]) { //to ensure start and end stay within bounds
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (nums[start] + nums[end] > target) { //twoSum is too big, needs to decrease
                end--;
            } else { //twoSum is too small, need to increase
                start++;
            }
        }
    }
}

public class Solution {
    /*
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        int result = 0;
        while (num != 0) {
            num = num & (num - 1); //eliminates least significant one
            result++;
        }
        return result;
    }
}

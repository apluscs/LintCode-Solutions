/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */
public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int diff = guess(mid);
            if (diff == 0) return mid;
            if (diff == 1) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 404; //just for LOLs
    }
}

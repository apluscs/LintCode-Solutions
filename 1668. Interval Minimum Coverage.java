/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class Solution {
    /**
     * @param a: the array a
     * @return: return the minimal points number
     */
    public int getAns(List < Interval > a) {
        if (a.isEmpty()) return 0;
        Collections.sort(a, (c, b) - > (c.start - b.start));  //sorts ascendingly by first number in interval
        int result = 0;
        int min = a.get(0).start;
        int max = a.get(0).end;
        for (Interval range: a) {
            if (range.start <= max) {
                max = Math.min(range.end, max); //see which endpoint is more restrictive
            } else {
                result++; //new point needed
                min = range.start;
                max = range.end;
            }
        }
        return result + 1;
    }
}

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
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        for(int curr = 0; curr < intervals.size(); curr++){
            int start = intervals.get(curr).start;
            int end = intervals.get(curr).end;
            for(int other = 0; other < intervals.size(); other++){
                int begin = intervals.get(other).start;
                if(curr != other && begin >= start && begin < end){ 
                    return false;
                }
            }
        }
        return true;
    }
}

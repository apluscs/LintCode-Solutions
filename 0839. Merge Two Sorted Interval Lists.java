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
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<>();
        if(list1 == null || list1.size() ==0 || list2 == null || list2.size()==0) return result;
        Interval last = null, curr = null;
        int i = 0, j = 0;
        while(i < list1.size() || j < list2.size()){
            if(i >= list1.size()){
                curr = list2.get(j++);
            }
            else if(j >= list2.size()){
                curr = list1.get(i++);
            }
            else if(list1.get(i).start <= list2.get(j).start){
                curr = list1.get(i++);
            }
            else {
                curr = list2.get(j++);  //always take the interval that starts sooner
            }
            last = merge(curr, last, result);
        }
        // int k = i;
        result.add(last);
        return result;
    }
    
    private Interval merge(Interval curr, Interval last, List<Interval> result){
        if(last == null) return curr;
        if(last.end < curr.start){
            result.add(last);
            return curr;    //last is updated to curr
        }
        last.end = Math.max(last.end, curr.end);    //merges these two
        return last;
    }
}

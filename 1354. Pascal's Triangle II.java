public class Solution {
    /**
     * @param rowIndex: a non-negative index
     * @return: the kth index row of the Pascal's triangle
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();  row.add(1);
        for(int r=0;r<rowIndex;r++){
            List<Integer> next = new ArrayList<>() ;    next.add(1);
            for(int i=0;i<row.size()-1;i++){    //doesn't hit last item
                next.add(row.get(i) +row.get(i+1));
            }
            next.add(1);    //every row starts and ends with 1
            row=next;
        }
        return row;
    }
}

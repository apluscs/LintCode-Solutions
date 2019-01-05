public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        dfs(result, 1, 0, "(", n);    //2n is final length
        return result;
    }
    
    public void dfs(List<String> result, int open, int close, String curr, int max){
        // System.out.println(curr);
        if(open+close==max*2){
            result.add(curr);
            return;
        }
        if(open<max){
            dfs(result, open+1, close, curr+"(",max);
        }
        if(open>close){
            dfs(result, open, close+1, curr+")",max);
        }
    }
}

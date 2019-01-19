public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        char[] str = A.toCharArray();
        char[] ttr = B.toCharArray();
        int blen = B.length();
        int[] curr = new int[blen + 1];
        int result = 0;
        for (int a = 0; a < A.length(); a++) { //compare each char of A
            int[] next = new int[blen + 1];
            for (int b = 0; b < blen; b++) { //with each char of B
                if (str[a] == ttr[b]) {
                    next[b + 1] = curr[b] + 1; //found a match, curr[b] is continuous substring 1 before curr-a and 1 before curr-b
                } else {
                    next[b + 1] = 0;
                }
                result = Math.max(result, next[b + 1]);
            }
            curr = next;
        }
        return result;
    }
}

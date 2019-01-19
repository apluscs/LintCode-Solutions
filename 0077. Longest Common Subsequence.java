public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        char[] str = A.toCharArray();
        char[] ttr = B.toCharArray();
        int[] curr = new int[B.length() + 1];
        for (int a = 0; a < A.length(); a++) { //compare each char of A
            int[] next = new int[B.length() + 1];
            for (int b = 0; b < B.length(); b++) { //with each char of B
                if (str[a] == ttr[b]) {
                    next[b + 1] = curr[b] + 1; //found a match
                } else {
                    next[b + 1] = Math.max(curr[b + 1], next[b]); //if A only spanned from 0 to a and B spanned from 0 to b, next[b+1] tracks LCS, either inherited from a shorter B or a shorter A
                }
            }
            curr = next;
        }
        return curr[B.length()];
    }
}

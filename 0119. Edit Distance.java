public class Solution {
    /**
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String A, String B) {
        int blen = B.length();
        char[] str = A.toCharArray();
        char[] ttr = B.toCharArray();
        int[] curr = new int[blen + 1];

        for (int b = 1; b <= blen; b++) {
            curr[b] = b; //edit distance from "" to that portion of B is b
        }
        for (int a = 0; a < A.length(); a++) {
            // System.out.println(Arrays.toString(curr));
            int[] next = new int[blen + 1];
            next[0] = a + 1; //distance from "" to that part of A
            for (int b = 0; b < blen; b++) {
                if (str[a] == ttr[b]) {
                    next[b + 1] = curr[b];
                } else {
                    next[b + 1] = Math.min(curr[b + 1], curr[b]); //curr[b] represents a replacement
                    next[b + 1] = Math.min(next[b + 1], next[b]) + 1; //curr[b+1] represnts deletion(last char in A) and next[b] represents insertion(next char in B)
                }
            }
            curr = next;
        }
        return curr[blen];
    }
}

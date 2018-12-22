public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int[] visited = new int[180];
        char[] word = str.toCharArray();
        for(char c : word){
            visited[c]++;
        }
        for(char c : word){
            if(visited[c] == 1){    //only one occurence
                return c;
            }
        }
        return 'N';
    }
}

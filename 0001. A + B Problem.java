public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: The sum of a and b 
     */
    public int aplusb(int a, int b) {
        int common = a & b;
        while(b != 0){
            common = a & b;
            a = a ^ b;  //individual parts
            b = common << 1;    //"carry over what can't fit"
        }
        return a;
    }
}   

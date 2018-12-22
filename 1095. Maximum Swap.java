public class Solution {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for(int i = 0; i < digits.length - 1; i++){ //in order of importance of digits
            char curr = digits[i];
            int maxInd = i;
            for(int j = i + 1; j < digits.length; j++){
                if(digits[j] >= digits[maxInd]){    //include the "or equal to" part so that the lesser value (the one up front) gets moved as far back as possible. It considers the case of there being 2+ occurences of digits[maxInd]
                    maxInd = j;
                }
            }
            if(curr < digits[maxInd]){
                digits[i] = digits[maxInd];
                digits[maxInd] = curr;
                break;
            }
        }
        int result = 0;
        for(int i = 0; i < digits.length; i++){
            result *= 10;
            result += digits[i] - '0';
        }
        return result;
    }
}

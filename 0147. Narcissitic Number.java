public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        int min = pow(10, n - 1);
        int max = min * 10;
        List<Integer> result = new ArrayList<>();
        if(n == 1){
            result.add(0);
        }
        for(int i = min; i < max; i++){
            if(narcissistic(i)){
                result.add(i);
            }
        }
        return result;
    }
    
    public boolean narcissistic(int num){
        int n = num;
        int length = (n + "").length();
        int sum = 0;
        while(n > 0){
            sum += pow(n % 10, length);
            n /= 10;
        }
        return sum == num;
    }
    
    public int pow(int base, int power){
        int result = base;
        for(int i = 1; i < power; i++){
            result *= base;
        }
        return result;
    }
}

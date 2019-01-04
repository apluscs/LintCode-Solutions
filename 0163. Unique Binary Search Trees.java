public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        if(n<2) return 1;
        int[] ways=new int[n+1];
        ways[0]=1;
        ways[1]=1;  //exactly one way to prepare 0 nodes, one way to prepare 1 node
        for(int i=2;i<=n;i++){  //represents which node to use as root. All values less than i lay to the left, all values greater lay to the right
            int sum=0;
            for(int left=0;left<i;left++){  
                sum+=ways[left]*ways[i-left-1];   //#ways to prepare left side * #ways to prepare right side
            }
            ways[i]=sum;
        }
        return ways[n];
    }
}

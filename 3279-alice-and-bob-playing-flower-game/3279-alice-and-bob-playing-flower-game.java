class Solution {
    public long flowerGame(int n, int m) {
        long Ocf=(n+1)/2;
        long Ecf=m/2;
        long Ecs=n/2;
        long Ocs=(m+1)/2;
        long ans=(Ocf*Ecf)+(Ocs*Ecs);
        return ans;

        
    }
}
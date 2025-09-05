class Solution {
    public boolean isPalindrome(int x) {
       int n=x,rev=0,p=1;
       boolean flag=false;
       if(n>=0)
       {
       while(n!=0)
       {
           int ld=n%10;
           rev=rev*10+ld;
           n/=10;
       }
       if(x==rev)
       flag=true;
       }
       else
       {
        flag=false;
       }
       return(flag);

    }
}
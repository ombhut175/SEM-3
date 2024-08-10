package RECURSION;

public class Recursion {
    public static void main(String[] args) {
        Recursion a = new Recursion();
//        int result= a.power2(2,3);\
//        a.multiple(12,5);
        System.out.println(a.euclidAlgo(24,15));
    }
    int fact(int n){
        if(n==1){
            return 1;
        }
        return n*fact(n-1);
    }
    int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    int sum(int n){
        if(n==0){
            return 0;
        }
       return (n%10)+sum(n/10);
    }
    int power(int p,int q){
        if(q==0) return 1;
        return p*power(p,q-1);
    }
    int power2(int p,int q){ //better approach
        if(q==0) return 1;
        int smallPow = power2(p,q/2);
        if(q%2==0) return smallPow*smallPow;
        return p*smallPow*smallPow;
    }
    void multiple(int n,int k){
        if(k==1){
            System.out.println(n*k);
            return;
        }
        multiple(12,k-1);
        System.out.println(n*k);
    }
    int alternateSum(int n){
        if(n<=1){
            return n;
        }
        return (n-1)-n+alternateSum(n-2);
    }
    int gdcLongDivision(int x,int y){
        int i=x,j=y;
        while ((i%j)!=0){
            int ans = i%j;
            i=j;
            j=ans;
        }
        return j;
    }
    int euclidAlgo(int x,int y){
        if (y==0) return x;
        return euclidAlgo(y,x%y);
    }
}

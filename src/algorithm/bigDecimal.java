package algorithm;

import java.math.BigDecimal;

public class bigDecimal {
    public static void main(String[] args) {
        bigData(6.7592,9);
    }
    public static void bigData(double x, int n) {
        // write your code here
        java.math.BigDecimal bx = new java.math.BigDecimal(x);
        System.out.println(myPow(bx,n));


    }
    public static java.math.BigDecimal myPow(java.math.BigDecimal bx, int n){
        if(n==0){
            return new java.math.BigDecimal(1).stripTrailingZeros();
        }
        if(n%2==0){
            return myPow(bx.multiply(bx),n/2).stripTrailingZeros();
        }
        else {
            return myPow(bx.multiply(bx),n/2).multiply(bx).stripTrailingZeros();
        }
    }
}

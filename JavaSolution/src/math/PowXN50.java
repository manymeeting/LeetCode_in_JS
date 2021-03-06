package math;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).

 Example 1:

 Input: 2.00000, 10
 Output: 1024.00000
 Example 2:

 Input: 2.10000, 3
 Output: 9.26100
 Example 3:

 Input: 2.00000, -2
 Output: 0.25000
 Explanation: 2-2 = 1/22 = 1/4 = 0.25
 Note:

 -100.0 < x < 100.0
 n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

// 一个个乘会超时，用递归+二分法思想，减少乘法执行的次数，比如2^10 -> 4^5
// 注意int到long的转换（参数会超过int范围）

public class PowXN50 {
    public double myPow(double x, int n) {
        long longN = n;
        return shadowMyPow(x, longN);

    }

    private double shadowMyPow(double x, long n) {
        if(n == 0) {
            return 1;
        }
        if(n < 0) { // 注意负指数的处理（转化为分数^正指数）
            n = -n;
            x = 1 / x;
        }
        return n % 2 == 0 ? shadowMyPow(x * x, n / 2) : x * shadowMyPow(x * x, n / 2);
    }
}

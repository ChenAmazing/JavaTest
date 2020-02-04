package algorithm;

public class TestTwo {
    public static void main(String[] args) {
        System.out.println(digitCounts(6954, 1));
        System.out.println(DigitCounts(1, 6954));
    }

    public static int digitCounts(int n, int k) {
        // write your code
        int i = n / 10;
        int j = n % 10;
        int start = 10;//
        int start1 = 1;//
        int sum1 = 0;
        if (n < 10) {
            if (n >= k) {
                return 1;
            }
        } else {
            while (i > 0) {
                int start2 = 1;
                if (j > k) {
                    sum1 += start / 10;
                } else if (j == k) {

                }
                while (start1 / 10 > 0) {
                    // start1 = start/10;
                    sum1 += start1 * (j - 1) * start2;
                    start2 *= 10;
                    start1 = start1 / 10;
                }
                j = i % 10;
                i = i / 10;
                start = start * 10;
                start1 = start / 10;
            }
            return sum1;
        }
        return 0;
    }

    public static int DigitCounts(int k, int n) {

        // write your code here
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num / 10 != 0) {
                if (num % 10 == k) {
                    sum++;
                }
                num = num / 10;
            }
            if (num == k)
                sum++;
        }
        return sum;
    }
}

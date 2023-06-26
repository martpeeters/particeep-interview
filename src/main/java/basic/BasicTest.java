package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use
 * Math.pow for power method
 */
public class BasicTest {

    /**
     * return i ^ n for positive Integer, None otherwise
     * alse return None in case of errors
     */
    public static Option<Integer> power(Integer i, Integer n) {
        if (i == null || n == null || n < 0) {
            return Option.none();
        } else if (n == 0) {
            return Option.some(1);
        } else {
            int result = 1;

            while (n > 0) {
                if (n % 2 != 0) {
                    if (isMultiplicationOverflow(result, i)) {
                        return Option.none(); // Overflow detected
                    }
                    result *= i;
                }

                if (isMultiplicationOverflow(i, i)) {
                    return Option.none(); // Overflow detected
                }

                i *= i;
                n /= 2;
            }

            return Option.some(result);
        }
    }

    private static boolean isMultiplicationOverflow(int a, int b) {
        if (a > 0 && b > 0) {
            return a > Integer.MAX_VALUE / b;
        } else if (a < 0 && b < 0) {
            return a < Integer.MAX_VALUE / b;
        } else {
            return false;
        }
    }
}

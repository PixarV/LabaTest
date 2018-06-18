package first;

import java.util.stream.IntStream;

class SmallMathUtilSet{
    static int factorial(int num) {
        return IntStream.range(1, num+1)
                .reduce(1, (a, b) -> a * b);
    }

    static double mul(double arg1, double arg2) {
        return arg1*arg2;
    }

    static double div(double arg1, double arg2) {
        return arg1/arg2;
    }
}
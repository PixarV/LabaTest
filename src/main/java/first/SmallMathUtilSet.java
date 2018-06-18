package first;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

@UtilityClass
class SmallMathUtilSet{
    int factorial(int num) {
        if (num < 0) throw new IllegalArgumentException();
        return IntStream.range(1, num+1)
                .reduce(1, (a, b) -> a * b);
    }

    double mul(double arg1, double arg2) {
        return arg1*arg2;
    }

    double div(double arg1, double arg2) {
        return arg1/arg2;
    }
}

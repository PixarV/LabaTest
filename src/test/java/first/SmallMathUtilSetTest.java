package first;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;


class SmallMathUtilSetTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/first.csv")
    void factorial(int num, int result) {
        int temp = SmallMathUtilSet.factorial(num);
        assertThat(temp, is(result));
    }

    @Test
    @DisplayName("factorial with neg num")
    void factorialThrowsExceptionWithNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> SmallMathUtilSet.factorial(-1));
    }

    @Test
    void mul() {
        double temp = SmallMathUtilSet.mul(5, 6);
        assertThat(temp, is(30.0));
    }

    @Test
    void div() {
        double temp = SmallMathUtilSet.div(30, 6);
        assertThat(temp, is(5.0));
    }

    @Test
    @Disabled
    @DisplayName("div by 0.0")
    void divWithZeroes() {
        assertThat(SmallMathUtilSet.div(5, 0), is(Double.POSITIVE_INFINITY));
        assertThat(SmallMathUtilSet.div(0, 0), is(Double.NaN));
    }
}
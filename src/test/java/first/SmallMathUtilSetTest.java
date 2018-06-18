package first;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class SmallMathUtilSetTest {

    @ParameterizedTest(name = "num={0}, result={1}")
    @CsvFileSource(resources = "/first.csv")
    void factorial(int num, int result) {
        int temp = SmallMathUtilSet.factorial(num);
        assertThat(temp, is(result));
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
}
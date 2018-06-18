package first;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


class SmallMathUtilSetTest {

    @Test
    void factorial() {
        int temp = SmallMathUtilSet.factorial(5);
        assertThat(temp, is(120));
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
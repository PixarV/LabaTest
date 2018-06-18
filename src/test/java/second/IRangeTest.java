package second;

import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@FieldDefaults(level = PRIVATE, makeFinal = true)
class IRangeTest {

    static long LOWER = 10;
    static long UPPER = 42;
    static long IN = 25;
    static long OUT = 7;

    static IRange range = new Range(LOWER, UPPER);


    @Test
    @DisplayName("upper < lower")
    void createWithIllegalArgs() {
        assertThrows(IllegalArgumentException.class, () -> new Range(UPPER, LOWER));
    }


    @Test
    void isBefore() {
        IRange otherRange = new Range(LOWER-5, LOWER-1);
        assertThat(range.isBefore(otherRange), is(true));
    }

    @Test
    void isAfter() {
        IRange otherRange = new Range(UPPER+1, UPPER+5);
        assertThat(range.isAfter(otherRange), is(true));
    }

    @Test
    @DisplayName("is concurrent")
    void isConcurrent() {
        IRange otherRange = new Range(LOWER, UPPER);
        assertThat(range.isConcurrent(otherRange), is(true));
    }


    @Test
    @DisplayName("isn't concurrent")
    void isNotConcurrent() {
        IRange otherRange = new Range(LOWER-3, UPPER);
        assertThat(range.isConcurrent(otherRange), is(false));
    }

    @Test
    void getLowerBound() {
        assertThat(range.getLowerBound(), is(LOWER));
    }

    @Test
    void getUpperBound() {
        assertThat(range.getUpperBound(), is(UPPER));
    }

    @Test
    @DisplayName("contains value")
    void containsIn() {
        assertThat(range.contains(IN), is(true));
    }

    @Test
    @DisplayName("doesn't contain value")
    void containsOut() {
        assertThat(range.contains(OUT), is(false));
    }

    @Test
    void asList() {
        List<Long> fromRange = range.asList();
        int size = fromRange.size();
        assertEquals(size, UPPER-LOWER+1);
        assertThat(fromRange.get(0), is(LOWER));
        assertThat(fromRange.get(size-1), is(UPPER));
    }

    @Test
    void asIterator() {
        Iterator<Long> iterator = range.asIterator();
        List<Long> fromRange = range.asList();
        for (Long l : fromRange)
            assertThat(iterator.next(), is(l));
    }
}
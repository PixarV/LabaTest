package tdd.second;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@FieldDefaults(level = PRIVATE)
public class Range implements IRange {
    long lowerBound;
    long upperBound;

    Range(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) throw new IllegalArgumentException();
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean isBefore(IRange otherRange) {
        return otherRange.getUpperBound() < lowerBound;
    }

    @Override
    public boolean isAfter(IRange otherRange) {
        return otherRange.getLowerBound() > upperBound;
    }

    @Override
    public boolean isConcurrent(IRange otherRange) {
        return otherRange.getUpperBound() == upperBound &&
                otherRange.getLowerBound() == lowerBound;
    }


    @Override
    public boolean contains(long value) {
        return lowerBound <= value &&
                upperBound >= value;
    }

    @Override
    public List<Long> asList() {
        return LongStream.range(lowerBound, upperBound+1)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Long> asIterator() {
        return asList().iterator();
    }
}

package second;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Iterator;
import java.util.List;

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
        return false;
    }

    @Override
    public boolean isAfter(IRange otherRange) {
        return false;
    }

    @Override
    public boolean isConcurrent(IRange otherRange) {
        return false;
    }


    @Override
    public boolean contains(long value) {
        return false;
    }

    @Override
    public List<Long> asList() {
        return null;
    }

    @Override
    public Iterator<Long> asIterator() {
        return null;
    }
}

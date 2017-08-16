package eu.fuss4j.rang;

import static java.lang.Integer.compare;

/**
 * Immutable range to locate the subsequence of a character sequence that exactly matches a pattern.
 *
 * @author Octavian Theodor NITA (https://github.com/octavian-nita/)
 * @version 1.0, Aug 9, 2017
 */
public final class Range implements Comparable<Range> {

    /**
     * Range start index, inclusive.
     */
    public final int start;

    /**
     * Range end index, exclusive.
     */
    public final int end;

    /**
     * @param start the index within a char sequence where a number of characters match a pattern; inclusive
     * @param end   the index where the matching ends; exclusive
     * @throws IndexOutOfBoundsException if {@code start} is negative or greater than or equal to {@code end}
     */
    public Range(int start, int end) {
        if (start < 0) {
            throw new IndexOutOfBoundsException("Start index out of range: " + start);
        }
        if (start >= end) {
            throw new IndexOutOfBoundsException("End index lower than or equal to start index: " + end);
        }
        this.start = start;
        this.end = end;
    }

    public int length() { return end - start; }

    public CharSequence subsequence(CharSequence charSequence) {
        return charSequence == null ? null : charSequence.subSequence(start, end);
    }

    @Override
    public boolean equals(Object o) {
        return this == o ||
               o != null && getClass() == o.getClass() && start == ((Range) o).start && end == ((Range) o).end;
    }

    @Override
    public int compareTo(Range range) {
        final int cmpStart = compare(start, range.start);
        return cmpStart == 0 ? compare(end, range.end) : cmpStart;
    }

    @Override
    public int hashCode() { return (17 * 37 + start) * 37 + end; }

    @Override
    public String toString() { return "r(" + start + "..." + end + ")"; }
}

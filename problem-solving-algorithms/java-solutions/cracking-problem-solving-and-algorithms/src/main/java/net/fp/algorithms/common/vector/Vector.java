package net.fp.algorithms.common.vector;

/**
 */
public interface Vector<T extends Number> {


    boolean equals(Object o);


    Number getValue(int index);


    int hashCode();


    int length();

    double magnitude();

    void set(int index, Number value);
}
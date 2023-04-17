package net.fp.algorithms.common.vector;

/**
 */
public interface DoubleVector extends Vector<Double> {


    double add(int index, double delta);


    double get(int index);

    Double getValue(int index);

    void set(int index, double value);

    double[] toArray();
}
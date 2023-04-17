package net.fp.algorithms.common.matrix;

import java.util.function.BiFunction;

import net.fp.algorithms.common.vector.DoubleVector;

/**
 */
public interface Matrix {

    double get(int row, int col);

    double[] getColumn(int column);

    double[] getRow(int row);

    DoubleVector getRowVector(int row);

    int columns();

    double[][] toDenseArray();

    int rows();

    void set(int row, int col, double val);

    void setColumn(int column, double[] values);

    void setColumn(int column, DoubleVector values);

    void setRow(int row, double[] values);

    void setRow(int row, DoubleVector values);
    
}

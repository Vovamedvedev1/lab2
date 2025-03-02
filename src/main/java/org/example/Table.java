package org.example;

public class Table {
    private int rows = 0;
    private  int cols = 0;
    private double[][] matrix = null;

    public Table(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = 0;
    }

    public double getValue(int row, int col) {
        return matrix[row][col];
    }

    public void setValue(int row, int col, double value) {
        matrix[row][col] = value;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]);
                if (j < cols - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public double average() {
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }
        return sum / (rows * cols);
    }

    private void getDecomposition(double[][] L, double[][] U, int[][] p, int[] count_permutation) throws Exception {
        if (this.rows != this.cols)
            throw new Exception("Table show rows = cols");
        double[][] a = new double[rows][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                a[i][j] = (double)matrix[i][j];
                p[i][j] = (i == j) ? 1 : 0;
            }
        }
        count_permutation[0] = 0;
        int leader_index;
        double max_value;
        for (int i = 0; i < rows; i++) {
            leader_index = i;
            max_value = (double)a[i][i];
            for (int k = i + 1; k < rows; k++) {
                if (Math.abs(a[k][i]) > max_value) {
                    max_value = Math.abs(a[k][i]);
                    leader_index = k;
                }
            }
            if (Math.abs(a[leader_index][i]) < Math.pow(10, -15))
                throw new Exception("The matrix is degenerate");
            double temp[];
            if (i != leader_index) {
                temp = a[i];
                a[i] = a[leader_index];
                a[leader_index] =temp;
                p[i][i] = 0;
                p[leader_index][i] = 1;
                count_permutation[0]++;
            }
            for (int j = i + 1; j <rows; j++) {
                double factor = a[j][i] / a[i][i];
                a[j][i] = factor;
                for (int k = i+1; k < rows; k++)
                    a[j][k] -= factor * a[i][k];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i > j)
                    L[i][j] = a[i][j];
                else if (i == j) {
                    L[i][j] = 1.0;
                    U[i][j] = a[i][j];
                }
                else
                    U[i][j] = a[i][j];
            }
        }
    }

    public double getDeterminant() throws Exception {
        if (this.rows != this.cols)
            throw new Exception("Table show rows = cols");
        double[][] L = new double[rows][rows];
        double[][] U = new double[rows][rows];
        int[][] p = new int[rows][rows];
        int[] count_permutation = new int[1];
        count_permutation[0] = 0;
        getDecomposition(L, U, p, count_permutation);
        double proizv = 1;
        for (int i = 0; i < rows; i++)
            proizv *= U[i][i];
        return Math.pow(-1, count_permutation[0])*proizv;
    }

    public Table calcSLAU(Table other) throws Exception {
        if (this.rows != other.rows)
            throw new Exception("calcSLAYError: A.rows == b.rows");
        double[][] L = new double[rows][rows];
        double[][] U = new double[rows][rows];
        int[][] p = new int[rows][rows];
        int[] count_permutation = new int[1];
        count_permutation[0] = 0;
        getDecomposition(L, U, p, count_permutation);
        double[][] Pb = new double[other.rows][other.cols];
        for (int k = 0; k < other.cols; k++) {
            for (int i = 0; i < other.rows; i++) {
                for (int j = 0; j < other.rows; j++) {
                    if (p[i][j] == 1) {
                        Pb[i][k] = other.matrix[j][k];
                        break;
                    } else
                        Pb[i][j] = 0;
                }
            }
        }
        double[][] y = new double[this.cols][other.cols];
        for (int k = 0; k < other.cols; k++) {
            for (int i = 0; i < other.rows; i++) {
                y[i][k] = Pb[i][k];
                for (int j = 0; j < i; j++)
                    y[i][k] -= L[i][j] * y[j][k];
            }
        }
        Table x = new Table(this.cols, other.cols);
        for (int k = 0; k < other.cols; k++) {
            for (int i = other.rows - 1 ; i >= 0; i--) {
                x.setValue(i, k, y[i][k]);
                double temp = 0;
                for (int j = i+1; j < other.cols; j++) {
                    temp -= U[i][j] * x.getValue(i, k);
                    x.setValue(i, k, temp);
                }
                x.setValue(i, k, 1.0 * x.getValue(i,k)/U[i][i]);
            }
        }
        return x;
    }

    public Table invert() throws Exception {
        double[][] b = new double[rows][rows];
        Table echelon = new Table(rows, rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                if (i == j)
                    echelon.setValue(i, j, 1);
                else
                    echelon.setValue(i, j, 0);
            }
        }
        return this.calcSLAU(echelon);
    }

    public Table calculate(Table other, char operator) throws Exception {
        Table res = null;
        switch (operator) {
            case '+':
                if ((this.rows == other.rows) && (this.cols == other.cols)) {
                    res = new Table(this.rows, this.cols);
                    for (int i = 0; i < this.rows; i++)
                        for (int j = 0; j < this.cols; j++)
                            res.setValue(i, j, this.getValue(i, j) + other.getValue(i, j));
                } else {
                    throw new Exception("When adding up, the number of rows and columns in the matrix must be the same.");
                }
                break;
            case '-':
                if ((this.rows == other.rows) && (this.cols == other.cols)) {
                    res = new Table(this.rows, this.cols);
                    for (int i = 0; i < this.rows; i++)
                        for (int j = 0; j < this.cols; j++)
                            res.setValue(i, j, this.getValue(i, j) - other.getValue(i, j));
                } else {
                    throw new Exception("When subtracting, the number of rows and columns in the matrix must be the same.");
                }
                break;
            case '*':
                double temp = 0;
                if (this.cols == other.rows) {
                    res = new Table(this.rows, other.cols);
                    for (int i = 0; i < this.rows; i++) {
                        for (int j = 0; j < other.cols; j++) {
                            temp = 0;
                            for (int k = 0; k < this.cols; k++)
                                temp += this.getValue(i, k) * other.getValue(k, j);
                            res.setValue(i, j, temp);
                        }
                    }
                } else {
                    throw new Exception("When multiplying, the number of columns of the first matrix must match the number of rows of the second matrix.");
                }
                break;
        }
        return res;
    }
}

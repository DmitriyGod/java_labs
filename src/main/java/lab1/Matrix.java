package lab1;

import java.util.Arrays;


public class Matrix implements IMatrix {

    protected double[] body_list;
    protected final int n;
    protected double determinant;
    protected boolean actual_Determinant_Flag = false;

    public Matrix(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Natural matrix size required");
        }

        this.n = n;
        this.body_list = new double[n*n];
        Arrays.fill(this.body_list, 0, n*n-1, 0);
    }


    public Matrix(int n, double[] body_list) throws IllegalArgumentException {
        if (n < 1) {
            throw new IllegalArgumentException("Natural matrix size required");
        }
        this.n = n;

        this.body_list = body_list;
    }

    @Override
    public double get_Element_By_Index(int x, int y) throws IllegalArgumentException {
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException("wrong index");
        }

        return body_list[(x - 1) * n + (y - 1)];
    }

    @Override
    public void update_Element_By_Index(int x, int y, double value) throws IllegalArgumentException {
        if (x < 1 || y < 1) {
            throw new IllegalArgumentException("wrong index");
        }

        body_list[(x - 1) * n + (y - 1)] = value;
        actual_Determinant_Flag = false;
    }

    @Override
    public double calc_Determinant() {
        if (actual_Determinant_Flag) {
            return determinant;
        }

        double[] triangle_matrix = body_list.clone();
        double det = 1;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n - i; k++) {
                if (triangle_matrix[i * (n + 1) + k * n] != 0) {
                    if (k != 0) {
                        det *= -1;
                    }

                    for (int j = 0; j < n; j++) {
                        double upper = triangle_matrix[i * n + j];
                        double lower = triangle_matrix[(i + k) * n + j];

                        triangle_matrix[i * n + j] = lower;
                        triangle_matrix[(i + k) * n + j] = upper;
                    }
                }
            }
            if (triangle_matrix[i * (n + 1)] == 0) {
                determinant = 0;
                actual_Determinant_Flag = true;
                return determinant;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int k = i + 1; k < n; k++) {

                double koef = triangle_matrix[n * k + i] / triangle_matrix[i * n + i];

                for (int j = 0; j < n; j++) {
                    triangle_matrix[k * n + j] = triangle_matrix[k * n + j] - triangle_matrix[n * i + j] * koef;

                }
            }
        }

        for (int i = 0; i < n; i++) {
            det *= triangle_matrix[i * (n + 1)];
        }
        actual_Determinant_Flag = true;
        return det;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(body_list, matrix.body_list);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(body_list);
    }
}

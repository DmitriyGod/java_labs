package lab1;

public class DiagMatrix extends Matrix {

    public DiagMatrix(double[] diagonal) {
        super(diagonal.length);

        body_list = new double[n*n];
        for (int i = 0; i < n; i++) {
            body_list[i*n + i] = diagonal[i];
        }

    }

    @Override
    public void update_Element_By_Index(int x, int y, double value) throws IllegalArgumentException {
        if (x < 1 || y < 1 || (x != y && value != 0)) {
            throw new IllegalArgumentException("wrong index");
        }

        body_list[(x - 1) * n + (y - 1)] = value;
    }
}

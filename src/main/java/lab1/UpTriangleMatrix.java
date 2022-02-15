package lab1;

public class UpTriangleMatrix extends Matrix{
    public UpTriangleMatrix (int n) {
        super(n);
    }

    @Override
    public void update_Element_By_Index(int x, int y, double value) throws IllegalArgumentException {
        if (x < 1 || y < 1 || (x > y && value != 0)) {
            throw new IllegalArgumentException("wrong index");
        }

        body_list[(x - 1) * n + (y - 1)] = value;
    }

}

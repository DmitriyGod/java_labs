package lab1;

public interface IMatrix {
    double get_Element_By_Index(int x, int y) throws IllegalArgumentException;
    void update_Element_By_Index(int x, int y, double value) throws IllegalArgumentException;
    double calc_Determinant();
}

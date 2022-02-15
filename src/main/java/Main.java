import lab1.DiagMatrix;
import lab1.Matrix;
import lab1.UpTriangleMatrix;


public class Main {
    public static void main(String[] args) throws IllegalArgumentException {


        Matrix matrix = new Matrix(3, new double[] {123,2,3,4,5,6,7,8,9});
        System.out.println(matrix.calc_Determinant());

        Matrix matrix2 = new Matrix(3, new double[] {0,2,3,1,4,5,6,7,8});
        System.out.println(matrix2.calc_Determinant());

        Matrix matrix3 = new Matrix(3, new double[] {0,2,3,0,4,5,6,7,8});
        System.out.println(matrix3.calc_Determinant());

        Matrix matrix4 = new Matrix(3, new double[] {0,2,3,0,4,5,0,7,8});
        System.out.println(matrix4.calc_Determinant());

        DiagMatrix d = new DiagMatrix(new double[] {123,2,3});
        System.out.println(d.calc_Determinant());

        UpTriangleMatrix up = new UpTriangleMatrix(3);
        System.out.println(up.calc_Determinant());
    }
}

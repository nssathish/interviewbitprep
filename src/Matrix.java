import java.util.*;

public class Matrix {
    private ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        System.out.println("m: " + m + " n: " + n);
        int top = 0, bottom = m - 1, right = n - 1, left = 0, dir = 0;
        ArrayList<Integer> result = new ArrayList<>(m * n);
        while (top <= bottom && left <= right) {
            if (dir == 0) { //left to right
                for(int i = left; i <= right; ++i) {
                    result.add(A.get(top).get(i));
                }
                top++;
                dir = 1;
            }
            else if (dir == 1) { //top to bottom
                for (int i = top; i <= bottom; ++i) {
                    result.add(A.get(i).get(right));
                }
                right--;
                dir = 2;
            }
            else if (dir == 2) { //right to left
                for (int i = right; i >= left; --i) {
                    result.add(A.get(bottom).get(i));
                }
                bottom--;
                dir = 3;
            }
            else { //bottom to top
                for (int i = bottom; i >= top; --i) {
                    result.add(A.get(i).get(left));
                }
                left++;
                dir = 0;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>() ;
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1); a.add(2);
        matrix.add(0,a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(3); b.add(4);
        matrix.add(1,b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(5); c.add(6);
        matrix.add(2,c);

        ArrayList<Integer> results = new Matrix().spiralOrder(matrix);
        for (Integer result : results
                ) {
            System.out.print(result);
        }
    }
}
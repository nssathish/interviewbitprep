import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.swap;

public class InsertionSort {

    public ArrayList<Integer> sort(ArrayList<Integer> A) {
        //[17, 1, 9, 2, 8, 3, 4, 13]
        int hole = 1;
        while (hole < A.size()) {
            int value = A.get(hole);
            for (int i = 0; i < hole; ++i) {
                if (A.get(i) > value) {
                    swap(A,i,hole);
                }
            }
            ++hole;
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(17); A.add(1); A.add(9); A.add(2); A.add(8); A.add(3); A.add(4); A.add(13);
        A = new InsertionSort().sort(A);
        for (int item :
                A) {
            System.out.print(item + " ");
        }
    }
}
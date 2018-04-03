import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public List<Integer> sort(List<Integer> A) {

        /*
        split the array into sub arrays
            [17, 1, 9, 2, 8, 3, 4, 13]
           [17,1,9,2]      [8,3,4,13]
        [17,1]   [9,2]   [8,3]  [4,13]
       17  1    9   2   8   3   4    13
         */

        int lengthofA = A.size();
        if (lengthofA < 2) {
            return A;
        }
        int mid = lengthofA / 2;
        List<Integer> left = A.subList(0,mid);
        List<Integer> right = A.subList(mid,lengthofA);
        left = sort(left);
        right = sort(right);
        return merge(left,right);
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> A = new ArrayList<Integer>();
        for (int i = 0,j = 0; i < left.size() || j < right.size();) {
            if (i < left.size() && j < right.size()) {
                int lValue = left.get(i);
                int rValue = right.get(j);
                if (lValue < rValue) {
                    A.add(lValue);
                    i++;
                }
                else {
                    A.add(rValue);
                    j++;
                }
            }
            else if (i < left.size()) {
                int lValue = left.get(i);
                A.add(lValue);
                i++;
            }
            else if (j < right.size()) {
                int rValue = right.get(j);
                A.add(rValue);
                j++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(17); A.add(1); A.add(9); A.add(2); A.add(8); A.add(3); A.add(4); A.add(13);
        List<Integer> result = new MergeSort().sort(A);

        for (int item :
                result) {
            System.out.print(item + " ");
        }
    }
}

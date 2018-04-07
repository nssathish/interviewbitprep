import java.lang.reflect.Array;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Collections.swap;

public class QuickSortStraightForwardCollapsed {

    static List<Integer> sort(List<Integer> A) {
        //[17, 1, 9, 2, 8, 3, 4, 13]
        int pivot = A.size() - 1;
        System.out.println("A.get(pivot) = " + A.get(pivot));
        if (A.size() == 1 || pivot < 0) {
            return A;
        }

        List<Integer> left = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        boolean leftDone = false;
        boolean rightDone = false;
        Set<List<Integer>> partitionedSet = Partition(A,pivot);
        System.out.println(partitionedSet);
        for (List<Integer> item :
                partitionedSet) {
            if (!rightDone) {
                right = item;
                rightDone = true;
            }
            else if (!leftDone) {
                left = item;
                leftDone = true;
            }
        }
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        left = sort(left);
        right = sort(right);
        //A = join(left,right);
        return A;
    }

    private static Set<List<Integer>> Partition(List<Integer> A, int pivot) {
        int pivotValue = A.get(pivot);
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            if (i == pivot) {
                continue;
            }
            if ((A.get(i) > A.get(pivot) && i < pivot) ||
                    (A.get(i) <= A.get(pivot) && i > pivot))  {
                swap(A,i,pivot);
                int prevPivot = pivot;
                pivot = i;
                if (prevPivot > 0) {
                    i = prevPivot - 1;
                }
            }
        }
        List<Integer> left = A.subList(0,pivot);
        List<Integer> right = A.subList(pivot,A.size());
        result.add(left);
        result.add(right);
        System.out.println(result);
        return result;
    }

    private static List<Integer> join(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<Integer>(left.size() + right.size());
        while (left.iterator().hasNext() || right.iterator().hasNext()) {
            if (left.iterator().hasNext()) {
                result.add(left.iterator().next());
            }
            else if (right.iterator().hasNext()) {
                result.add(left.iterator().next());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(17); A.add(1); A.add(9); A.add(2); A.add(8); A.add(3); A.add(4); A.add(13);

        List<Integer> result = sort(A);
        for (int val :
                result) {
            System.out.print(val + " ");
        }
    }
}
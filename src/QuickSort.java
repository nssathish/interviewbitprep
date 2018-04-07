import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static java.util.Collections.swap;

public class QuickSort {
    public static void main(String[] args) {
        //[17, 1, 9, 2, 8, 3, 4, 13]
        ArrayList<Integer> A = new ArrayList<>();
        A.add(17); A.add(1); A.add(9); A.add(2); A.add(8); A.add(3); A.add(4); A.add(13);
        List<Integer> result = sort(A,0,A.size()-1);

        for (Integer aResult : result) {
            System.out.print(aResult + " ");
        }
    }

    private static List<Integer> sort(List<Integer> a, int start, int end) {
        System.out.println("start = " + start);
        System.out.println("end = " + end);
        if (start < end) {
            int partitionIndex = partition(a,start,end);
            a = sort(a,start,partitionIndex-1);
            a = sort(a,partitionIndex+1,end);
        }
        return a;
    }

    private static int partition(List<Integer> a, int start, int end) {
        int pIndex = start;
        int pivotValue = a.get(end);

        for (int i = start; i < end; i++) {
            if (a.get(i) <= pivotValue) {
                swap(a,i,pIndex);
                pIndex++;
            }
        }
        swap(a,pIndex,end);
        return pIndex;
    }
}

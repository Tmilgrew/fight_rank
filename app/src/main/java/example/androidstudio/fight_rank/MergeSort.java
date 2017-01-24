package example.androidstudio.fight_rank;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by thomasmilgrew on 12/18/16.
 */

public class MergeSort {

    public static void mergeSort(ArrayList<Fighter> list){
        ArrayList<Fighter> tmp = new ArrayList<>(list.size());
        mergeSort(list, tmp, 0, list.size()-1);
    }

    private static void mergeSort(ArrayList<Fighter> list, ArrayList<Fighter> tmp, int left, int right){
        if (left<right){
            int center = (left + right) / 2;
            mergeSort(list, tmp, left, center);
            mergeSort(list, tmp, center + 1, right);
            merge(list, tmp, left, center + 1, right);
        }
    }

    private static void merge (ArrayList<Fighter> list, ArrayList<Fighter> tmp, int left, int right, int rightEnd){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;
        FighterComparator fighterComp = new FighterComparator();

        while(left <= leftEnd && right <= rightEnd) {
            if (fighterComp.compare(list.get(left), list.get(right)) <= 0)
                tmp.add(k++, list.get(left++));
            else
                tmp.add(k++, list.get(right++));
        }

        while(left <= leftEnd) {
            tmp.add(k++, list.get(left++));
        }

        while(right <= rightEnd) {
            tmp.add(k++, list.get(right++));
        }

        for(int i=0; i<num; i++, rightEnd--) {
            list.set(rightEnd, tmp.get(rightEnd));
        }
            /*if(list[left].compareTo(list[right]) <= 0){
                tmp[k++] = list[left++]
            }*/

    }
}

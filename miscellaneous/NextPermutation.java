package miscellaneous;

import java.util.Arrays;

public class NextPermutation {

    public void optimal(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        int firstSmallerIndexFromLast = -1;

        int index = n - 2;
        while (index >= 0) {
            if (arr[index] < arr[index + 1]) {
                firstSmallerIndexFromLast = index;
                break;
            } else index--;

        }
        int firstGreaderElementThenIndex = -1;

        index = n - 1;

        while (firstSmallerIndexFromLast != -1) {
            if (arr[index] > arr[firstSmallerIndexFromLast]) {
                firstGreaderElementThenIndex = index;
                break;
            } else index--;
        }

        // swap
        if (firstSmallerIndexFromLast != -1) {
            int temp = arr[firstSmallerIndexFromLast];
            arr[firstSmallerIndexFromLast] = arr[firstGreaderElementThenIndex];
            arr[firstGreaderElementThenIndex] = temp;
        }


        //intead of sorting will be reverse the part
        for (int i = firstSmallerIndexFromLast +1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }



    }

    void main(){
//        add some test cases for upove code
        int[] arr = {1,2,3};
        optimal(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {3,2,1};
        optimal(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {2, 4, 1, 7, 5, 0};
        optimal(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}

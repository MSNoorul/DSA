package Arrays;

import java.util.PriorityQueue;
// topics : heaps
public class MiniumCostRopes {

    public  int usingMinHeap(int[] arr){
        int minCost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : arr) pq.add(num);


        while(pq.size() >1){
            int num1 = pq.remove();
            int num2 = pq.remove();
            int curCost = num1 + num2;
            minCost += curCost;
            pq.add(curCost);
        }


        return  minCost;
    }


    void main(){
        MiniumCostRopes mcr = new MiniumCostRopes();

        // ✅ Test Case 1
        int[] arr1 = {4, 3, 2, 6};
        System.out.println("Test Case 1: " + mcr.usingMinHeap(arr1)); // Expected: 29

        // ✅ Test Case 2
        int[] arr2 = {1, 2, 3};
        System.out.println("Test Case 2: " + mcr.usingMinHeap(arr2)); // Expected: 9

        // ✅ Test Case 3
        int[] arr3 = {5, 5, 5, 5};
        System.out.println("Test Case 3: " + mcr.usingMinHeap(arr3)); // Expected: 40

        // ✅ Test Case 4
        int[] arr4 = {8};
        System.out.println("Test Case 4: " + mcr.usingMinHeap(arr4)); // Expected: 0 (only one rope)

        // ✅ Test Case 5
        int[] arr5 = {7, 9, 4, 5};
        System.out.println("Test Case 5: " + mcr.usingMinHeap(arr5)); // Expected: 50
    }
}

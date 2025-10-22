package Sorting;

import java.util.*;

public class TopKFrequentElements {


    public List<Integer> brute(int[] arr, int k) {
        int n = arr.length;
        // Step 1: Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, List<Integer>> revMap = new HashMap<>();
        //reverse the freq map
        for (Map.Entry<Integer, Integer> f : freq.entrySet()) {
            int key = f.getKey();
            int val = f.getValue();

            if (revMap.containsKey(val)) {
                revMap.get(val).add(key);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                revMap.put(val, list);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = n; i >= 0; i--) {
            if (revMap.containsKey(i)) {
                Collections.sort(revMap.get(i), Collections.reverseOrder());
                result.addAll(revMap.get(i));
                if(result.size() > k) break;
            }
        }

        return result.subList(0, Math.min(k, result.size()));


    }


    // ✅ Test cases inside main
    void main(String[] args) {
        TopKFrequentElements t = new TopKFrequentElements();

        // Test case 1: Basic example
        int[] arr1 = {1, 1, 1, 2, 2, 3};
        System.out.println("Test 1: " + t.brute(arr1, 2));
        // Expected: [1, 2]

        // Test case 2: All unique
        int[] arr2 = {5, 6, 7, 8};
        System.out.println("Test 2: " + t.brute(arr2, 2));
        // Expected: [8, 7] or [7, 6] depending on rule (here by value desc since freq same)

        // Test case 3: Multiple frequencies tie
        int[] arr3 = {4, 4, 5, 5, 6, 6, 7};
        System.out.println("Test 3: " + t.brute(arr3, 3));
        // Expected: [6, 5, 4] (all have freq=2 except 7, choose top by value desc)

        // Test case 4: Single element
        int[] arr4 = {10};
        System.out.println("Test 4: " + t.brute(arr4, 1));
        // Expected: [10]

        // Test case 5: K larger than unique elements
        int[] arr5 = {2, 2, 3, 3, 3};
        System.out.println("Test 5: " + t.brute(arr5, 5));
        // Expected: [3, 2]
    }
}

package Arrays;

import java.util.*;

public class FindKSmallestSumPairs {


    public List<List<Integer>> optimalUsingPriorityQueue(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        List<List<Integer>> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        pq.add(new int[]{0, 0 ,arr1[0] + arr2[0]});
        visited[0][0] = true;
        while (!pq.isEmpty() && k > 0) {
            int[] indexs = pq.poll();
            int i = indexs[0], j = indexs[1];

            result.add(Arrays.asList(arr1[i], arr2[j]));
            k--;
            // add posible next elements to the pq
            if (j+ 1 < m && !visited[i][j + 1]) {
                pq.add(new int[]{i, j + 1 ,arr1[i]+arr2[j+1]});
                visited[i][j + 1] = true;
            }
            if (i+1 < n && !visited[i + 1][j]) {
                pq.add(new int[]{i + 1, j , arr1[i+1]+arr2[j]});
                visited[i + 1][j] = true;
            }
        }
        return result;

    }

    // not working
    public List<List<Integer>> optimalUsingTwoPointer(int[] arr1, int[] arr2, int k) {
        int i = 0;
        int n = arr1.length;
        int j = 0;
        int m = arr2.length;
        List<List<Integer>> list = new ArrayList<>();

        while (list.size() < k) {

            list.add(Arrays.asList(arr1[i], arr2[j]));

            if (i + 1 < n && j + 1 < m) {
                if (arr1[i] + arr2[j + 1] > arr1[i + 1] + arr2[j]) {
                    i++;
                } else j++;
            } else if (i + 1 < n) i++;
            else j++;
        }
        return list;

    }


    public List<List<Integer>> brute(int[] arr1, int[] arr2, int k) {
        List<List<Integer>> allpairs = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                List<Integer> list = new ArrayList<>();
                int num1 = arr1[i];
                int num2 = arr2[j];
                list.add(num1);
                list.add(num2);
                allpairs.add(list);
            }
        }

        allpairs.sort((a, b) -> {
            int sumA = a.stream().reduce(0, (x, y) -> x + y);
            int sumB = b.stream().reduce(0, (x, y) -> x + y);
            return Integer.compare(sumA, sumB);
        });
        return allpairs.subList(0, Math.min(allpairs.size(), k));
    }


    public static void main(String[] args) {
        FindKSmallestSumPairs fksp = new FindKSmallestSumPairs();
        // ✅ Test Case 1
        int[] arr1 = {1, 7, 11};
        int[] arr2 = {2, 4, 6};
        System.out.println("Test 1: " + fksp.optimalUsingPriorityQueue(arr1, arr2, 3));
        // Expected: [[1,2], [1,4], [1,6]]

        // ✅ Test Case 2
        int[] arr3 = {1, 1, 2};
        int[] arr4 = {1, 2, 3};
        System.out.println("Test 2: " + fksp.optimalUsingPriorityQueue(arr3, arr4, 2));
        // Expected: [[1,1], [1,1]]

        // ✅ Test Case 3
        int[] arr5 = {1, 2};
        int[] arr6 = {3};
        System.out.println("Test 3: " + fksp.optimalUsingPriorityQueue(arr5, arr6, 3));
        // Expected: [[1,3], [2,3]]

        // ✅ Test Case 4
        int[] arr7 = {5, 10, 15};
        int[] arr8 = {1, 2, 3};
        System.out.println("Test 4: " + fksp.optimalUsingPriorityQueue(arr7, arr8, 4));
        // Expected: [[5,1], [5,2], [5,3], [10,1]]

        // ✅ Test Case 5
        int[] arr9 = {1, 2};
        int[] arr10 = {3, 4, 5};
        System.out.println("Test 5: " + fksp.optimalUsingPriorityQueue(arr9, arr10, 10));
        // Expected: [[1,3], [1,4], [2,3], [1,5], [2,4], [2,5]]
    }
}

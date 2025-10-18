package stacks;

import java.util.*;

public class LargestRectangleHistogram {

    public int usingMonotanicStack(int[] arr){
        var ns = new NextSmallerElement();
        int max = 0;
        int[] nextSmellerElements = ns.usingMonotonicStack(arr);
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            int leftEnd = stack.isEmpty() ? 0 : stack.peek() +1;
            int rightEnd = nextSmellerElements[i] ;
            int width = rightEnd - leftEnd ;
            max = Math.max(width * arr[i] , max);

            stack.push(i);
        }
        return  max;


    }



    // brute opproch

    public  int brute(int[] arr) {
        // code here
        int max = 0;

        for(int i =0;i<arr.length;i++){
            int curNum = arr[i];
            int leftEnd = findleft( arr,i,curNum);
            int rightEnd = findRight(arr,i,curNum);
            int wight = rightEnd -leftEnd;
            max = Math.max(wight * curNum , max);
        }

        return max;

    }

    public int findleft(int[] nums ,int index,int num){
        while(index >= 0 && nums[index] >= num ) index--;
        return index +1 ;
    }
    public int findRight(int[] nums ,int index,int num){
        while( index < nums.length && nums[index] >= num ) index++;
        return index;
    }

    void main(){
        var lrh = new LargestRectangleHistogram();
        int[][] testCases = {
                {},                 // empty
                {42},               // single
                {5, 5, 5, 5, 5},    // uniform
                {1, 2, 3, 4, 5},    // increasing
                {5, 4, 3, 2, 1},    // decreasing
                {2, 1, 6, 1, 2, 1}, // peak
                {2, 4, 4, 4, 1},    // plateau
                {10000, 20000, 15000, 30000} // large
        };

        for (int[] nums : testCases) {
            System.out.println("Array: " + Arrays.toString(nums));
            System.out.println("Brute: " + lrh.brute(nums));
            System.out.println("Monotonic Stack: " + lrh.usingMonotanicStack(nums));
            System.out.println();
        }
    }
}

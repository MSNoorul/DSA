package Stacks;

import java.util.Arrays;
import java.util.Stack;

// 1 usingTweakedMonotanicStack - fint the next smallest element 50 20 10 [2 2 3]
// 2 usingMonotanicStack - fint the next smaller element 50 20 10 [1 2 3]

public class NextSmallerElement {


    public int[] usingTweakedMonotanicStack(int[] arr) {
        int n = arr.length;
        int[] ns = new int[n];
        Stack<Integer> stack = new Stack<>();

        //intial push
        ns[n - 1] = n;
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            int ps = stack.peek();
            if(arr[ps] < arr[i]) ns[i] = ps;
            else {ns[i] = n;stack.push(i);}
        }
        return ns;

    }

    public int[] usingMonotonicStack(int[] arr) {
        int n = arr.length;
        int[] ns = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);

        }
        return ns;
    }

    void main() {
        int[] nums = {60, 20, 50, 40, 10, 50, 60};
        NextSmallerElement nse = new NextSmallerElement();
        int[] result = nse.usingMonotonicStack(nums);
        int[] result2 = nse.usingTweakedMonotanicStack(nums);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }
}

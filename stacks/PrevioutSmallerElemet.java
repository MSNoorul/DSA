package stacks;

import java.util.Arrays;
import java.util.Stack;

public class PrevioutSmallerElemet {


    public  int[] usingMonotonicStack(int[] arr){
        int n = arr.length;
        int[] ns = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            ns[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);

        }
        return  ns;
    }

    void  main(){
        int[] nums = {60, 20, 50, 40, 10, 50, 60};
        PrevioutSmallerElemet nse = new PrevioutSmallerElemet();
        int[] result = nse.usingMonotonicStack(nums);
        System.out.println(Arrays.toString(result));
    }
}

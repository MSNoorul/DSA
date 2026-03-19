package DynamicPrograming;
import  java.util.*;

  /**
   * Given an array arr[] of integers and an integer sum, the task is to count all subsets
   * of the given array with a sum equal to a given sum.
   * Input:
   * N = 6
   * arr[] = {2, 3, 5, 6, 8, 10}
   * sum = 10
   * Output:
   * 3
   * Explanation:
   * {2, 3, 5}
   * {2, 8}
   * {10}
   * */

public class SubsetSumEqualsK {

    public List<List<Integer>> usingRecursion(int[] arr , int target){
        List<List<Integer>> list = new ArrayList<>();
        dfs(list , new ArrayList<>(), 0 , target,arr,0);
        return list;
    }

    public void dfs(List<List<Integer>> list , List<Integer> curList , int curSum , int target,int[] arr, int index){
        if(curSum > target || index > arr.length) return;
        if(curSum == target){
            list.add(new ArrayList<>(curList));
            return;
        }
        if(index == arr.length) return;
        curList.add(arr[index]);
        dfs(list,curList,curSum + arr[index],target,arr,index+1);
        curList.remove(curList.size()-1);
        dfs(list,curList,curSum,target,arr,index+1);

    }


    void main(){
        int[] arr = {2, 3, 5, 6, 8, 10};
        int t = 10;
        System.out.println(usingRecursion(arr,t));
    }

}

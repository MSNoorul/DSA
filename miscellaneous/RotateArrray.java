package miscellaneous;

import java.util.Arrays;

public class RotateArrray {

    public void brute(int[] arr , int k){
        int n = arr.length;
        for(int t=k;t>0;t--){
            int lastElemt = arr[n-1];
            for(int i=n-1;i>0;i--){
                arr[i] = arr[i-1];
            }
            arr[0] = lastElemt;
        }


    }

    void main(){
        RotateArrray ra = new RotateArrray();
        int[] arr = {1,2,3,4,5,6,7};
        ra.brute(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}

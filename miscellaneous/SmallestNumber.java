package miscellaneous;

public class SmallestNumber {

    // firt i need to check the number of 9 inide the number
    // then i want to make the last number as 1
    // before the i want cal the remaing


    public  String optimal(int s , int d){
        String ans = "";
        if(s == 0) return "0";
        if(s > (9 * d)) return "-1";
        s--; // for the last digit 1 to make that small number
        int[] digits = new int[d];
        int nineCount = s/9;
        int remaining = s%9;
        int index = d-1;

        // handle last 999
        while(nineCount >0){
            digits[index--] = 9;
            nineCount--;
        }
        // handle the next element in after 199
        if(index >=0) digits[index--] = remaining;

        //handle leading zero   00199
        while (index > 0){
            digits[index--] = 0;
        }
        digits[0] +=1;

        for(int num : digits){
            ans += num;
        }

        return ans;

    }
    //learnings
    // 1. use int [] because we need to increase 1 at last if we use string it is hard to increase for the test case like 20 , 3
    //2.decrease 1 at first because remaining will to zero in some case that makes the code complex to solve



    void main() {
        SmallestNumber sm = new SmallestNumber();
        System.out.println(sm.optimal(9,2));
        System.out.println(sm.optimal(20,2));
        System.out.println(sm.optimal(20,6));
        System.out.println(sm.optimal(0,2));

    }
}

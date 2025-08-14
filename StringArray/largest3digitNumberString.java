package StringArray;

public class largest3digitNumberString {

    class Solution {
    public String largestGoodInteger(String num) {
        for(int digit = 9; digit >= 0; digit--){
            String triple = String.valueOf(digit).repeat(3);

            if(num.contains(triple)){
                return triple;
            }
        }
        return "";
    }
}
}
package StringArray;

import java.util.HashSet;
import java.util.Set;

public class havingVowels {

    class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int vowelsCount = 0;
        int midIndex = s.length() / 2;

        for(int i = 0; i < midIndex; i++){
            char A = s.charAt(i);
            char B = s.charAt(midIndex + i);
            if(vowels.contains(A)) vowelsCount++;
            if(vowels.contains(B)) vowelsCount--;
        }
            return vowelsCount == 0;
    }
}
}
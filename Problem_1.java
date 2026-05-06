import java.util.*;

public class Problem_1 {
    public static int maxCyclicUniqueSum(String S) {
        int n = S.length();
        String T = S + S;  
        
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int currSum = 0;
        int maxSum = 0;
        
        for (int right = 0; right < T.length(); right++) {
            char ch = T.charAt(right);
            int val = ch - 'a' + 1;
          
            while (seen.contains(ch) || (right - left + 1) > n) {
                char remove = T.charAt(left);
                seen.remove(remove);
                currSum -= (remove - 'a' + 1);
                left++;
            }
            
            seen.add(ch);
            currSum += val;
            maxSum = Math.max(maxSum, currSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        String input = "abca";
        System.out.println(maxCyclicUniqueSum(input)); 
    }
}
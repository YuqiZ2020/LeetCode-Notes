/**
 * Problem 402: Maximum Subarray
 * Prompt: Given a non-negative integer num represented as 
 * a string, remove k digits from the number so that the new 
 * number is the smallest possible.
 * Date: 05/13/2020
 */
class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> nStack = new Stack<>();
        int len = num.length();
        int d = len - k; 
        int c = 0;
        for (int i = 0; i < len; ++i)
        {
            //Need enough digits to reach d
            while (!nStack.empty() && c + len - i > d && nStack.peek() > num.charAt(i))
            {
                nStack.pop();
                c--;
            }
            nStack.push(num.charAt(i));
            c++;
        }
        //Deal with edge cases of same numbers
        while (c > d)
        {
            nStack.pop();
            c--;
        }
        StringBuilder sb = new StringBuilder();
        while (!nStack.empty())
            sb.append(nStack.pop());
        sb.reverse();
        while(sb.length() > 1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        if (sb.length() == 0)
            return "0";
        return sb.toString();
    }
}
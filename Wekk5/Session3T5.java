class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int sign = 1;
        int result = 0;
         
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() &&
               s.charAt(i) >= '0' &&
               s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

          
            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 &&
                 digit > Integer.MAX_VALUE % 10)) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            result = result * 10 + digit;
            i++;
        }

        
        return result * sign;
    }
}

Input: s = "42"

Output: 42

/**
 * Problem 468: Validate IP Address
 * Prompt: Write a function to check whether an input string is a 
 * valid IPv4 address or IPv6 address or neither.
 * IPv4 addresses are canonically represented in dot-decimal 
 * notation, which consists of four decimal numbers, each ranging 
 * from 0 to 255, separated by dots ("."), e.g.,172.16.254.1; 
 * Besides, leading zeros in the IPv4 is invalid. For example, the
 * address 172.16.254.01 is invalid.
 * IPv6 addresses are represented as eight groups of four 
 * hexadecimal digits, each group representing 16 bits. The groups 
 * are separated by colons (":"). For example, the address 
 * 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. 
 * Also, we could omit some leading zeros among four hexadecimal
 * digits and some low-case characters in the address to upper-case 
 * ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 
 * address(Omit leading zeros and using upper cases).
 * However, we don't replace a consecutive group of zero value with 
 * a single empty group using two consecutive colons (::) to pursue 
 * simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an 
 * invalid IPv6 address.
 * Besides, extra leading zeros in the IPv6 is also invalid. For 
 * example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is 
 * invalid.
 * Date: 06/16/2020
 */
lass Solution {
    public String validIPAddress(String IP) {
        int countDot = 0;
        int countColon = 0;
        for (int i = 0; i < IP.length(); ++i)
        {
            if (IP.charAt(i) == '.')
                countDot++;
            else if (IP.charAt(i) == ':')
                countColon++;
        }
        if (countDot == 3)
        {
            String[] nums = IP.split("\\.", 4);
            for (int i = 0; i < 4; ++i)
            {
                if (!isIPv4(nums[i]))
                    return "Neither";
            }
            return "IPv4";
        }
        else if (countColon == 7)
        {
            String[] nums = IP.split("\\:", 8);
            for (int i = 0; i < 8; ++i)
            {
                if (!isIPv6(nums[i]))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }
    
    private static boolean isIPv4 (String s)
    {
         try
         { 
             return String.valueOf(Integer.valueOf(s)).equals(s) && 
                 Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
         }
         catch (NumberFormatException e){ return false; }
    }
    
    private static boolean isIPv6 (String s)
    {
        if (s.length() > 4) return false;
        try 
        {
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
        }
        catch (NumberFormatException e){return false;}
    }
}

/**
 * Notes: First count the number of '.' or ':' in the string to distinguish
 * the possible types of string. This utlizes the idea of divide and conquor. 
 * Then for each seperate string segment after spliting, for IPv4, need
 * to check if it is number by comparing the value offered by valueOf and
 * parseInt and also if it is smaller than or equal to 255.
 */
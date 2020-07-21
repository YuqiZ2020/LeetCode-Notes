class Solution {
public:
    string addBinary(string a, string b) {
        stringstream ss;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0)
        {
            int sum = carry;
            if (i >= 0) 
                sum += (int) a[i] - '0';
            if (j >= 0)
                sum += (int) b[j] - '0';
            ss << sum % 2;
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry)
            ss << carry;
        string s = ss.str();
        reverse(s.begin(), s.end());
        return s;
    }
};

/**
 * Notes: Use an int to store the addition result
 * by using if statement to see whether we need
 * to add another zero. Then we determine the value
 * for the current bit and the carry on digit. 
 * Finally we reverse our string and return. 
 * */

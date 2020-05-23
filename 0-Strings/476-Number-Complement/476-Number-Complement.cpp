/**
 * Problem 476: Number Complement
 * Prompt: Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * Date: 05/04/2020
 * */

#include <sstream>
#include <string>

using std::stringstream;

class Solution {
public:
    int findComplement(int num) {
        stringstream ss;
        while (num != 0)
        {
            int dig = num % 2;
            if (dig)
                ss << 0;
            else
                ss << 1;
            num = num / 2;            
        }
        string ans = ss.str();
        reverse(ans.begin(), ans.end());
        return stoi(ans,0,2);
    }
};

/**
 * Note: Since the algorithm of finding the binary representation
 * geneates the reverse of binaray representation, there needs
 * to be a reverse
 * Then use the function to convert it back to integer
 * */
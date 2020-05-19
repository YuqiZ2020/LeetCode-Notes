class Solution {
public:
    void duplicateZeros(vector<int>& A) {
        int n = A.size(), j = n + count(A.begin(), A.end(), 0);
        for (int i = n - 1; i >= 0; --i) {
            if (--j < n)
                A[j] = A[i];
            if (A[i] == 0 && --j < n)
                A[j] = 0;
        }
    }
};

/**
 * Notes: One pointer i loops from the end to the start of the array
 * The other pointer j start from the length + num of zeros and goes
 * backward. 
 * For each number they need to at most shift right x times 
 * (x = count(A.begin(), A.end(), 0))
 * Then j decrease each time with i decrease and do the replacement, 
 * when we meet a zero we duplicate it and then the subsequential
 * elements need to do x - 1 shifts, and so on, until j and i meets
 * the sustitution then finishes. 
 * */
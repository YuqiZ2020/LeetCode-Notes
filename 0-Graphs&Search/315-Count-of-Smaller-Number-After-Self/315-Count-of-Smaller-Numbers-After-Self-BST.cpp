class Solution {

class Node {
    public:
    int val;
    int freq;
    int leftChildSize;
    Node* left;
    Node* right;
    
    Node(int num)
    {
        val = num;
        freq = 1;
        leftChildSize = 0;
        left = nullptr;
        right = nullptr;
    }

};
public:
    vector<int> countSmaller(vector<int>& nums) {
        Node* root = nullptr;
        vector<int> ans;
        for (int i = nums.size() - 1; i >= 0; --i)
        {
            int counter = 0;
            root = insert(root, nums[i], &counter);
            ans.insert(ans.begin(), counter);
        }
        return ans;
    }
    
    Node* insert(Node* root, int num, int* count)
    {
        if (root == nullptr)
        {
            root = new Node(num);
            *count = 0;
            return root;
        }
        if (num == root->val)
        {
            root->freq++;
            *count = *count + root->leftChildSize;
        }
        else if (num < root->val)
        {
            root->left = insert(root->left, num, count);
            root->leftChildSize++;
        }
        else if (num > root->val)
        {
            root->right = insert(root->right, num, count);
            *count = *count + root->leftChildSize + root->freq;
        }
        return root;
            
    }
};
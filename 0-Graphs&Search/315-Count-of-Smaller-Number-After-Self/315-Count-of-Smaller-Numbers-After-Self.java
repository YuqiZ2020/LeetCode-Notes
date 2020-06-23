class Solution {
    public class AVLTree
    {
        public class Node 
        {
            private int size;
            private int height;
            private long val;
            int freq;
            Node left;
            Node right;

            Node(long num) 
            {
                val = num;
                size = 1;
                freq = 1;
                height = 0;
            }
            
            Node leftRotate() 
            {
                Node rightChild = this.right;
                this.right = rightChild.left;
                rightChild.left = this;
                this.fixSizeAndHeight();
                rightChild.fixSizeAndHeight();
                return rightChild;
            }
            
            Node rightRotate()
            {
                Node leftChild = this.left;
                this.left = leftChild.right;
                leftChild.right = this;
                this.fixSizeAndHeight();
                leftChild.fixSizeAndHeight();
                return leftChild;
            }
            
            void fixSizeAndHeight() 
            {
                this.fixSize();
                this.fixHeight();
            }

            private void fixSize() 
                { size = freq + getLeftSize() + getRightSize(); }
            private void fixHeight() 
                { height = 1 + Math.max(getLeftHeight(), getRightHeight()); }
            int getBalance() 
                { return getLeftHeight() - getRightHeight(); }
        
            int getLeftSize()
            {
                if (left != null)
                    return left.size;
                return 0;
            }
            int getRightSize()
            {
                if (right != null)
                    return right.size;
                return 0;
            }
            int getLeftHeight()
            {
                if (left != null)
                    return left.height;
                return 0;
            }
            int getRightHeight()
            {
                if (right != null)
                    return right.height;
                return 0;
            }
            
        }
        
        Node root;
        
        List<Integer> insert(int[] keys) 
        {
            int len = keys.length; 
            Integer[] ans = new Integer[len];
            for (int i = len - 1; i >= 0; --i)
            {
                int[] recordCount = new int[1];
                root = insert(root, keys[i], recordCount);
                ans[i] = recordCount[0];
            }
            return Arrays.asList(ans);
        }
        
        private Node insert(Node root, long key, int[] counter) 
        {
            if (root == null)
                return new Node(key);
            root.size++;
            if (root.val == key)
            {
                root.freq++;
                counter[0] = counter[0] + root.getLeftSize();
            }
            else if (key < root.val)
                root.left = insert(root.left, key, counter);
            else if (key > root.val)
            {
                root.right = insert(root.right, key, counter);
                counter[0] = counter[0] + root.getLeftSize() + root.freq;
            }
            balance();
            return root;
        }
        
        private void balance() 
        {
            root.fixSizeAndHeight();
            int balance = root.get··Balance();
            if (balance < -1)
            {
                int balanceR = root.right.getBalance();
                if (balanceR <= 0)
                    root = root.leftRotate();
                else
                {
                    root.right = root.right.rightRotate();
                    root = root.leftRotate();
                }
            }
            else if (balance > 1)
            {
                int balanceL = root.left.getBalance();
                if (balanceL >= 0)
                    root = root.rightRotate();
                else
                {
                    root.left = root.left.leftRotate();
                    root = root.rightRotate();
                }
            }
        }
        
    }
    
    public List<Integer> countSmaller(int[] nums) 
    {
        AVLTree tree = new AVLTree();
        List<Integer> ans = tree.insert(nums);
        return ans;
    }
}

/**
 * Notes: Use AVL to solve the problem. We start the insertion from 
 * end to front so each time we can count the numbers that are smaller
 * than the current number that are already in the tree by using the
 * property of BST. 
 * We count the size of left subtree for the current node. If we go 
 * into the right tree and get back, we need to update the count with 
 * the count number that got returned, the root frequency and the left 
 * subtree size. 
 * Then we would need to balance the tree after the insertion. First
 * we recalculate the height and size of the current root. Based on
 * height we see if the tree is balanced, by left height - right height. 
 * We would also see if the subtrees are balanced if the tree is not
 * balanced. 
 * If the left subtree is higher, but the left subtree itself has a higher 
 * right subtree, then we would be performing left rotation for left subtree
 * and then right rotation for the whole tree. Other wise we just perform
 * right rotation for the whole tree. 
 * Similiar for the other side. 
 */
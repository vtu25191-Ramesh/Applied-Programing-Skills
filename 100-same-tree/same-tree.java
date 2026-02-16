class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // both null
        if (p == null && q == null) return true;

        // one null or values differ
        if (p == null || q == null || p.val != q.val) return false;

        // compare left and right subtrees
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}

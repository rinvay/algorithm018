//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 749 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
    }

    private TreeNode myBuildTree(int[] preorder, int[] inorder,
                                 int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        //终结条件
        if(preorder_left > preorder_right) {
            return null;
        }
        //处理当前层
        //直接确定根节点，前序遍历第一个节点就是
        TreeNode root = new TreeNode(preorder[preorder_left]);
        //确定根节点在中序遍历中的位置
        int idx_inorder_root = idxMap.get(root.val);
        //左子树的节点数
        int size_left_sub = idx_inorder_root - inorder_left;

        //进入下一层
        root.left = myBuildTree(preorder, inorder, preorder_left+1, preorder_left+size_left_sub, inorder_left, idx_inorder_root-1);
        root.right = myBuildTree(preorder, inorder, preorder_left+size_left_sub+1, preorder_right, idx_inorder_root+1, inorder_right);

        return root;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

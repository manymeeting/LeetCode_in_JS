package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.

 Example:

 Input: [1,null,2,3]
 1
 \
 2
 /
 3

 Output: [1,3,2]
 Follow up: Recursive solution is trivial, could you do it iteratively?
 */

// 用stack模拟递归的遍历顺序，注意while循环的终止条，从叶节点开始思考比较容易
public class BinaryTreeInorderTraversal94 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return list;

        TreeNode curr = root;

        while(curr != null || !stack.empty())
        {
            if(curr == null)
            {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;
            }
            else
            {
                stack.push(curr);
                curr = curr.left;
            }

        }

        return list;
    }
}
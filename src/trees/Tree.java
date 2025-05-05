package trees;

import java.util.*;

public class Tree {

    public TreeNode construct(int[] arr) {
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode a = new TreeNode(arr[0]);
        q.offer(a);
        int i = 1;
        while (i < arr.length) {
            TreeNode temp = q.poll();
            temp.left = new TreeNode(arr[i]);
            q.offer(temp.left);
            i++;
            if (i < arr.length) {
                temp.right = new TreeNode(arr[i]);
                q.offer(temp.right);
                i++;
            }
        }
        return a;
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}

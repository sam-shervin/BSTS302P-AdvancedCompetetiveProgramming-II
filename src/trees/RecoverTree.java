package trees;

/*
    Problem Statement:
    ------------------
    You are given the root of a binary search tree (BST) in which exactly two nodes’
    values have been swapped by mistake. Recover the tree without changing its structure—
    i.e., by swapping the two incorrect values back so that the in‑order traversal
    yields a sorted sequence.

    Example:
      Input tree (in‑order): [1, 3, 2]
      Swapped nodes: 1 and 3
      After recovery → in‑order: [3, 1, 2]
*/

public class RecoverTree {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        Tree a = new Tree();

        TreeNode node = a.construct(arr);
        a.inorder(node);
    }

}

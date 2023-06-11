package org.example.tree;

/**
 * 判断两棵树的结构是否相同
 *
 * @className: AreStructurullySameTrees
 * @author: Max Solider
 * @date: 2023-06-11 19:36
 */
public class AreStructurullySameTrees {

    public static boolean areStructurullySameTrees(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        // 都不为空，则进行比较
        return areStructurullySameTrees(root1.getLeft(), root2.getLeft())
                && areStructurullySameTrees(root1.getRight(), root2.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        BinaryTreeNode node8 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node9 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node10 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node11 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node12 = new BinaryTreeNode(2, node8, node9);
        BinaryTreeNode node13 = new BinaryTreeNode(3, node10, node11);
        BinaryTreeNode node14 = new BinaryTreeNode(1, node12, node13);

        System.out.println(areStructurullySameTrees(node1, node14));
    }
}

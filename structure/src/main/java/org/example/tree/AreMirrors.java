package org.example.tree;

/**
 * 判断两颗二叉树是否互为镜像
 *
 * @className: AreMirrors
 * @author: Max Solider
 * @date: 2023-06-12 23:14
 */
public class AreMirrors {

    public static boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        }
        return areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft());
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);


        BinaryTreeNode node14 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node15 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node16 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node17 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node12 = new BinaryTreeNode(2, node15, node14);
        BinaryTreeNode node13 = new BinaryTreeNode(3, node17, node16);
        BinaryTreeNode node11 = new BinaryTreeNode(1, node13, node12);

        System.out.println(areMirrors(node1, node11));
    }
}

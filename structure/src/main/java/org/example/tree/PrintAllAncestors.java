package org.example.tree;

/**
 * 输出结点所有祖先结点
 *
 * @className: PrintAllAncestors
 * @author: Max Solider
 * @date: 2023-06-14 22:24
 */
public class PrintAllAncestors {

    public static boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode data) {
        if (root == null) {
            return false;
        }
        if (root.getLeft().getData() == data.getData() || root.getRight().getData() == data.getData()
                || printAllAncestors(root.getLeft(), data)
                || printAllAncestors(root.getRight(), data)) {
            System.out.println(root.getData());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        printAllAncestors(node1, node3);
        printAllAncestors(node1, node5);
    }
}

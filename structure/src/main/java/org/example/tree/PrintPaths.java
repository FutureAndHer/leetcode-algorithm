package org.example.tree;

/**
 * 输出所有从根结点到叶子结点的路径
 *
 * @className: PrintPaths
 * @author: Max Solider
 * @date: 2023-06-11 22:41
 */
public class PrintPaths {

    public static void printPaths(BinaryTreeNode root) {
        int[] path = new int[256];
        printPaths(root, path, 0);
    }

    private static void printPaths(BinaryTreeNode root, int[] path, int pathLen) {
        if (root == null) {
            return;
        }
        path[pathLen] = root.getData();
        pathLen++;
        if (root.getLeft() == null && root.getRight() == null) {
            printArray(path, pathLen);

        } else {
            printPaths(root.getLeft(), path, pathLen);
            printPaths(root.getRight(), path, pathLen);
        }
    }

    private static void printArray(int[] path, int pathLen) {
        for (int i = 0; i < pathLen; i++) {
            System.out.print(path[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
        BinaryTreeNode node5 = new BinaryTreeNode(5, null, null);
        BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
        BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);
        printPaths(node1);
    }
}

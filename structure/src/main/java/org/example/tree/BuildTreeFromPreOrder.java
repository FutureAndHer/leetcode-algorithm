package org.example.tree;

/**
 * 根据前序序列构建二叉树
 *
 * @className: BuildTreeFromPreOrder
 * @author: Max Solider
 * @date: 2023-06-17 09:21
 */
public class BuildTreeFromPreOrder {

    public static BinaryTreeNode buildTreeFromPreOrder(char[] array, int i) {
        if (array == null || i >= array.length) {
            return null;
        }
        if (array[i] == 'L') {
            return new BinaryTreeNode(array[i], null, null);
        }
        BinaryTreeNode root = new BinaryTreeNode(array[i], null, null);
        root.setLeft(buildTreeFromPreOrder(array, ++i));
        root.setRight(buildTreeFromPreOrder(array, ++i));
        return root;
    }

    public static void main(String[] args) {
        char[] array = new char[]{'I', 'L', 'I', 'L', 'L'};
        BinaryTreeNode root = buildTreeFromPreOrder(array, 0);
        BinaryTreeNode.preOrder(root);
    }
}

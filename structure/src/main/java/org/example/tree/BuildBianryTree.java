package org.example.tree;

/**
 * 根据前序遍历和中序遍历，构建二叉树
 *
 * @className: BuildBianryTree
 * @author: Max Solider
 * @date: 2023-06-13 22:27
 */
public class BuildBianryTree {

    // 根结点在先序遍历列表中的下标
    static int rootIndex = 0;

    /**
     * 根据先序遍历和中序遍历结果构建二叉树
     *
     * @param preOrder 先序遍历结果
     * @param inOrder  中序遍历结果
     * @return 二叉树构建结果
     */
    public static BinaryTreeNode buildBinaryTree(int[] preOrder, int[] inOrder) {

        // 需要扫描中序遍历列表的起始下标和结束下标
        int start = 0;
        int end = preOrder.length;
        return buildBinaryTree(preOrder, inOrder, start, end);
    }

    /**
     * 根据先序遍历和中序遍历结果构建二叉树
     *
     * @param preOrder 先序遍历结果
     * @param inOrder  中序遍历结果
     * @param start    需要扫描中序遍历列表的起始下标
     * @param end      需要扫描中序遍历列表的结束下标
     * @return 二叉树构建结果
     */
    public static BinaryTreeNode buildBinaryTree(int[] preOrder, int[] inOrder, int start, int end) {
        if (start == end - 1) {
            rootIndex++;
            return new BinaryTreeNode(inOrder[start], null, null);
        }
        int inIndex = 0;
        for (int i = start; i < end; i++) {
            if (inOrder[i] == preOrder[rootIndex]) {
                inIndex = i;
            }
        }
        BinaryTreeNode root = new BinaryTreeNode(preOrder[rootIndex], null, null);
        rootIndex++;
        root.setLeft(buildBinaryTree(preOrder, inOrder, start, inIndex));
        root.setRight(buildBinaryTree(preOrder, inOrder, inIndex + 1, end));
        return root;
    }

    public static void main(String[] args) {
        // 先序
        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};
        // 中序
        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};
        // 构建二叉树
        BinaryTreeNode node = buildBinaryTree(preOrder, inOrder);
        BinaryTreeNode.postOrder(node);
    }
}

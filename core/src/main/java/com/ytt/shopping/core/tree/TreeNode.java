package com.ytt.shopping.core.tree;

import lombok.Data;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 15:23 2019/6/10
 * @Modiflid By:
 */
@Data
public class TreeNode<T> {

    private T data;

    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;
    private TreeNode<T> parent;

    public TreeNode() {

    }

    public TreeNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                "\n";
    }
}

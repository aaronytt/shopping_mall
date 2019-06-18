package com.ytt.shopping.core.util;

import com.ytt.shopping.core.tree.BinaryTree;
import com.ytt.shopping.core.tree.TreeNode;

import java.util.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:48 2019/6/10
 * @Modiflid By:
 */
public class BinaryTreeUtil {

    public static <T> BinaryTree<T> buildBianaryTree(List<T> src){
        return new BinaryTree(){
            {
                buildBinaryTree(src);
            }
        };
    }

    /**
     * 前序遍历
     * @param treeNode
     * @param <T>
     * @return
     */
    public static <T> List<T> preorderTraversal(TreeNode<T> treeNode){
        List<T> list = new ArrayList();
        Stack<TreeNode<T>> stack = new Stack();
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                list.add(treeNode.getData());
                stack.push(treeNode);
                treeNode = treeNode.getLeftChild();
            }
            list.add(null);
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.getRightChild();
            }
        }
        return list;
    }

    /**
     * 中序遍历
     * @param root
     * @param <T>
     * @return
     */
    public static <T> List<T> sequenceTraversal(TreeNode<T> root){
        List<T> list = new ArrayList();
        Queue queue = new LinkedList<TreeNode<T>>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode<T> treeNode = new TreeNode();
            list.add(treeNode.getData());
            if(null != treeNode.getLeftChild()){
                queue.offer(treeNode.getLeftChild());
            }
            if(null != treeNode.getRightChild()){
                queue.offer(treeNode.getRightChild());
            }
        }
        return list;
    }

}

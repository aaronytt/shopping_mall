package com.ytt.shopping.core.util;

import com.ytt.shopping.core.tree.BinaryTree;

import java.util.List;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 18:48 2019/6/10
 * @Modiflid By:
 */
public class BinaryTreeUtil {

    public static <T> BinaryTree<T> getBianaryTree(List<T> src, int level){
        return new BinaryTree<T>(src,level);
    }

}
